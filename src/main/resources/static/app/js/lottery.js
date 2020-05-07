/* DaTouWang URL: www.datouwang.com */
new Vue({
    el: "#app",
    data: {
        isStart: 1,
        score: 10, //消耗积分
        list: [
            { title: '小明1' },
            { title: '小明2' },
            { title: '小明3' },
            { title: '小明4' },
            { title: '小明5' },
            { title: '小明6' },
            { title: '小明7' },
            { title: '小明8' },
            { title: '小明9' },
            { title: '小明10' },
            { title: '小明11' },
            { title: '小明12' },
            { title: '小明13' },
            { title: '小明14' },
            { title: '小明15' },
            { title: '小明16' },
            { title: '小明17' },
            { title: '小明18' },
            { title: '小明19' },
            { title: '小明20' },
            { title: '小明21' },
            { title: '小明22' },
            { title: '小明23' },
            { title: '小明24' },
            { title: '小明25' },
            { title: '小明26' },
            { title: '小明27' },
            { title: '小明28' },
            { title: '小明29' },
            { title: '小明30' },
        ], //奖品1-9     
        index: -1, // 当前转动到哪个位置，起点位置
        count: 30, // 总共有多少个位置
        timer: 0, // 每次转动定时器
        speed: 200, // 初始转动速度
        times: 0, // 转动次数
        cycle: 50, // 转动基本次数：即至少需要转动多少次再进入抽奖环节
        prize: -1, // 中奖位置
        click: true,
        showToast: false, //显示中奖弹窗        
    },

    mounted() {},

    methods: {
        startLottery() {
            if (!this.click) { return }
            this.startRoll();
        },
        // 开始转动
        startRoll() {
            this.times += 1 // 转动次数
            this.oneRoll() // 转动过程调用的每一次转动方法，这里是第一次调用初始化 
                // 如果当前转动次数达到要求 && 目前转到的位置是中奖位置
            if (this.times > this.count + 10 && this.prize === this.index) {
                clearTimeout(this.timer) // 清除转动定时器，停止转动
                this.prize = -1
                this.times = 0
                this.speed = 200
                this.click = true;
                var that = this;
                setTimeout(res => {
                    that.showToast = true;
                }, 500)
            } else {
                if (this.times < this.count) {
                    this.speed -= 10 // 加快转动速度
                } else if (this.times === this.count) {
                    const index = parseInt(Math.random() * this.count, 0) || 0; // 随机获得一个中奖位置
                    this.prize = index; //中奖位置,可由后台返回 
                    console.log(this.prize)
                    if (this.prize > this.count) { this.prize = this.count }
                } else if (this.times > this.count + 10 && ((this.prize === 0 && this.index === this.count) || this.prize === this.index + 1)) {
                    this.speed += 110
                } else {
                    this.speed += 10
                }
                if (this.speed < 40) { this.speed = 40 }
                console.log(this.speed)
                this.timer = setTimeout(this.startRoll, this.speed)
            }
        },

        // 每一次转动
        oneRoll() {
            let index = this.index // 当前转动到哪个位置
            const count = this.count // 总共有多少个位置
            index += 1
            if (index > count - 1) { index = 0 }
            this.index = index
        },
    }

})