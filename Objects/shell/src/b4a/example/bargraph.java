
package b4a.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class bargraph {
    public static RemoteObject myClass;
	public bargraph() {
	}
    public static PCBA staticBA = new PCBA(null, bargraph.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _checkboxes = null;
public static RemoteObject _checkedsales = null;
public static RemoteObject _color = null;
public static RemoteObject _legendpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _salepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _radiopanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _sortpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _radiolabelsalestitles = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _radiolabelsorttitles = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _radiolabellegendtitles = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _active1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ActivityWrapper");
public static RemoteObject _panel_l = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _sale_1 = null;
public static RemoteObject _sale_2 = null;
public static RemoteObject _sale_3 = null;
public static RemoteObject _product1 = null;
public static RemoteObject _legend1 = null;
public static RemoteObject _maxsales1 = RemoteObject.createImmutable(0);
public static RemoteObject _titlestring1 = RemoteObject.createImmutable("");
public static RemoteObject _comid1 = null;
public static RemoteObject _currentpage = RemoteObject.createImmutable(0);
public static RemoteObject _itemsperpage = RemoteObject.createImmutable(0);
public static RemoteObject _btnnext = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnback = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _sortbtn1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _sortbtn2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _defbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _sales1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _sales2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _sales3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _layout = RemoteObject.createImmutable("");
public static RemoteObject _isfirstinit = RemoteObject.createImmutable(false);
public static RemoteObject _sortmainpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _showhidebtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _paginationlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pageno = RemoteObject.createImmutable(0);
public static RemoteObject _totalpages = RemoteObject.createImmutable(0);
public static RemoteObject _hideshowboolean = RemoteObject.createImmutable(false);
public static b4a.example.main _main = null;
public static b4a.example.branch _branch = null;
public static b4a.example.device _device = null;
public static b4a.example.starter _starter = null;
public static b4a.example.httputils2service _httputils2service = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"Active1",_ref.getField(false, "_active1"),"btnBack",_ref.getField(false, "_btnback"),"btnNext",_ref.getField(false, "_btnnext"),"checkBoxes",_ref.getField(false, "_checkboxes"),"checkedSales",_ref.getField(false, "_checkedsales"),"color",_ref.getField(false, "_color"),"comId1",_ref.getField(false, "_comid1"),"currentPage",_ref.getField(false, "_currentpage"),"defBtn",_ref.getField(false, "_defbtn"),"hideShowBoolean",_ref.getField(false, "_hideshowboolean"),"isFirstInit",_ref.getField(false, "_isfirstinit"),"itemsPerPage",_ref.getField(false, "_itemsperpage"),"layout",_ref.getField(false, "_layout"),"legend1",_ref.getField(false, "_legend1"),"legendPanel",_ref.getField(false, "_legendpanel"),"maxSales1",_ref.getField(false, "_maxsales1"),"pageNo",_ref.getField(false, "_pageno"),"paginationLabel",_ref.getField(false, "_paginationlabel"),"panel_l",_ref.getField(false, "_panel_l"),"product1",_ref.getField(false, "_product1"),"radioLabelLegendTitles",_ref.getField(false, "_radiolabellegendtitles"),"radioLabelSalesTitles",_ref.getField(false, "_radiolabelsalestitles"),"radioLabelSortTitles",_ref.getField(false, "_radiolabelsorttitles"),"radioPanel",_ref.getField(false, "_radiopanel"),"sale_1",_ref.getField(false, "_sale_1"),"sale_2",_ref.getField(false, "_sale_2"),"sale_3",_ref.getField(false, "_sale_3"),"salePanel",_ref.getField(false, "_salepanel"),"sales1",_ref.getField(false, "_sales1"),"sales2",_ref.getField(false, "_sales2"),"sales3",_ref.getField(false, "_sales3"),"showHideBtn",_ref.getField(false, "_showhidebtn"),"sortBtn1",_ref.getField(false, "_sortbtn1"),"sortBtn2",_ref.getField(false, "_sortbtn2"),"sortMainpanel",_ref.getField(false, "_sortmainpanel"),"sortPanel",_ref.getField(false, "_sortpanel"),"titleString1",_ref.getField(false, "_titlestring1"),"totalPages",_ref.getField(false, "_totalpages")};
}
}