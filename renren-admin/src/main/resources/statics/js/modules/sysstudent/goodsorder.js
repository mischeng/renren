 $(function () {
     var inTime;
     var outTime;
     var aaa;
     var bbb;
     function compareDate(d1, d2) {  // 时间比较的方法，如果d1时间比d2时间大，则返回true
         return ((new Date(d1.replace(/-/g,"\/")))>(new Date(d2.replace(/-/g,"\/"))));
     }






     $("#apa").click(function () {
         console.log(inTime)
         console.log(outTime)
         console.log(aaa)

         var count=0;

         d.x.splice(0,d.x.length)
         d.y.splice(0,d.y.length)

         $.get("../../sysstudent/goodsorder/findorderId").done(function (data) {

             $.each(data, function (a) {
                 console.log(a)
                 if (count < 5 && compareDate(data[a].time,aaa)==true && compareDate(bbb,data[a].time )==true){
                     count++;
                     d.x.push(data[a].goodsName);
                     d.y.push(data[a].amount);
                 }
                 chart(d);


             })


     })
     })

     var d={
         x:[],
         y:[]
     };

     /*var parserDate = function (date) {
         var t = Date.parse(date);
         if (!isNaN(t)) {
             return new Date(Date.parse(date.replace(/-/g, "/")));
         } else {
             return new Date();
         }
     };*/

     $( "#from" ).datepicker({
         defaultDate: "+1w",
         changeMonth: true,
         numberOfMonths: 3,
         dateFormat:'yy-mm-dd',
         onClose: function( selectedDate ) {
             $( "#to" ).datepicker( "option", "minDate", selectedDate );
              inTime = $("#from").datepicker('getDate');

             var d = new Date(inTime);
             aaa = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' + d.getHours()

                 + ':' + d.getMinutes() + ':' + d.getSeconds();

             console.log(inTime);
             console.log(aaa);
             console.log(inTime);


         }

     });

     $( "#to" ).datepicker({
         defaultDate: "+1w",
         changeMonth: true,
         numberOfMonths: 3,
         dateFormat:'yy-mm-dd',
         onClose: function( selectedDate ) {
             $( "#from" ).datepicker( "option", "maxDate", selectedDate );
              outTime = $("#to").datepicker('getDate');
             var d = new Date(outTime);
             bbb = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' + d.getHours()

                 + ':' + d.getMinutes() + ':' + d.getSeconds();

             console.log(outTime);
         }


     });

     $.get("../../sysstudent/goodsorder/findorderId").done(function (data) {



         console.log(data)
         console.log("kkkkk")


         $.each(data, function (a) {
             console.log(a)
             if (a < 5) {
                 d.x.push(data[a].goodsName);
                 d.y.push(data[a].amount);
             }
             chart(d);


         })

     })


         })







function chart(obj) {
    var chart = {
        type: 'column'
    };
    var title = {
        text: '销量前五'
    };
    var subtitle = {
        text: '💗简单购'
    };
    var xAxis = {
        categories: obj.x,
        crosshair: true
    };
    var yAxis = {
        min: 0,
        title: {
            text: '销售量'
        }
    };
    var tooltip = {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    };
    var plotOptions = {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        }
    };
    var credits = {
        enabled: false
    };

    var series = [{
        name: 'amount',
        data: obj.y
    }
    ];

    var json = {};
    json.chart = chart;
    json.title = title;
    json.subtitle = subtitle;
    json.tooltip = tooltip;
    json.xAxis = xAxis;
    json.yAxis = yAxis;
    json.series = series;
    json.plotOptions = plotOptions;
    json.credits = credits;
    $('#container').highcharts(json);

}


 /*$(function() {
     $( "#from" ).datepicker({
         defaultDate: "+1w",
         changeMonth: true,
         numberOfMonths: 3,
         onClose: function( selectedDate ) {
             $( "#to" ).datepicker( "option", "minDate", selectedDate );
             var inTime = $("#from").datepicker('getDate');
             console.log(inTime);
         }

     });
     $( "#to" ).datepicker({
         defaultDate: "+1w",
         changeMonth: true,
         numberOfMonths: 3,

         onClose: function( selectedDate ) {
             $( "#from" ).datepicker( "option", "maxDate", selectedDate );
             var outTime = $("#to").datepicker('getDate');
             console.log(outTime);
         }

     });

 });*/


/*
$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sysstudent/goodsorder/list',
        datatype: "json",
        colModel: [			
			{ label: 'orderId', name: 'orderId', index: 'order_id', width: 50, key: true },
			{ label: '', name: 'goodsId', index: 'goods_id', width: 80 }, 			
			{ label: '', name: 'norm', index: 'norm', width: 80 }, 			
			{ label: '', name: 'time', index: 'time', width: 80 }, 			
			{ label: '', name: 'money', index: 'money', width: 80 }, 			
			{ label: '', name: 'amount', index: 'amount', width: 80 }			
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
		showList: true,
		title: null,
		goodsOrder: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.goodsOrder = {};
		},
		update: function (event) {
			var orderId = getSelectedRow();
			if(orderId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(orderId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.goodsOrder.orderId == null ? "sysstudent/goodsorder/save" : "sysstudent/goodsorder/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.goodsOrder),
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
			var orderIds = getSelectedRows();
			if(orderIds == null){
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
                        url: baseURL + "sysstudent/goodsorder/delete",
                        contentType: "application/json",
                        data: JSON.stringify(orderIds),
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
		getInfo: function(orderId){
			$.get(baseURL + "sysstudent/goodsorder/info/"+orderId, function(r){
                vm.goodsOrder = r.goodsOrder;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}



	}
});

*/
