$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'goods/goods/list',
        datatype: "json",
        colModel: [			
			// { label: '', name: 'goodsId', index: 'goods_id', width: 80 ,height:80},
			{ label: '', name: 'goodsName', index: 'goods_name', width: 80,height:80 },
			{ label: '', name: 'textarea', index: 'textarea', width: 80 ,height:80},
			{ label: '', name: 'price', index: 'price', width: 80 ,height:80},
            { label: '', name: 'amount', index: 'amount', width: 80 ,height:80},
            { label: 'number', name: 'number', index: 'number', width: 50, key: true },
            { label: '', name: 'status', index: 'status', width: 80 ,height:80},
			{ label: '',  name: 'image',  width: 80 ,formatter:imageFormat,height:80},
            // { label: '', name: 'cataloguetwoId', index: 'cataloguetwo_id', width: 80,height:80 },
            { label: '', name: 'time', index: 'time', width: 80 ,height:80},

        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});
function imageFormat(cellvalue,options,rowObject) {
    if (cellvalue!=null)
    {
        return '<img src="'+cellvalue+'"style="width:70px;height:70px;"/>';

    }else return"无图片"
}
var vm = new Vue({
	el:'#rrapp',
	data:{
        q:{
            goodsName: null
        },
        update1:false,
        save1:false,
		showList: true,

        url:"http://127.0.0.1:8080/renren-admin/goods/goods/save",
		title: null,
		goods: {}
	},

	methods: {
        exportexcel:function(){
            window.location.href=baseURL+"goods/goods/exportexcel"
        },

		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.save1=true;
			vm.update1=false;
            vm.url="http://127.0.0.1:8080/renren-admin/goods/goods/save";
			vm.title = "新增";

			vm.goods = {};
		},
		update: function (event) {
			var number = getSelectedRow();
			if(number == null){
				return ;
			}
            vm.showList = false;
            vm.save1=false;
            vm.update1=true;

            vm.title = "修改";
            vm.url="http://127.0.0.1:8080/renren-admin/goods/goods/update"
            vm.getInfo(number)
		},
		saveOrUpdate: function (event) {

		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.goods.number == null ? "goods/goods/save" : "goods/goods/update";

                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",

                    data: JSON.stringify(vm.goods),
                    success: function(r){
                        if(r.code === 0){
                             layer.msg("操作成功", {icon: 1});
                             vm.reload();
                             $('#btnSaveOrUpdate').button('reset');
                             $('#btnSaveOrUpdate').dequeue();
                        }else{
                            layer.alert(r.msg);
                            $('#btnSaveOrUpdate').button('reset');
                            $('#btnSaveOrUpdate').dequeue();
                        }
                    }
                });
			});
		},
		del: function (event) {
			var numbers = getSelectedRows();
			if(numbers == null){
				return ;
			}
			var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定','取消'] //按钮
            }, function(){
               if(!lock) {
                    lock = true;
		            $.ajax({
                        type: "POST",
                        url: baseURL + "goods/goods/delete",
                        contentType: "application/json",
                        data: JSON.stringify(numbers),
                        success: function(r){
                            if(r.code == 0){
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            }else{
                                layer.alert(r.msg);
                            }
                        }
				    });
			    }
             }, function(){
             });
		},
		getInfo: function(number){
			$.get(baseURL + "goods/goods/info/"+number, function(r){
                vm.goods = r.goods;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'goodsName': vm.q.goodsName},
                page:page
            }).trigger("reloadGrid");
		}

	}
});