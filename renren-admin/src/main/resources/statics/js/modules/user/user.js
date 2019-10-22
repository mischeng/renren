$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'mis/user/list',
        datatype: "json",
        colModel: [			
			{ label: 'number', name: 'number', index: 'number', width: 50, key: true },
			{ label: '用户ID', name: 'userId', index: 'user_id', width: 80 },
			{ label: '用户名', name: 'userName', index: 'user_name', width: 80 },
			{ label: '密码', name: 'userPassword', index: 'user_password', width: 80 },
			{ label: '密保问题', name: 'question', index: 'question', width: 80 },
			{ label: '密保答案', name: 'answer', index: 'answer', width: 80 },
			{ label: '电话', name: 'phone', index: 'phone', width: 80 },
			{ label: '相片', name: 'images', index: 'images', width: 80 }
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

var vm = new Vue({
	el:'#rrapp',
	data:{
        q: {
            userName: null
        },
		showList: true,
		title: null,
		user: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.user = {};
		},
		update: function (event) {
			var number = getSelectedRow();
			if(number == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(number)
		},
		saveOrUpdate: function (event) {
			var url = vm.user.number == null ? "mis/user/save" : "mis/user/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.user),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var numbers = getSelectedRows();
			if(numbers == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "mis/user/delete",
                    contentType: "application/json",
				    data: JSON.stringify(numbers),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(number){
			$.get(baseURL + "mis/user/info/"+number, function(r){
                vm.user = r.user;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData: {'userName': vm.q.userName},
                page:page
            }).trigger("reloadGrid");
		},

        export2:function () {
            window.location.href=baseURL + "mis/user/exportexce2";
        }
	}
});