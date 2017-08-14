<!doctype html>
<html>
    <#include "common/common.header.ftl" >
	<body style="margin: 1px">
		
		<table id="dg" title="销售机会信息管理" class="easyui-datagrid"
	       fitColumns="true" pagination="true" rownumbers="true"
	       url="${ctx}/sale_chance/list" fit="true" toolbar="#tb">
		    <thead>
		    <tr>
		        <th field="cb" checkbox="true" align="center"></th>
		        <th field="id" width="50" align="center">编号</th>
		        <th field="chanceSource" width="200" align="center" hidden="true" >机会来源</th>
		        <th field="customerId" width="50" align="center" hidden="true">客户ID</th>
		        <th field="customerName" width="100" align="center">客户名称</th>
		        <th field="cgjl" width="50" align="center" hidden="true">成功几率</th>
		        <th field="overview" width="200" align="center">概要</th>
		        <th field="linkMan" width="100" align="center">联系人</th>
		        <th field="linkPhone" width="100" align="center">联系电话</th>
		        <th field="description" width="200" align="center" hidden="true">机会描述</th>
		        <th field="createMan" width="100" align="center">创建人</th>
		        <th field="createDate" width="100" align="center">创建时间</th>
		        <th field="assignMan" width="200" align="center" >指派人</th>
		        <th field="assignTime" width="200" align="center" hidden="true">指派时间</th>
		        <th field="state" width="100" align="center" formatter="formatState" >状态</th>
		        <th field="devResult" width="200" align="center" hidden="true">客户开发状态</th>
		    </tr>
		    </thead>
		</table>
		
		<#--工具栏-->
		<div id="tb">
			<div>
				<a href="javascript:openSaleChanceAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">创建</a>
	        	<a href="javascript:openSaleChanceModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
	        	<a href="javascript:deleteSaleChance()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		    </div>
		    <div>
		        &nbsp;客户名称：&nbsp;<input type="text" id="s_customerName" size="20" onkeydown="if(event.keyCode==13) searchSaleChance()"/>
		        &nbsp;概要：&nbsp;<input type="text" id="s_overview" size="20" onkeydown="if(event.keyCode==13) searchSaleChance()"/>
		        &nbsp;创建人：&nbsp;<input type="text" id="s_createMan" size="20" onkeydown="if(event.keyCode==13) searchSaleChance()"/>
		        &nbsp;分配状态：&nbsp;<select class="easyui-combobox" id="s_state" editable="false" panelHeight="auto" >
		        <option value="">请选择...</option>
		        <option value="0">未分配</option>
		        <option value="1">已分配</option>
		    </select>
		        <a href="javascript:searchSaleChance()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		    </div>
		</div>
		
		
	</body>
	<script src="${ctx}/js/sale.chance.js" ></script>
</html>