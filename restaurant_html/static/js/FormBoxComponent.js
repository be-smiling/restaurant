/**
 *  基于vue组件化封装
 *  表单弹窗组件
 */
Vue.component('form-box-comm', {
    //模板
    template: `
 <div v-if="isShow || formType>0" :class="formClass">
    <div class="button_group line" @mousedown="moveForm">
        <label>{{boxTitle}}</label><span v-if="formType<1 || !formType"  @click="closeForm">关闭</span>
    </div>
    <slot>
         <div  style="margin: 10px; 
                      line-height: 20px;
                      color: red;
                      text-align: center">在此处添加表单具体的元素</div>
    </slot>
    <div class="button_group">
        <el-button size="mini" type="success" @click="save" >保存</el-button>
        <el-button size="mini" @click="closeForm">取消</el-button>
    </div>
</div>
`,
    //组件内数据
    data() {
        return{
            isShow: false,
            //默认是浮动的表单
            //VUE绑定CSS有了解，要对拖动布局模式有了解。
            formClass:['model_form',"flow"],
        }
    },
    /*
        is-show 表单显示与否
        box-title 表单标题
        add-api-url 新增数据的API URL
        edit-api-url 编辑编辑数据的API URL,如果和新增相同，可执行同一个参数
        model 表单模型
        id-key 表单唯一主键，如ID
        validate 方法：表单验证事件，如果没有验证可以不指定
        success  方法：表单保存数据成功后执行事件，如果没有可以不执行
     */
    //接收父组件的值
    //注意参数传入时，是支持驼峰命名
    //addUrl是add-url，boxTitle是box-title
    props: {
        //表单显示类型，不传值时候，默认是弹窗浮动的。
        //传1，是普通表单，就是显示在上方。
        //传2，继续改进其他的方案，暂时预留 TODO
        formType:null,
        //标题
        boxTitle: "新增",
        //表单模型
        model: null,
        //ID_KEY,表单唯一标识符，如ID
        idKey: null,
        //新增地址
        addApiUrl: null,
        //编辑地址
        editApiUrl: null,

        //验证函数
        onValidate:{
            type:Function,
            default: null
        },

        //保存前执行
        beforeSave:{
            type:Function,
            default: null
        },

        //保存成功后执行函数
        onSuccess : {
            type:Function,
            default: null
        }
    },
    created(){
        //通过表单类型控制表单展现方式，默认是弹屏浮动
        switch (this.formType) {
            case 1: {
                //普通
                this.formClass = ['model_form'];
            }; break;
            case 2:{
                //预留
            }; break;
        }
    },

    methods: {
        /**
         * 保存数据，包括新增、和编辑
         */
        save() {
            if (this.model) {

                //保存执行前,如果有挂载，则执行。
                if(this.beforeSave){
                    let rs = this.beforeSave(this.model);
                    if(rs){
                        this.model = rs;
                    }
                }

                //表单验证，如果有挂载，则执行
                if(this.onValidate) {
                    let validate = this.onValidate(this.model);
                    //如果验证通过
                    if(validate){
                        this.doSaveOrUpdate();
                    }
                }else{
                    this.doSaveOrUpdate();
                }
            } else {
                alert("表单没有任何数据！");
            }
        },

        /**
         * 执行保存或更新
         */
        doSaveOrUpdate() {
            //决定走新增还是修改
            if (this.idKey == null && this.addApiUrl != null) {
                this.add();
            } else if(this.idKey != null && this.editApiUrl != null) {
                this.edit();
            }
        },

        //新增
        add() {
            axios.post(this.addApiUrl, this.model).then(rs => {
                if (rs.data.code == 0) {
                    //具体执行父组件内方法
                    if(this.onSuccess){
                        this.onSuccess(rs.data);
                    }
                    //方案2：通过this.$emit调用执行父组件函数
                    //this.$emit('on-success');

                } else {
                    alert(rs.data.msg);
                }
            }).catch(err => {
                console.log(err);
            });
        },

        /**
         * 编辑
         * @param item
         */
        edit() {

            axios.put(this.editApiUrl, this.model).then(rs => {
                if (rs.data.code == 0) {
                    //具体执行父组件内方法
                    if(this.onSuccess){
                        this.onSuccess(rs.data);
                    }
                    //方案2：通过this.$emit调用执行父组件函数
                    //this.$emit('on-success');
                } else {
                    alert(rs.data.msg);
                }
            }).catch(err => {
                console.log(err);
            });
        },


        /**
         * 显示窗体
         */
        showForm() {
            this.isShow = true;
        },

        /**
         * 关闭窗体
         */
        closeForm() {
            this.isShow = false;
        },

        /**
         * 拖动
         * @param event
         */
        moveForm(event) {
            //获取目标元素的父元素的父元素
            let targetBox = event.target.parentNode.parentNode;

            //被拖动的对象初始位置
            let boxLeft = targetBox.offsetLeft;
            let boxTop = targetBox.offsetTop;

            //鼠标初始位置
            let mx = event.clientX;
            let my = event.clientY;

            // 算出鼠标相对元素的位置，因为鼠标必须在盒子内部点击拖动
            // 所以鼠标的x、y值会比盒子大，两者相减得到两者的相对位置
            let dx = mx - boxLeft;
            let dy = my - boxTop;

            //鼠标按下并移动的事件
            document.onmousemove = event => {
                //移动当前元素,鼠标当前的位置减去两者的相对距离
                targetBox.style.left = (event.clientX - dx) + 'px';
                targetBox.style.top = (event.clientY - dy) + 'px';
            };
            //鼠标松开时，停留
            document.onmouseup = (event) => {
                document.onmousemove = null;
                document.onmouseup = null;
            };
        }
    }
});