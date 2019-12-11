class CollapasingBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<View>() {

    private var startPositionX: Float = 0f
    private var startPositionY: Float = 0f
    private var startToolbarHeight: Int = 0

    private var initialised = false

    private var amountOfToolbarToMove: Float = 0f
    private var amountToMoveXPosition: Float = 0f
    private var amountToMoveYPosition: Float = 0f

    var destPositionX: Float = 0f
    var destPositionY: Float = 0f
    var destToolbarHeight: Float = 0f


    init {
        if (attrs != null) {
            val attr = context.obtainStyledAttributes(attrs, R.styleable.CollapsingBehavior)

            destPositionX = attr.getDimension(R.styleable.CollapsingBehavior_destPositionX, 0f)
            destPositionY = attr.getDimension(R.styleable.CollapsingBehavior_destPositionY, 0f)
            destToolbarHeight = attr.getDimension(R.styleable.CollapsingBehavior_destToolbarHeight, 0f)

            attr.recycle()
        }
    }

    override fun layoutDependsOn(
            parent: CoordinatorLayout,
            child: View,
            dependency: View): Boolean {

        return dependency is AppBarLayout
    }

    override fun onDependentViewChanged(
            parent: CoordinatorLayout,
            child: View,
            dependency: View): Boolean {

        initProperties(child, dependency)

        // 현재 툴바 높이 dependency.y는 절대값이 아니라 상대적인 위치의 값이 나온다.
        var currentToolbarHeight = startToolbarHeight + dependency.y
        
        // 현재 툴바 높이가 최종 높이에 도달했는지 검사
        currentToolbarHeight = if (currentToolbarHeight <= destToolbarHeight) destToolbarHeight else currentToolbarHeight
        
        //이미 움직인 툴바의 높이를 계산
        val amountAlreadyMoved = startToolbarHeight - currentToolbarHeight
        
        //움직여야할 툴바의 높이에서 얼마나 움직였는지 퍼센트를 기억
        val progress = 100 * amountAlreadyMoved / amountOfToolbarToMove

        //움직여야할 대상이 툴바의 총 진행상황에 따라 위치가 변하는 것을 계산
        val distanceXToSubtract = progress * amountToMoveXPosition / 100
        val distanceYToSubtract = progress * amountToMoveYPosition / 100

        child.x = startPositionX - distanceXToSubtract
        child.y = startPositionY - distanceYToSubtract

        return true
    }

    private fun initProperties(
            child: View,
            dependency: View) {

        if (!initialised) {
        
            //움직여야할 대상의 스타트 포지션 저장
            startPositionX = child.x
            startPositionY = child.y
            
            //툴바의 첫 높이 저장
            startToolbarHeight = dependency.height
            //툴바의 첫 높이와 마지막 높이를 이용해서 얼마나 움직여야할지 저장
            amountOfToolbarToMove = startToolbarHeight - destToolbarHeight

            //움직여야할 대상이 x,y 로 얼마나 이동해야하는지 저장
            amountToMoveXPosition = if (destPositionX == 0f) 0f else startPositionX - destPositionX
            amountToMoveYPosition = if (destPositionY == 0f) 0f else startPositionY - destPositionY

            initialised = true
        }
    }
}
