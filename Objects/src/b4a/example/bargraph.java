package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class bargraph extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.bargraph");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.bargraph.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[] _checkboxes = null;
public boolean[] _checkedsales = null;
public int[] _color = null;
public anywheresoftware.b4a.objects.PanelWrapper _legendpanel = null;
public anywheresoftware.b4a.objects.ActivityWrapper _active1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel_l = null;
public int[] _sale_1 = null;
public int[] _sale_2 = null;
public int[] _sale_3 = null;
public String[] _product1 = null;
public String[] _legend1 = null;
public int _maxsales1 = 0;
public String _titlestring1 = "";
public int[] _comid1 = null;
public int _currentpage = 0;
public int _itemsperpage = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _btnnext = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnback = null;
public String _layout = "";
public b4a.example.main _main = null;
public b4a.example.device _device = null;
public b4a.example.starter _starter = null;
public b4a.example.branch _branch = null;
public b4a.example.httputils2service _httputils2service = null;
public String  _initialize(b4a.example.bargraph __ref,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _active,anywheresoftware.b4a.objects.PanelWrapper _panel,int[] _sale1,int[] _sale2,int[] _sale3,String[] _product,String[] _legend,int _maxsales,String _titlestring,int[] _comid,String _layout1,anywheresoftware.b4a.objects.ButtonWrapper _nextbtn,anywheresoftware.b4a.objects.ButtonWrapper _backbtn) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_active,_panel,_sale1,_sale2,_sale3,_product,_legend,_maxsales,_titlestring,_comid,_layout1,_nextbtn,_backbtn}));}
int _legendwidth = 0;
int _i = 0;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cdback = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cdnext = null;
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Public Sub Initialize(Active As Activity, panel As";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="If Active.IsInitialized = False Then";
if (_active.IsInitialized()==__c.False) { 
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="Log(\"Error: Activity is not initialized\")";
__c.LogImpl("1655362","Error: Activity is not initialized",0);
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="Active1 = Active";
__ref._active1 /*anywheresoftware.b4a.objects.ActivityWrapper*/  = _active;
RDebugUtils.currentLine=655366;
 //BA.debugLineNum = 655366;BA.debugLine="panel_l = panel";
__ref._panel_l /*anywheresoftware.b4a.objects.PanelWrapper*/  = _panel;
RDebugUtils.currentLine=655367;
 //BA.debugLineNum = 655367;BA.debugLine="sale_1 = sale1";
__ref._sale_1 /*int[]*/  = _sale1;
RDebugUtils.currentLine=655368;
 //BA.debugLineNum = 655368;BA.debugLine="sale_2 = sale2";
__ref._sale_2 /*int[]*/  = _sale2;
RDebugUtils.currentLine=655369;
 //BA.debugLineNum = 655369;BA.debugLine="sale_3 = sale3";
__ref._sale_3 /*int[]*/  = _sale3;
RDebugUtils.currentLine=655370;
 //BA.debugLineNum = 655370;BA.debugLine="product1 = product";
__ref._product1 /*String[]*/  = _product;
RDebugUtils.currentLine=655371;
 //BA.debugLineNum = 655371;BA.debugLine="legend1 = legend";
__ref._legend1 /*String[]*/  = _legend;
RDebugUtils.currentLine=655372;
 //BA.debugLineNum = 655372;BA.debugLine="maxSales1 = maxSales";
__ref._maxsales1 /*int*/  = _maxsales;
RDebugUtils.currentLine=655373;
 //BA.debugLineNum = 655373;BA.debugLine="titleString1 = TitleString";
__ref._titlestring1 /*String*/  = _titlestring;
RDebugUtils.currentLine=655374;
 //BA.debugLineNum = 655374;BA.debugLine="comId1 = comId";
__ref._comid1 /*int[]*/  = _comid;
RDebugUtils.currentLine=655375;
 //BA.debugLineNum = 655375;BA.debugLine="layout = layout1";
__ref._layout /*String*/  = _layout1;
RDebugUtils.currentLine=655376;
 //BA.debugLineNum = 655376;BA.debugLine="btnNext = NextBtn";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/  = _nextbtn;
RDebugUtils.currentLine=655377;
 //BA.debugLineNum = 655377;BA.debugLine="btnBack = Backbtn";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/  = _backbtn;
RDebugUtils.currentLine=655378;
 //BA.debugLineNum = 655378;BA.debugLine="If sale1.Length <> product.Length Or sale2.Length";
if (_sale1.length!=_product.length || _sale2.length!=_product.length || _sale3.length!=_product.length) { 
RDebugUtils.currentLine=655379;
 //BA.debugLineNum = 655379;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=655382;
 //BA.debugLineNum = 655382;BA.debugLine="legendPanel.Initialize(\"\")";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .Initialize(ba,"");
RDebugUtils.currentLine=655383;
 //BA.debugLineNum = 655383;BA.debugLine="legendPanel.Width = panel.Width";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setWidth(_panel.getWidth());
RDebugUtils.currentLine=655384;
 //BA.debugLineNum = 655384;BA.debugLine="legendPanel.Height = 30dip";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setHeight(__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=655386;
 //BA.debugLineNum = 655386;BA.debugLine="Dim legendWidth As Int = legendPanel.Width / lege";
_legendwidth = (int) (__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()/(double)_legend.length);
RDebugUtils.currentLine=655387;
 //BA.debugLineNum = 655387;BA.debugLine="checkBoxes = Array As CheckBox()";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/  = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]{};
RDebugUtils.currentLine=655388;
 //BA.debugLineNum = 655388;BA.debugLine="checkedSales = Array As Boolean()";
__ref._checkedsales /*boolean[]*/  = new boolean[]{};
RDebugUtils.currentLine=655390;
 //BA.debugLineNum = 655390;BA.debugLine="Dim checkBoxes(legend.Length) As CheckBox";
_checkboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[_legend.length];
{
int d0 = _checkboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_checkboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=655391;
 //BA.debugLineNum = 655391;BA.debugLine="Dim checkedSales(legend.Length) As Boolean";
_checkedsales = new boolean[_legend.length];
;
RDebugUtils.currentLine=655392;
 //BA.debugLineNum = 655392;BA.debugLine="For i = 0 To legend.Length - 1";
{
final int step29 = 1;
final int limit29 = (int) (_legend.length-1);
_i = (int) (0) ;
for (;_i <= limit29 ;_i = _i + step29 ) {
RDebugUtils.currentLine=655393;
 //BA.debugLineNum = 655393;BA.debugLine="Dim chk As CheckBox";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=655394;
 //BA.debugLineNum = 655394;BA.debugLine="chk.Initialize(\"chkChange\")";
_chk.Initialize(ba,"chkChange");
RDebugUtils.currentLine=655395;
 //BA.debugLineNum = 655395;BA.debugLine="chk.Text = legend(i)";
_chk.setText(BA.ObjectToCharSequence(_legend[_i]));
RDebugUtils.currentLine=655396;
 //BA.debugLineNum = 655396;BA.debugLine="chk.TextSize = 10";
_chk.setTextSize((float) (10));
RDebugUtils.currentLine=655397;
 //BA.debugLineNum = 655397;BA.debugLine="chk.Typeface = Typeface.MONOSPACE";
_chk.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=655398;
 //BA.debugLineNum = 655398;BA.debugLine="chk.TextColor = color(i)";
_chk.setTextColor(__ref._color /*int[]*/ [_i]);
RDebugUtils.currentLine=655399;
 //BA.debugLineNum = 655399;BA.debugLine="chk.Tag = i";
_chk.setTag((Object)(_i));
RDebugUtils.currentLine=655400;
 //BA.debugLineNum = 655400;BA.debugLine="chk.Checked = True";
_chk.setChecked(__c.True);
RDebugUtils.currentLine=655401;
 //BA.debugLineNum = 655401;BA.debugLine="legendPanel.AddView(chk, (legendWidth * i) + 30d";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .AddView((android.view.View)(_chk.getObject()),(int) ((_legendwidth*_i)+__c.DipToCurrent((int) (30))),__c.DipToCurrent((int) (0)),(int) (_legendwidth-__c.DipToCurrent((int) (30))),__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight());
RDebugUtils.currentLine=655402;
 //BA.debugLineNum = 655402;BA.debugLine="checkBoxes(i) = chk";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/ [_i] = _chk;
RDebugUtils.currentLine=655403;
 //BA.debugLineNum = 655403;BA.debugLine="checkedSales(i) = True";
__ref._checkedsales /*boolean[]*/ [_i] = __c.True;
 }
};
RDebugUtils.currentLine=655408;
 //BA.debugLineNum = 655408;BA.debugLine="btnBack.Text = \"Back\"";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setText(BA.ObjectToCharSequence("Back"));
RDebugUtils.currentLine=655409;
 //BA.debugLineNum = 655409;BA.debugLine="btnBack.TextSize = 14";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTextSize((float) (14));
RDebugUtils.currentLine=655410;
 //BA.debugLineNum = 655410;BA.debugLine="btnBack.Typeface = Typeface.MONOSPACE";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=655411;
 //BA.debugLineNum = 655411;BA.debugLine="btnBack.TextColor = Colors.White";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTextColor(__c.Colors.White);
RDebugUtils.currentLine=655412;
 //BA.debugLineNum = 655412;BA.debugLine="Dim cdBack As ColorDrawable";
_cdback = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=655413;
 //BA.debugLineNum = 655413;BA.debugLine="cdBack.Initialize2(Colors.RGB(61, 12, 2), 10dip,";
_cdback.Initialize2(__c.Colors.RGB((int) (61),(int) (12),(int) (2)),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (2)),__c.Colors.Black);
RDebugUtils.currentLine=655414;
 //BA.debugLineNum = 655414;BA.debugLine="btnBack.Background = cdBack";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setBackground((android.graphics.drawable.Drawable)(_cdback.getObject()));
RDebugUtils.currentLine=655417;
 //BA.debugLineNum = 655417;BA.debugLine="btnNext.Text = \"Next\"";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setText(BA.ObjectToCharSequence("Next"));
RDebugUtils.currentLine=655418;
 //BA.debugLineNum = 655418;BA.debugLine="btnNext.TextSize = 14";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTextSize((float) (14));
RDebugUtils.currentLine=655419;
 //BA.debugLineNum = 655419;BA.debugLine="btnNext.Typeface = Typeface.MONOSPACE";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=655420;
 //BA.debugLineNum = 655420;BA.debugLine="btnNext.TextColor = Colors.White";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTextColor(__c.Colors.White);
RDebugUtils.currentLine=655421;
 //BA.debugLineNum = 655421;BA.debugLine="Dim cdNext As ColorDrawable";
_cdnext = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=655422;
 //BA.debugLineNum = 655422;BA.debugLine="cdNext.Initialize2(Colors.RGB(185, 46, 52), 10dip";
_cdnext.Initialize2(__c.Colors.RGB((int) (185),(int) (46),(int) (52)),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (2)),__c.Colors.Black);
RDebugUtils.currentLine=655423;
 //BA.debugLineNum = 655423;BA.debugLine="btnNext.Background = cdNext";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setBackground((android.graphics.drawable.Drawable)(_cdnext.getObject()));
RDebugUtils.currentLine=655425;
 //BA.debugLineNum = 655425;BA.debugLine="DrawGraph(Active, panel, sale1, sale2, sale3, pro";
__ref._drawgraph /*String*/ (null,_active,_panel,_sale1,_sale2,_sale3,_product,_maxsales,_titlestring);
RDebugUtils.currentLine=655426;
 //BA.debugLineNum = 655426;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Private checkBoxes() As CheckBox";
_checkboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[(int) (0)];
{
int d0 = _checkboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_checkboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="Private checkedSales() As Boolean";
_checkedsales = new boolean[(int) (0)];
;
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="Dim color() As Int = Array As Int(Colors.RGB(255,";
_color = new int[]{__c.Colors.RGB((int) (255),(int) (0),(int) (0)),__c.Colors.RGB((int) (200),(int) (20),(int) (20)),__c.Colors.RGB((int) (100),(int) (10),(int) (10))};
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="Dim legendPanel As Panel";
_legendpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="Dim Active1 As Activity";
_active1 = new anywheresoftware.b4a.objects.ActivityWrapper();
RDebugUtils.currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="Dim panel_l As Panel";
_panel_l = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="Dim sale_1() As Int";
_sale_1 = new int[(int) (0)];
;
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="Dim sale_2() As Int";
_sale_2 = new int[(int) (0)];
;
RDebugUtils.currentLine=589833;
 //BA.debugLineNum = 589833;BA.debugLine="Dim sale_3() As Int";
_sale_3 = new int[(int) (0)];
;
RDebugUtils.currentLine=589834;
 //BA.debugLineNum = 589834;BA.debugLine="Dim product1() As String";
_product1 = new String[(int) (0)];
java.util.Arrays.fill(_product1,"");
RDebugUtils.currentLine=589835;
 //BA.debugLineNum = 589835;BA.debugLine="Dim legend1() As String";
_legend1 = new String[(int) (0)];
java.util.Arrays.fill(_legend1,"");
RDebugUtils.currentLine=589836;
 //BA.debugLineNum = 589836;BA.debugLine="Dim maxSales1 As Int = 0";
_maxsales1 = (int) (0);
RDebugUtils.currentLine=589837;
 //BA.debugLineNum = 589837;BA.debugLine="Dim titleString1 As String = \"\"";
_titlestring1 = "";
RDebugUtils.currentLine=589838;
 //BA.debugLineNum = 589838;BA.debugLine="Dim comId1() As Int";
_comid1 = new int[(int) (0)];
;
RDebugUtils.currentLine=589839;
 //BA.debugLineNum = 589839;BA.debugLine="Private currentPage As Int = 1";
_currentpage = (int) (1);
RDebugUtils.currentLine=589840;
 //BA.debugLineNum = 589840;BA.debugLine="Private itemsPerPage As Int = 5";
_itemsperpage = (int) (5);
RDebugUtils.currentLine=589841;
 //BA.debugLineNum = 589841;BA.debugLine="Public btnNext As Button";
_btnnext = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=589842;
 //BA.debugLineNum = 589842;BA.debugLine="Public btnBack As Button";
_btnback = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=589843;
 //BA.debugLineNum = 589843;BA.debugLine="Dim layout As String = \"\"";
_layout = "";
RDebugUtils.currentLine=589844;
 //BA.debugLineNum = 589844;BA.debugLine="End Sub";
return "";
}
public String  _drawgraph(b4a.example.bargraph __ref,anywheresoftware.b4a.objects.ActivityWrapper _active,anywheresoftware.b4a.objects.PanelWrapper _panel,int[] _sale1,int[] _sale2,int[] _sale3,String[] _product,int _maxsales,String _titlestring) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "drawgraph", false))
	 {return ((String) Debug.delegate(ba, "drawgraph", new Object[] {_active,_panel,_sale1,_sale2,_sale3,_product,_maxsales,_titlestring}));}
anywheresoftware.b4a.objects.PanelWrapper _activitypanel = null;
int _alignleftcenter = 0;
int _aligntopcenter = 0;
anywheresoftware.b4a.objects.LabelWrapper _title = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _graphcanvas = null;
int _maxsale = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cv = null;
int _totalproducts = 0;
int _startindex = 0;
int _endindex = 0;
int _barsperproduct = 0;
int _totalbars = 0;
int _gap = 0;
int _productgap = 0;
int _padding = 0;
int _availablewidth = 0;
int _barwidth = 0;
int _xstart = 0;
int _i = 0;
int _xpos = 0;
int[] _salevalues = null;
int _indexoffset = 0;
int _j = 0;
int _sale = 0;
int _barheight = 0;
int _xbar = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r = null;
int _fontsize = 0;
anywheresoftware.b4a.objects.LabelWrapper _productlabel = null;
int _productlabely = 0;
int _productlabelx = 0;
int _numlabels = 0;
int _labelvalue = 0;
int _labelypos = 0;
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub DrawGraph(Active As Activity, panel As Panel,";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Try";
try {RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="panel.Invalidate";
_panel.Invalidate();
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="panel.RemoveAllViews";
_panel.RemoveAllViews();
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="panel.Height = 450dip";
_panel.setHeight(__c.DipToCurrent((int) (450)));
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="If panel.Width = 0 Then";
if (_panel.getWidth()==0) { 
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="panel.Width = 800dip";
_panel.setWidth(__c.DipToCurrent((int) (800)));
 };
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="panel.AddView(legendPanel, 0, 0, panel.Width, 30";
_panel.AddView((android.view.View)(__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()),(int) (0),(int) (0),_panel.getWidth(),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="Dim activityPanel As Panel";
_activitypanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=720906;
 //BA.debugLineNum = 720906;BA.debugLine="activityPanel.Initialize(\"activityPanel\")";
_activitypanel.Initialize(ba,"activityPanel");
RDebugUtils.currentLine=720908;
 //BA.debugLineNum = 720908;BA.debugLine="activityPanel.Width = 80%x";
_activitypanel.setWidth(__c.PerXToCurrent((float) (80),ba));
RDebugUtils.currentLine=720909;
 //BA.debugLineNum = 720909;BA.debugLine="If Active.Width > 800 Then";
if (_active.getWidth()>800) { 
RDebugUtils.currentLine=720910;
 //BA.debugLineNum = 720910;BA.debugLine="activityPanel.Width = 55%x";
_activitypanel.setWidth(__c.PerXToCurrent((float) (55),ba));
 };
RDebugUtils.currentLine=720912;
 //BA.debugLineNum = 720912;BA.debugLine="activityPanel.Height = 250dip";
_activitypanel.setHeight(__c.DipToCurrent((int) (250)));
RDebugUtils.currentLine=720913;
 //BA.debugLineNum = 720913;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211,";
_activitypanel.setColor(__c.Colors.ARGB((int) (70),(int) (211),(int) (211),(int) (211)));
RDebugUtils.currentLine=720915;
 //BA.debugLineNum = 720915;BA.debugLine="Dim alignLeftCenter As Int = (Active.Width - act";
_alignleftcenter = (int) ((_active.getWidth()-_activitypanel.getWidth())/(double)2);
RDebugUtils.currentLine=720916;
 //BA.debugLineNum = 720916;BA.debugLine="Dim alignTopCenter As Int = (panel.Height - acti";
_aligntopcenter = (int) ((_panel.getHeight()-_activitypanel.getHeight())/(double)2-__c.DipToCurrent((int) (20)));
RDebugUtils.currentLine=720918;
 //BA.debugLineNum = 720918;BA.debugLine="Dim Title As Label";
_title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=720919;
 //BA.debugLineNum = 720919;BA.debugLine="Title.Initialize(\"\")";
_title.Initialize(ba,"");
RDebugUtils.currentLine=720920;
 //BA.debugLineNum = 720920;BA.debugLine="Title.Text = TitleString";
_title.setText(BA.ObjectToCharSequence(_titlestring));
RDebugUtils.currentLine=720921;
 //BA.debugLineNum = 720921;BA.debugLine="Title.TextSize = 20";
_title.setTextSize((float) (20));
RDebugUtils.currentLine=720922;
 //BA.debugLineNum = 720922;BA.debugLine="Title.Typeface = Typeface.MONOSPACE";
_title.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=720923;
 //BA.debugLineNum = 720923;BA.debugLine="Title.Gravity = Gravity.CENTER";
_title.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=720924;
 //BA.debugLineNum = 720924;BA.debugLine="Title.TextColor = Colors.Black";
_title.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=720925;
 //BA.debugLineNum = 720925;BA.debugLine="panel.AddView(Title, 0, alignTopCenter / 2, pane";
_panel.AddView((android.view.View)(_title.getObject()),(int) (0),(int) (_aligntopcenter/(double)2),_panel.getWidth(),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=720927;
 //BA.debugLineNum = 720927;BA.debugLine="panel.AddView(activityPanel, alignLeftCenter, al";
_panel.AddView((android.view.View)(_activitypanel.getObject()),_alignleftcenter,_aligntopcenter,_activitypanel.getWidth(),_activitypanel.getHeight());
RDebugUtils.currentLine=720929;
 //BA.debugLineNum = 720929;BA.debugLine="Dim graphCanvas As Canvas";
_graphcanvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=720930;
 //BA.debugLineNum = 720930;BA.debugLine="graphCanvas.Initialize(activityPanel)";
_graphcanvas.Initialize((android.view.View)(_activitypanel.getObject()));
RDebugUtils.currentLine=720932;
 //BA.debugLineNum = 720932;BA.debugLine="Dim maxSale As Int = maxSales * 1.2";
_maxsale = (int) (_maxsales*1.2);
RDebugUtils.currentLine=720933;
 //BA.debugLineNum = 720933;BA.debugLine="Dim cv As Canvas";
_cv = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=720934;
 //BA.debugLineNum = 720934;BA.debugLine="cv.Initialize(panel)";
_cv.Initialize((android.view.View)(_panel.getObject()));
RDebugUtils.currentLine=720936;
 //BA.debugLineNum = 720936;BA.debugLine="Dim totalProducts As Int = sale1.Length";
_totalproducts = _sale1.length;
RDebugUtils.currentLine=720937;
 //BA.debugLineNum = 720937;BA.debugLine="Dim startIndex As Int = (currentPage - 1) * item";
_startindex = (int) ((__ref._currentpage /*int*/ -1)*__ref._itemsperpage /*int*/ );
RDebugUtils.currentLine=720938;
 //BA.debugLineNum = 720938;BA.debugLine="Dim endIndex As Int = Min(startIndex + itemsPerP";
_endindex = (int) (__c.Min(_startindex+__ref._itemsperpage /*int*/ -1,_totalproducts-1));
RDebugUtils.currentLine=720939;
 //BA.debugLineNum = 720939;BA.debugLine="Dim barsPerProduct As Int = 3";
_barsperproduct = (int) (3);
RDebugUtils.currentLine=720940;
 //BA.debugLineNum = 720940;BA.debugLine="Dim totalBars As Int = (endIndex - startIndex +";
_totalbars = (int) ((_endindex-_startindex+1)*_barsperproduct);
RDebugUtils.currentLine=720941;
 //BA.debugLineNum = 720941;BA.debugLine="Dim gap As Int = 5dip";
_gap = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=720942;
 //BA.debugLineNum = 720942;BA.debugLine="Dim productGap As Int = 0dip";
_productgap = __c.DipToCurrent((int) (0));
RDebugUtils.currentLine=720943;
 //BA.debugLineNum = 720943;BA.debugLine="Dim padding As Int = 10dip";
_padding = __c.DipToCurrent((int) (10));
RDebugUtils.currentLine=720945;
 //BA.debugLineNum = 720945;BA.debugLine="Dim availableWidth As Int = activityPanel.Width";
_availablewidth = (int) (_activitypanel.getWidth()-(_padding*2)-(((_endindex-_startindex+1)-1)*_productgap)-((_totalbars-(_endindex-_startindex+1))*_gap));
RDebugUtils.currentLine=720946;
 //BA.debugLineNum = 720946;BA.debugLine="Dim barWidth As Int = availableWidth / totalBars";
_barwidth = (int) (_availablewidth/(double)_totalbars);
RDebugUtils.currentLine=720947;
 //BA.debugLineNum = 720947;BA.debugLine="Dim xStart As Int = padding";
_xstart = _padding;
RDebugUtils.currentLine=720949;
 //BA.debugLineNum = 720949;BA.debugLine="For i = startIndex To endIndex";
{
final int step44 = 1;
final int limit44 = _endindex;
_i = _startindex ;
for (;_i <= limit44 ;_i = _i + step44 ) {
RDebugUtils.currentLine=720950;
 //BA.debugLineNum = 720950;BA.debugLine="Dim xPos As Int = xStart + (i - startIndex) * (";
_xpos = (int) (_xstart+(_i-_startindex)*(_barsperproduct*(_barwidth+_gap)+_productgap));
RDebugUtils.currentLine=720951;
 //BA.debugLineNum = 720951;BA.debugLine="Dim saleValues() As Int = Array As Int(sale1(i)";
_salevalues = new int[]{_sale1[_i],_sale2[_i],_sale3[_i]};
RDebugUtils.currentLine=720952;
 //BA.debugLineNum = 720952;BA.debugLine="Dim indexOffset As Int = 0";
_indexoffset = (int) (0);
RDebugUtils.currentLine=720954;
 //BA.debugLineNum = 720954;BA.debugLine="For j = 0 To barsPerProduct - 1";
{
final int step48 = 1;
final int limit48 = (int) (_barsperproduct-1);
_j = (int) (0) ;
for (;_j <= limit48 ;_j = _j + step48 ) {
RDebugUtils.currentLine=720955;
 //BA.debugLineNum = 720955;BA.debugLine="If j < checkedSales.Length And checkedSales(j)";
if (_j<__ref._checkedsales /*boolean[]*/ .length && __ref._checkedsales /*boolean[]*/ [_j]) { 
RDebugUtils.currentLine=720956;
 //BA.debugLineNum = 720956;BA.debugLine="Dim sale As Int = saleValues(j)";
_sale = _salevalues[_j];
RDebugUtils.currentLine=720957;
 //BA.debugLineNum = 720957;BA.debugLine="Dim barHeight As Int = (sale / maxSale) * (ac";
_barheight = (int) ((_sale/(double)_maxsale)*(_activitypanel.getHeight()));
RDebugUtils.currentLine=720958;
 //BA.debugLineNum = 720958;BA.debugLine="Dim xBar As Int = xPos + indexOffset * barWid";
_xbar = (int) (_xpos+_indexoffset*_barwidth);
RDebugUtils.currentLine=720960;
 //BA.debugLineNum = 720960;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=720961;
 //BA.debugLineNum = 720961;BA.debugLine="r.Initialize(xBar, activityPanel.Height - bar";
_r.Initialize(_xbar,(int) (_activitypanel.getHeight()-_barheight),(int) (_xbar+_barwidth),_activitypanel.getHeight());
RDebugUtils.currentLine=720962;
 //BA.debugLineNum = 720962;BA.debugLine="graphCanvas.DrawRect(r, color(j), True, 2dip)";
_graphcanvas.DrawRect((android.graphics.Rect)(_r.getObject()),__ref._color /*int[]*/ [_j],__c.True,(float) (__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=720964;
 //BA.debugLineNum = 720964;BA.debugLine="Dim fontSize As Int = 8";
_fontsize = (int) (8);
RDebugUtils.currentLine=720965;
 //BA.debugLineNum = 720965;BA.debugLine="If Active.Width > 800 Then";
if (_active.getWidth()>800) { 
RDebugUtils.currentLine=720966;
 //BA.debugLineNum = 720966;BA.debugLine="fontSize = 10";
_fontsize = (int) (10);
 };
RDebugUtils.currentLine=720968;
 //BA.debugLineNum = 720968;BA.debugLine="graphCanvas.DrawText(FormatNumberWithSuffix(s";
_graphcanvas.DrawText(ba,__ref._formatnumberwithsuffix /*String*/ (null,_sale),(float) (_xbar+(_barwidth/(double)2)),(float) (_activitypanel.getHeight()-_barheight-__c.DipToCurrent((int) (5))),__c.Typeface.MONOSPACE,(float) (_fontsize),__c.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
RDebugUtils.currentLine=720969;
 //BA.debugLineNum = 720969;BA.debugLine="indexOffset = indexOffset + 1";
_indexoffset = (int) (_indexoffset+1);
 };
 }
};
RDebugUtils.currentLine=720973;
 //BA.debugLineNum = 720973;BA.debugLine="Dim productLabel As Label";
_productlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=720974;
 //BA.debugLineNum = 720974;BA.debugLine="productLabel.Initialize(\"productLabel\")";
_productlabel.Initialize(ba,"productLabel");
RDebugUtils.currentLine=720975;
 //BA.debugLineNum = 720975;BA.debugLine="productLabel.Text = product(i)";
_productlabel.setText(BA.ObjectToCharSequence(_product[_i]));
RDebugUtils.currentLine=720976;
 //BA.debugLineNum = 720976;BA.debugLine="productLabel.Typeface = Typeface.MONOSPACE";
_productlabel.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=720977;
 //BA.debugLineNum = 720977;BA.debugLine="productLabel.TextSize = 12";
_productlabel.setTextSize((float) (12));
RDebugUtils.currentLine=720978;
 //BA.debugLineNum = 720978;BA.debugLine="productLabel.Tag = comId1(i)";
_productlabel.setTag((Object)(__ref._comid1 /*int[]*/ [_i]));
RDebugUtils.currentLine=720979;
 //BA.debugLineNum = 720979;BA.debugLine="productLabel.TextColor = Colors.Black";
_productlabel.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=720980;
 //BA.debugLineNum = 720980;BA.debugLine="productLabel.Gravity = Gravity.CENTER";
_productlabel.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=720981;
 //BA.debugLineNum = 720981;BA.debugLine="Dim productLabelY As Int = activityPanel.Height";
_productlabely = (int) (_activitypanel.getHeight()+_aligntopcenter+__c.DipToCurrent((int) (10)));
RDebugUtils.currentLine=720982;
 //BA.debugLineNum = 720982;BA.debugLine="Dim productLabelX As Int = alignLeftCenter";
_productlabelx = _alignleftcenter;
RDebugUtils.currentLine=720983;
 //BA.debugLineNum = 720983;BA.debugLine="panel.AddView(productLabel, xPos + productLabel";
_panel.AddView((android.view.View)(_productlabel.getObject()),(int) (_xpos+_productlabelx),_productlabely,__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (30)));
 }
};
RDebugUtils.currentLine=720986;
 //BA.debugLineNum = 720986;BA.debugLine="Dim numLabels As Int = 10";
_numlabels = (int) (10);
RDebugUtils.currentLine=720987;
 //BA.debugLineNum = 720987;BA.debugLine="For i = 0 To numLabels";
{
final int step77 = 1;
final int limit77 = _numlabels;
_i = (int) (0) ;
for (;_i <= limit77 ;_i = _i + step77 ) {
RDebugUtils.currentLine=720988;
 //BA.debugLineNum = 720988;BA.debugLine="Dim labelValue As Int = Round((maxSale / numLab";
_labelvalue = (int) (__c.Round((_maxsale/(double)_numlabels)*_i));
RDebugUtils.currentLine=720989;
 //BA.debugLineNum = 720989;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - (";
_labelypos = (int) (_activitypanel.getHeight()-((_labelvalue/(double)_maxsale)*_activitypanel.getHeight()));
RDebugUtils.currentLine=720990;
 //BA.debugLineNum = 720990;BA.debugLine="cv.DrawText(FormatNumberWithLabel(labelValue),";
_cv.DrawText(ba,__ref._formatnumberwithlabel /*String*/ (null,_labelvalue),(float) (_alignleftcenter-__c.DipToCurrent((int) (10))),(float) (_labelypos+_aligntopcenter+__c.DipToCurrent((int) (5))),__c.Typeface.MONOSPACE,(float) (10),__c.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"RIGHT"));
 }
};
RDebugUtils.currentLine=720994;
 //BA.debugLineNum = 720994;BA.debugLine="panel.AddView(btnBack, alignLeftCenter, activity";
_panel.AddView((android.view.View)(__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .getObject()),_alignleftcenter,(int) (_activitypanel.getHeight()+_aligntopcenter+__c.DipToCurrent((int) (50))),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
RDebugUtils.currentLine=720995;
 //BA.debugLineNum = 720995;BA.debugLine="panel.AddView(btnNext, panel.Width - alignLeftCe";
_panel.AddView((android.view.View)(__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .getObject()),(int) (_panel.getWidth()-_alignleftcenter-__c.DipToCurrent((int) (100))),(int) (_activitypanel.getHeight()+_aligntopcenter+__c.DipToCurrent((int) (50))),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
RDebugUtils.currentLine=720998;
 //BA.debugLineNum = 720998;BA.debugLine="btnBack.Enabled = True";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setEnabled(__c.True);
RDebugUtils.currentLine=720999;
 //BA.debugLineNum = 720999;BA.debugLine="btnNext.Enabled = True";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setEnabled(__c.True);
RDebugUtils.currentLine=721000;
 //BA.debugLineNum = 721000;BA.debugLine="Log(\"btnNext Enabled: \" & btnNext.Enabled) ' Deb";
__c.LogImpl("1721000","btnNext Enabled: "+BA.ObjectToString(__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .getEnabled()),0);
 } 
       catch (Exception e88) {
			ba.setLastException(e88);RDebugUtils.currentLine=721002;
 //BA.debugLineNum = 721002;BA.debugLine="Log(LastException)";
__c.LogImpl("1721002",BA.ObjectToString(__c.LastException(ba)),0);
 };
RDebugUtils.currentLine=721004;
 //BA.debugLineNum = 721004;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithsuffix(b4a.example.bargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithsuffix", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithsuffix", new Object[] {_number}));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
if (true) return __c.NumberFormat(_number/(double)1000000,(int) (1),(int) (1))+"M";
 }else 
{RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
if (true) return __c.NumberFormat(_number/(double)1000,(int) (1),(int) (1))+"k";
 }else {
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="Return NumberFormat(number, 1, 0)";
if (true) return __c.NumberFormat(_number,(int) (1),(int) (0));
 }}
;
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithlabel(b4a.example.bargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithlabel", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithlabel", new Object[] {_number}));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub FormatNumberWithLabel(number As Int) As String";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="Return Floor(number / 1000000) & \"M\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000000))+"M";
 }else 
{RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="Return Floor(number / 1000) & \"k\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000))+"k";
 }else {
RDebugUtils.currentLine=1048582;
 //BA.debugLineNum = 1048582;BA.debugLine="Return number";
if (true) return BA.NumberToString(_number);
 }}
;
RDebugUtils.currentLine=1048584;
 //BA.debugLineNum = 1048584;BA.debugLine="End Sub";
return "";
}
public int  _getcurrentpage(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "getcurrentpage", false))
	 {return ((Integer) Debug.delegate(ba, "getcurrentpage", null));}
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="Public Sub GetCurrentPage As Int";
RDebugUtils.currentLine=6291457;
 //BA.debugLineNum = 6291457;BA.debugLine="Return currentPage";
if (true) return __ref._currentpage /*int*/ ;
RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="End Sub";
return 0;
}
public String  _productlabel_click(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "productlabel_click", false))
	 {return ((String) Debug.delegate(ba, "productlabel_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _clickedlabel = null;
int _selectedcompany = 0;
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub productLabel_Click";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="Dim clickedLabel As Label = Sender";
_clickedlabel = new anywheresoftware.b4a.objects.LabelWrapper();
_clickedlabel = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(__c.Sender(ba)));
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="Dim selectedCompany As Int = clickedLabel.Tag";
_selectedcompany = (int)(BA.ObjectToNumber(_clickedlabel.getTag()));
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="Log(\"Selected Company ID: \" & selectedCompany)";
__c.LogImpl("1917507","Selected Company ID: "+BA.NumberToString(_selectedcompany),0);
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="Starter.company_selected = selectedCompany";
_starter._company_selected /*String*/  = BA.NumberToString(_selectedcompany);
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="StartActivity(layout)";
__c.StartActivity(ba,(Object)(__ref._layout /*String*/ ));
RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="Active1.Finish";
__ref._active1 /*anywheresoftware.b4a.objects.ActivityWrapper*/ .Finish();
RDebugUtils.currentLine=917511;
 //BA.debugLineNum = 917511;BA.debugLine="End Sub";
return "";
}
public String  _setcurrentpage(b4a.example.bargraph __ref,int _page) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "setcurrentpage", false))
	 {return ((String) Debug.delegate(ba, "setcurrentpage", new Object[] {_page}));}
RDebugUtils.currentLine=6750208;
 //BA.debugLineNum = 6750208;BA.debugLine="Public Sub SetCurrentPage(page As Int)";
RDebugUtils.currentLine=6750209;
 //BA.debugLineNum = 6750209;BA.debugLine="currentPage = page";
__ref._currentpage /*int*/  = _page;
RDebugUtils.currentLine=6750210;
 //BA.debugLineNum = 6750210;BA.debugLine="UpdateGraph";
__ref._updategraph /*String*/ (null);
RDebugUtils.currentLine=6750211;
 //BA.debugLineNum = 6750211;BA.debugLine="End Sub";
return "";
}
public String  _updategraph(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "updategraph", false))
	 {return ((String) Debug.delegate(ba, "updategraph", null));}
RDebugUtils.currentLine=6684672;
 //BA.debugLineNum = 6684672;BA.debugLine="Public Sub UpdateGraph";
RDebugUtils.currentLine=6684673;
 //BA.debugLineNum = 6684673;BA.debugLine="DrawGraph(Active1, panel_l, sale_1, sale_2, sale_";
__ref._drawgraph /*String*/ (null,__ref._active1 /*anywheresoftware.b4a.objects.ActivityWrapper*/ ,__ref._panel_l /*anywheresoftware.b4a.objects.PanelWrapper*/ ,__ref._sale_1 /*int[]*/ ,__ref._sale_2 /*int[]*/ ,__ref._sale_3 /*int[]*/ ,__ref._product1 /*String[]*/ ,__ref._maxsales1 /*int*/ ,__ref._titlestring1 /*String*/ );
RDebugUtils.currentLine=6684674;
 //BA.debugLineNum = 6684674;BA.debugLine="End Sub";
return "";
}
}