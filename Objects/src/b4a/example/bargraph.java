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
public b4a.example.branch _branch = null;
public b4a.example.device _device = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public String  _initialize(b4a.example.bargraph __ref,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _active,anywheresoftware.b4a.objects.PanelWrapper _panel,int[] _sale1,int[] _sale2,int[] _sale3,String[] _product,String[] _legend,int _maxsales,String _titlestring,int[] _comid,String _layout1) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_active,_panel,_sale1,_sale2,_sale3,_product,_legend,_maxsales,_titlestring,_comid,_layout1}));}
int _legendwidth = 0;
int _i = 0;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk = null;
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Public Sub Initialize(Active As Activity, panel As";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="Active1 = Active";
__ref._active1 /*anywheresoftware.b4a.objects.ActivityWrapper*/  = _active;
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="panel_l = panel";
__ref._panel_l /*anywheresoftware.b4a.objects.PanelWrapper*/  = _panel;
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="sale_1 = sale1";
__ref._sale_1 /*int[]*/  = _sale1;
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="sale_2 = sale2";
__ref._sale_2 /*int[]*/  = _sale2;
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="sale_3 = sale3";
__ref._sale_3 /*int[]*/  = _sale3;
RDebugUtils.currentLine=1179654;
 //BA.debugLineNum = 1179654;BA.debugLine="product1 = product";
__ref._product1 /*String[]*/  = _product;
RDebugUtils.currentLine=1179655;
 //BA.debugLineNum = 1179655;BA.debugLine="legend1 = legend";
__ref._legend1 /*String[]*/  = _legend;
RDebugUtils.currentLine=1179656;
 //BA.debugLineNum = 1179656;BA.debugLine="maxSales1 = maxSales";
__ref._maxsales1 /*int*/  = _maxsales;
RDebugUtils.currentLine=1179657;
 //BA.debugLineNum = 1179657;BA.debugLine="titleString1 = TitleString";
__ref._titlestring1 /*String*/  = _titlestring;
RDebugUtils.currentLine=1179658;
 //BA.debugLineNum = 1179658;BA.debugLine="comId1 = comId";
__ref._comid1 /*int[]*/  = _comid;
RDebugUtils.currentLine=1179659;
 //BA.debugLineNum = 1179659;BA.debugLine="layout = layout1";
__ref._layout /*String*/  = _layout1;
RDebugUtils.currentLine=1179660;
 //BA.debugLineNum = 1179660;BA.debugLine="If sale1.Length <> product.Length Or sale2.Length";
if (_sale1.length!=_product.length || _sale2.length!=_product.length || _sale3.length!=_product.length) { 
RDebugUtils.currentLine=1179661;
 //BA.debugLineNum = 1179661;BA.debugLine="Return ' Exit if validation fails";
if (true) return "";
 };
RDebugUtils.currentLine=1179664;
 //BA.debugLineNum = 1179664;BA.debugLine="legendPanel.Initialize(\"\")";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .Initialize(ba,"");
RDebugUtils.currentLine=1179665;
 //BA.debugLineNum = 1179665;BA.debugLine="legendPanel.Width = panel.Width";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setWidth(_panel.getWidth());
RDebugUtils.currentLine=1179666;
 //BA.debugLineNum = 1179666;BA.debugLine="legendPanel.Height = 30dip";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setHeight(__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=1179668;
 //BA.debugLineNum = 1179668;BA.debugLine="Dim legendWidth As Int = legendPanel.Width / lege";
_legendwidth = (int) (__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()/(double)_legend.length);
RDebugUtils.currentLine=1179669;
 //BA.debugLineNum = 1179669;BA.debugLine="checkBoxes = Array As CheckBox()";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/  = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]{};
RDebugUtils.currentLine=1179670;
 //BA.debugLineNum = 1179670;BA.debugLine="checkedSales = Array As Boolean()";
__ref._checkedsales /*boolean[]*/  = new boolean[]{};
RDebugUtils.currentLine=1179672;
 //BA.debugLineNum = 1179672;BA.debugLine="Dim checkBoxes(legend.Length) As CheckBox   ' Res";
_checkboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[_legend.length];
{
int d0 = _checkboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_checkboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=1179673;
 //BA.debugLineNum = 1179673;BA.debugLine="Dim checkedSales(legend.Length) As Boolean";
_checkedsales = new boolean[_legend.length];
;
RDebugUtils.currentLine=1179674;
 //BA.debugLineNum = 1179674;BA.debugLine="For i = 0 To legend.Length - 1";
{
final int step23 = 1;
final int limit23 = (int) (_legend.length-1);
_i = (int) (0) ;
for (;_i <= limit23 ;_i = _i + step23 ) {
RDebugUtils.currentLine=1179680;
 //BA.debugLineNum = 1179680;BA.debugLine="Dim chk As CheckBox";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=1179681;
 //BA.debugLineNum = 1179681;BA.debugLine="chk.Initialize(\"chkChange\")";
_chk.Initialize(ba,"chkChange");
RDebugUtils.currentLine=1179682;
 //BA.debugLineNum = 1179682;BA.debugLine="chk.Text = legend(i)";
_chk.setText(BA.ObjectToCharSequence(_legend[_i]));
RDebugUtils.currentLine=1179683;
 //BA.debugLineNum = 1179683;BA.debugLine="chk.TextSize = 10";
_chk.setTextSize((float) (10));
RDebugUtils.currentLine=1179684;
 //BA.debugLineNum = 1179684;BA.debugLine="chk.Typeface = Typeface.MONOSPACE";
_chk.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=1179685;
 //BA.debugLineNum = 1179685;BA.debugLine="chk.TextColor = color(i)";
_chk.setTextColor(__ref._color /*int[]*/ [_i]);
RDebugUtils.currentLine=1179686;
 //BA.debugLineNum = 1179686;BA.debugLine="chk.Tag = i";
_chk.setTag((Object)(_i));
RDebugUtils.currentLine=1179687;
 //BA.debugLineNum = 1179687;BA.debugLine="chk.Checked = True";
_chk.setChecked(__c.True);
RDebugUtils.currentLine=1179688;
 //BA.debugLineNum = 1179688;BA.debugLine="legendPanel.AddView(chk, (legendWidth * i) + 30d";
__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .AddView((android.view.View)(_chk.getObject()),(int) ((_legendwidth*_i)+__c.DipToCurrent((int) (30))),__c.DipToCurrent((int) (0)),(int) (_legendwidth-__c.DipToCurrent((int) (30))),__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight());
RDebugUtils.currentLine=1179691;
 //BA.debugLineNum = 1179691;BA.debugLine="checkBoxes(i) = chk ' Store reference in global";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/ [_i] = _chk;
RDebugUtils.currentLine=1179692;
 //BA.debugLineNum = 1179692;BA.debugLine="checkedSales(i) = True ' Ensure the checkbox is";
__ref._checkedsales /*boolean[]*/ [_i] = __c.True;
 }
};
RDebugUtils.currentLine=1179695;
 //BA.debugLineNum = 1179695;BA.debugLine="DrawGraph(Active, panel, sale1, sale2, sale3, pro";
__ref._drawgraph /*String*/ (null,_active,_panel,_sale1,_sale2,_sale3,_product,_maxsales,_titlestring);
RDebugUtils.currentLine=1179696;
 //BA.debugLineNum = 1179696;BA.debugLine="End Sub";
return "";
}
public String  _btnback_click(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "btnback_click", false))
	 {return ((String) Debug.delegate(ba, "btnback_click", null));}
RDebugUtils.currentLine=6750208;
 //BA.debugLineNum = 6750208;BA.debugLine="Sub btnBack_Click";
RDebugUtils.currentLine=6750209;
 //BA.debugLineNum = 6750209;BA.debugLine="currentPage = currentPage - 1";
__ref._currentpage /*int*/  = (int) (__ref._currentpage /*int*/ -1);
RDebugUtils.currentLine=6750210;
 //BA.debugLineNum = 6750210;BA.debugLine="DrawGraph(Active1, panel_l, sale_1, sale_2, sale_";
__ref._drawgraph /*String*/ (null,__ref._active1 /*anywheresoftware.b4a.objects.ActivityWrapper*/ ,__ref._panel_l /*anywheresoftware.b4a.objects.PanelWrapper*/ ,__ref._sale_1 /*int[]*/ ,__ref._sale_2 /*int[]*/ ,__ref._sale_3 /*int[]*/ ,__ref._product1 /*String[]*/ ,__ref._maxsales1 /*int*/ ,__ref._titlestring1 /*String*/ );
RDebugUtils.currentLine=6750211;
 //BA.debugLineNum = 6750211;BA.debugLine="End Sub";
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
anywheresoftware.b4a.objects.drawable.ColorDrawable _cdback = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cdnext = null;
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub DrawGraph(Active As Activity, panel As Panel,";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="panel.Invalidate";
_panel.Invalidate();
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="panel.RemoveAllViews";
_panel.RemoveAllViews();
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="panel.Height = 450dip ' Increased height to accom";
_panel.setHeight(__c.DipToCurrent((int) (450)));
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="panel.AddView(legendPanel, 0, 0, panel.Width, 30d";
_panel.AddView((android.view.View)(__ref._legendpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()),(int) (0),(int) (0),_panel.getWidth(),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="Dim activityPanel As Panel";
_activitypanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="activityPanel.Initialize(\"activityPanel\")";
_activitypanel.Initialize(ba,"activityPanel");
RDebugUtils.currentLine=1245193;
 //BA.debugLineNum = 1245193;BA.debugLine="activityPanel.Width = 80%x";
_activitypanel.setWidth(__c.PerXToCurrent((float) (80),ba));
RDebugUtils.currentLine=1245194;
 //BA.debugLineNum = 1245194;BA.debugLine="If Active.Width > 800 Then";
if (_active.getWidth()>800) { 
RDebugUtils.currentLine=1245195;
 //BA.debugLineNum = 1245195;BA.debugLine="activityPanel.Width = 55%x";
_activitypanel.setWidth(__c.PerXToCurrent((float) (55),ba));
 };
RDebugUtils.currentLine=1245197;
 //BA.debugLineNum = 1245197;BA.debugLine="activityPanel.Height = 250dip";
_activitypanel.setHeight(__c.DipToCurrent((int) (250)));
RDebugUtils.currentLine=1245198;
 //BA.debugLineNum = 1245198;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211, 2";
_activitypanel.setColor(__c.Colors.ARGB((int) (70),(int) (211),(int) (211),(int) (211)));
RDebugUtils.currentLine=1245200;
 //BA.debugLineNum = 1245200;BA.debugLine="Dim alignLeftCenter As Int = (Active.Width - acti";
_alignleftcenter = (int) ((_active.getWidth()-_activitypanel.getWidth())/(double)2);
RDebugUtils.currentLine=1245201;
 //BA.debugLineNum = 1245201;BA.debugLine="Dim alignTopCenter As Int = (panel.Height - activ";
_aligntopcenter = (int) ((_panel.getHeight()-_activitypanel.getHeight())/(double)2-__c.DipToCurrent((int) (20)));
RDebugUtils.currentLine=1245203;
 //BA.debugLineNum = 1245203;BA.debugLine="Dim Title As Label";
_title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1245204;
 //BA.debugLineNum = 1245204;BA.debugLine="Title.Initialize(\"\")";
_title.Initialize(ba,"");
RDebugUtils.currentLine=1245205;
 //BA.debugLineNum = 1245205;BA.debugLine="Title.Text = TitleString";
_title.setText(BA.ObjectToCharSequence(_titlestring));
RDebugUtils.currentLine=1245206;
 //BA.debugLineNum = 1245206;BA.debugLine="Title.TextSize = 20";
_title.setTextSize((float) (20));
RDebugUtils.currentLine=1245207;
 //BA.debugLineNum = 1245207;BA.debugLine="Title.Typeface = Typeface.MONOSPACE";
_title.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=1245208;
 //BA.debugLineNum = 1245208;BA.debugLine="Title.Gravity = Gravity.CENTER";
_title.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=1245209;
 //BA.debugLineNum = 1245209;BA.debugLine="Title.TextColor = Colors.Black";
_title.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=1245210;
 //BA.debugLineNum = 1245210;BA.debugLine="panel.AddView(Title, 0, alignTopCenter / 2, panel";
_panel.AddView((android.view.View)(_title.getObject()),(int) (0),(int) (_aligntopcenter/(double)2),_panel.getWidth(),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=1245212;
 //BA.debugLineNum = 1245212;BA.debugLine="panel.AddView(activityPanel, alignLeftCenter, ali";
_panel.AddView((android.view.View)(_activitypanel.getObject()),_alignleftcenter,_aligntopcenter,_activitypanel.getWidth(),_activitypanel.getHeight());
RDebugUtils.currentLine=1245214;
 //BA.debugLineNum = 1245214;BA.debugLine="Dim graphCanvas As Canvas";
_graphcanvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=1245215;
 //BA.debugLineNum = 1245215;BA.debugLine="graphCanvas.Initialize(activityPanel)";
_graphcanvas.Initialize((android.view.View)(_activitypanel.getObject()));
RDebugUtils.currentLine=1245217;
 //BA.debugLineNum = 1245217;BA.debugLine="Dim maxSale As Int = maxSales * 1.2";
_maxsale = (int) (_maxsales*1.2);
RDebugUtils.currentLine=1245218;
 //BA.debugLineNum = 1245218;BA.debugLine="Dim cv As Canvas";
_cv = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=1245219;
 //BA.debugLineNum = 1245219;BA.debugLine="cv.Initialize(panel)";
_cv.Initialize((android.view.View)(_panel.getObject()));
RDebugUtils.currentLine=1245222;
 //BA.debugLineNum = 1245222;BA.debugLine="Dim totalProducts As Int = sale1.Length";
_totalproducts = _sale1.length;
RDebugUtils.currentLine=1245223;
 //BA.debugLineNum = 1245223;BA.debugLine="Dim startIndex As Int = (currentPage - 1) * items";
_startindex = (int) ((__ref._currentpage /*int*/ -1)*__ref._itemsperpage /*int*/ );
RDebugUtils.currentLine=1245224;
 //BA.debugLineNum = 1245224;BA.debugLine="Dim endIndex As Int = Min(startIndex + itemsPerPa";
_endindex = (int) (__c.Min(_startindex+__ref._itemsperpage /*int*/ -1,_totalproducts-1));
RDebugUtils.currentLine=1245225;
 //BA.debugLineNum = 1245225;BA.debugLine="Dim barsPerProduct As Int = 3";
_barsperproduct = (int) (3);
RDebugUtils.currentLine=1245226;
 //BA.debugLineNum = 1245226;BA.debugLine="Dim totalBars As Int = (endIndex - startIndex + 1";
_totalbars = (int) ((_endindex-_startindex+1)*_barsperproduct);
RDebugUtils.currentLine=1245227;
 //BA.debugLineNum = 1245227;BA.debugLine="Dim gap As Int = 5dip";
_gap = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=1245228;
 //BA.debugLineNum = 1245228;BA.debugLine="Dim productGap As Int = 0dip";
_productgap = __c.DipToCurrent((int) (0));
RDebugUtils.currentLine=1245229;
 //BA.debugLineNum = 1245229;BA.debugLine="Dim padding As Int = 10dip";
_padding = __c.DipToCurrent((int) (10));
RDebugUtils.currentLine=1245231;
 //BA.debugLineNum = 1245231;BA.debugLine="Dim availableWidth As Int = activityPanel.Width -";
_availablewidth = (int) (_activitypanel.getWidth()-(_padding*2)-(((_endindex-_startindex+1)-1)*_productgap)-((_totalbars-(_endindex-_startindex+1))*_gap));
RDebugUtils.currentLine=1245232;
 //BA.debugLineNum = 1245232;BA.debugLine="Dim barWidth As Int = availableWidth / totalBars";
_barwidth = (int) (_availablewidth/(double)_totalbars);
RDebugUtils.currentLine=1245233;
 //BA.debugLineNum = 1245233;BA.debugLine="Dim xStart As Int = padding";
_xstart = _padding;
RDebugUtils.currentLine=1245235;
 //BA.debugLineNum = 1245235;BA.debugLine="For i = startIndex To endIndex";
{
final int step40 = 1;
final int limit40 = _endindex;
_i = _startindex ;
for (;_i <= limit40 ;_i = _i + step40 ) {
RDebugUtils.currentLine=1245236;
 //BA.debugLineNum = 1245236;BA.debugLine="Dim xPos As Int = xStart + (i - startIndex) * (b";
_xpos = (int) (_xstart+(_i-_startindex)*(_barsperproduct*(_barwidth+_gap)+_productgap));
RDebugUtils.currentLine=1245237;
 //BA.debugLineNum = 1245237;BA.debugLine="Dim saleValues() As Int = Array As Int(sale1(i),";
_salevalues = new int[]{_sale1[_i],_sale2[_i],_sale3[_i]};
RDebugUtils.currentLine=1245238;
 //BA.debugLineNum = 1245238;BA.debugLine="Dim indexOffset As Int = 0";
_indexoffset = (int) (0);
RDebugUtils.currentLine=1245240;
 //BA.debugLineNum = 1245240;BA.debugLine="For j = 0 To barsPerProduct - 1";
{
final int step44 = 1;
final int limit44 = (int) (_barsperproduct-1);
_j = (int) (0) ;
for (;_j <= limit44 ;_j = _j + step44 ) {
RDebugUtils.currentLine=1245241;
 //BA.debugLineNum = 1245241;BA.debugLine="If j < checkedSales.Length And checkedSales(j)";
if (_j<__ref._checkedsales /*boolean[]*/ .length && __ref._checkedsales /*boolean[]*/ [_j]) { 
RDebugUtils.currentLine=1245242;
 //BA.debugLineNum = 1245242;BA.debugLine="Dim sale As Int = saleValues(j)";
_sale = _salevalues[_j];
RDebugUtils.currentLine=1245243;
 //BA.debugLineNum = 1245243;BA.debugLine="Dim barHeight As Int = (sale / maxSale) * (act";
_barheight = (int) ((_sale/(double)_maxsale)*(_activitypanel.getHeight()));
RDebugUtils.currentLine=1245244;
 //BA.debugLineNum = 1245244;BA.debugLine="Dim xBar As Int = xPos + indexOffset * barWidt";
_xbar = (int) (_xpos+_indexoffset*_barwidth);
RDebugUtils.currentLine=1245246;
 //BA.debugLineNum = 1245246;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=1245247;
 //BA.debugLineNum = 1245247;BA.debugLine="r.Initialize(xBar, activityPanel.Height - barH";
_r.Initialize(_xbar,(int) (_activitypanel.getHeight()-_barheight),(int) (_xbar+_barwidth),_activitypanel.getHeight());
RDebugUtils.currentLine=1245248;
 //BA.debugLineNum = 1245248;BA.debugLine="graphCanvas.DrawRect(r, color(j), True, 2dip)";
_graphcanvas.DrawRect((android.graphics.Rect)(_r.getObject()),__ref._color /*int[]*/ [_j],__c.True,(float) (__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=1245250;
 //BA.debugLineNum = 1245250;BA.debugLine="Dim fontSize As Int = 8";
_fontsize = (int) (8);
RDebugUtils.currentLine=1245251;
 //BA.debugLineNum = 1245251;BA.debugLine="If Active.Width > 800 Then";
if (_active.getWidth()>800) { 
RDebugUtils.currentLine=1245252;
 //BA.debugLineNum = 1245252;BA.debugLine="fontSize = 10";
_fontsize = (int) (10);
 };
RDebugUtils.currentLine=1245254;
 //BA.debugLineNum = 1245254;BA.debugLine="graphCanvas.DrawText(FormatNumberWithSuffix(sa";
_graphcanvas.DrawText(ba,__ref._formatnumberwithsuffix /*String*/ (null,_sale),(float) (_xbar+(_barwidth/(double)2)),(float) (_activitypanel.getHeight()-_barheight-__c.DipToCurrent((int) (5))),__c.Typeface.MONOSPACE,(float) (_fontsize),__c.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
RDebugUtils.currentLine=1245255;
 //BA.debugLineNum = 1245255;BA.debugLine="indexOffset = indexOffset + 1";
_indexoffset = (int) (_indexoffset+1);
 };
 }
};
RDebugUtils.currentLine=1245259;
 //BA.debugLineNum = 1245259;BA.debugLine="Dim productLabel As Label";
_productlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1245260;
 //BA.debugLineNum = 1245260;BA.debugLine="productLabel.Initialize(\"productLabel\")";
_productlabel.Initialize(ba,"productLabel");
RDebugUtils.currentLine=1245261;
 //BA.debugLineNum = 1245261;BA.debugLine="productLabel.Text = product(i)";
_productlabel.setText(BA.ObjectToCharSequence(_product[_i]));
RDebugUtils.currentLine=1245262;
 //BA.debugLineNum = 1245262;BA.debugLine="productLabel.Typeface = Typeface.MONOSPACE";
_productlabel.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=1245263;
 //BA.debugLineNum = 1245263;BA.debugLine="productLabel.TextSize = 12";
_productlabel.setTextSize((float) (12));
RDebugUtils.currentLine=1245264;
 //BA.debugLineNum = 1245264;BA.debugLine="productLabel.Tag = comId1(i)";
_productlabel.setTag((Object)(__ref._comid1 /*int[]*/ [_i]));
RDebugUtils.currentLine=1245265;
 //BA.debugLineNum = 1245265;BA.debugLine="productLabel.TextColor = Colors.Black";
_productlabel.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=1245266;
 //BA.debugLineNum = 1245266;BA.debugLine="productLabel.Gravity = Gravity.CENTER";
_productlabel.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=1245267;
 //BA.debugLineNum = 1245267;BA.debugLine="Dim productLabelY As Int = activityPanel.Height";
_productlabely = (int) (_activitypanel.getHeight()+_aligntopcenter+__c.DipToCurrent((int) (10)));
RDebugUtils.currentLine=1245268;
 //BA.debugLineNum = 1245268;BA.debugLine="Dim productLabelX As Int = alignLeftCenter";
_productlabelx = _alignleftcenter;
RDebugUtils.currentLine=1245269;
 //BA.debugLineNum = 1245269;BA.debugLine="panel.AddView(productLabel, xPos + productLabelX";
_panel.AddView((android.view.View)(_productlabel.getObject()),(int) (_xpos+_productlabelx),_productlabely,__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (30)));
 }
};
RDebugUtils.currentLine=1245273;
 //BA.debugLineNum = 1245273;BA.debugLine="Dim numLabels As Int = 10";
_numlabels = (int) (10);
RDebugUtils.currentLine=1245274;
 //BA.debugLineNum = 1245274;BA.debugLine="For i = 0 To numLabels";
{
final int step73 = 1;
final int limit73 = _numlabels;
_i = (int) (0) ;
for (;_i <= limit73 ;_i = _i + step73 ) {
RDebugUtils.currentLine=1245275;
 //BA.debugLineNum = 1245275;BA.debugLine="Dim labelValue As Int = Round((maxSale / numLabe";
_labelvalue = (int) (__c.Round((_maxsale/(double)_numlabels)*_i));
RDebugUtils.currentLine=1245276;
 //BA.debugLineNum = 1245276;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - ((";
_labelypos = (int) (_activitypanel.getHeight()-((_labelvalue/(double)_maxsale)*_activitypanel.getHeight()));
RDebugUtils.currentLine=1245277;
 //BA.debugLineNum = 1245277;BA.debugLine="cv.DrawText(FormatNumberWithLabel(labelValue), a";
_cv.DrawText(ba,__ref._formatnumberwithlabel /*String*/ (null,_labelvalue),(float) (_alignleftcenter-__c.DipToCurrent((int) (10))),(float) (_labelypos+_aligntopcenter+__c.DipToCurrent((int) (5))),__c.Typeface.MONOSPACE,(float) (10),__c.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"RIGHT"));
 }
};
RDebugUtils.currentLine=1245281;
 //BA.debugLineNum = 1245281;BA.debugLine="btnBack.Initialize(\"btnBack\")";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .Initialize(ba,"btnBack");
RDebugUtils.currentLine=1245282;
 //BA.debugLineNum = 1245282;BA.debugLine="btnBack.Text = \"Back\"";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setText(BA.ObjectToCharSequence("Back"));
RDebugUtils.currentLine=1245283;
 //BA.debugLineNum = 1245283;BA.debugLine="btnBack.TextSize = 14";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTextSize((float) (14));
RDebugUtils.currentLine=1245284;
 //BA.debugLineNum = 1245284;BA.debugLine="btnBack.Typeface = Typeface.MONOSPACE";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=1245285;
 //BA.debugLineNum = 1245285;BA.debugLine="btnBack.TextColor = Colors.White";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTextColor(__c.Colors.White);
RDebugUtils.currentLine=1245286;
 //BA.debugLineNum = 1245286;BA.debugLine="Dim cdBack As ColorDrawable";
_cdback = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=1245287;
 //BA.debugLineNum = 1245287;BA.debugLine="cdBack.Initialize2(Colors.RGB(61, 12, 2), 10dip,";
_cdback.Initialize2(__c.Colors.RGB((int) (61),(int) (12),(int) (2)),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (2)),__c.Colors.Black);
RDebugUtils.currentLine=1245288;
 //BA.debugLineNum = 1245288;BA.debugLine="btnBack.Background = cdBack";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setBackground((android.graphics.drawable.Drawable)(_cdback.getObject()));
RDebugUtils.currentLine=1245289;
 //BA.debugLineNum = 1245289;BA.debugLine="panel.AddView(btnBack, alignLeftCenter, activityP";
_panel.AddView((android.view.View)(__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .getObject()),_alignleftcenter,(int) (_activitypanel.getHeight()+_aligntopcenter+__c.DipToCurrent((int) (50))),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
RDebugUtils.currentLine=1245291;
 //BA.debugLineNum = 1245291;BA.debugLine="btnNext.Initialize(\"btnNext\")";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .Initialize(ba,"btnNext");
RDebugUtils.currentLine=1245292;
 //BA.debugLineNum = 1245292;BA.debugLine="btnNext.Text = \"Next\"";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setText(BA.ObjectToCharSequence("Next"));
RDebugUtils.currentLine=1245293;
 //BA.debugLineNum = 1245293;BA.debugLine="btnNext.TextSize = 14";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTextSize((float) (14));
RDebugUtils.currentLine=1245294;
 //BA.debugLineNum = 1245294;BA.debugLine="btnNext.Typeface = Typeface.MONOSPACE";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=1245295;
 //BA.debugLineNum = 1245295;BA.debugLine="btnNext.TextColor = Colors.White";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setTextColor(__c.Colors.White);
RDebugUtils.currentLine=1245296;
 //BA.debugLineNum = 1245296;BA.debugLine="Dim cdNext As ColorDrawable";
_cdnext = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=1245297;
 //BA.debugLineNum = 1245297;BA.debugLine="cdNext.Initialize2(Colors.RGB(185, 46, 52), 10dip";
_cdnext.Initialize2(__c.Colors.RGB((int) (185),(int) (46),(int) (52)),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (2)),__c.Colors.Black);
RDebugUtils.currentLine=1245298;
 //BA.debugLineNum = 1245298;BA.debugLine="btnNext.Background = cdNext";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setBackground((android.graphics.drawable.Drawable)(_cdnext.getObject()));
RDebugUtils.currentLine=1245299;
 //BA.debugLineNum = 1245299;BA.debugLine="panel.AddView(btnNext, panel.Width - alignLeftCen";
_panel.AddView((android.view.View)(__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .getObject()),(int) (_panel.getWidth()-_alignleftcenter-__c.DipToCurrent((int) (100))),(int) (_activitypanel.getHeight()+_aligntopcenter+__c.DipToCurrent((int) (50))),__c.DipToCurrent((int) (100)),__c.DipToCurrent((int) (40)));
RDebugUtils.currentLine=1245302;
 //BA.debugLineNum = 1245302;BA.debugLine="btnBack.Enabled = (currentPage > 1)";
__ref._btnback /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setEnabled((__ref._currentpage /*int*/ >1));
RDebugUtils.currentLine=1245303;
 //BA.debugLineNum = 1245303;BA.debugLine="btnNext.Enabled = (endIndex < totalProducts - 1)";
__ref._btnnext /*anywheresoftware.b4a.objects.ButtonWrapper*/ .setEnabled((_endindex<_totalproducts-1));
RDebugUtils.currentLine=1245304;
 //BA.debugLineNum = 1245304;BA.debugLine="End Sub";
return "";
}
public String  _btnnext_click(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "btnnext_click", false))
	 {return ((String) Debug.delegate(ba, "btnnext_click", null));}
RDebugUtils.currentLine=6684672;
 //BA.debugLineNum = 6684672;BA.debugLine="Sub btnNext_Click";
RDebugUtils.currentLine=6684673;
 //BA.debugLineNum = 6684673;BA.debugLine="currentPage = currentPage + 1";
__ref._currentpage /*int*/  = (int) (__ref._currentpage /*int*/ +1);
RDebugUtils.currentLine=6684674;
 //BA.debugLineNum = 6684674;BA.debugLine="DrawGraph(Active1, panel_l, sale_1, sale_2, sale_";
__ref._drawgraph /*String*/ (null,__ref._active1 /*anywheresoftware.b4a.objects.ActivityWrapper*/ ,__ref._panel_l /*anywheresoftware.b4a.objects.PanelWrapper*/ ,__ref._sale_1 /*int[]*/ ,__ref._sale_2 /*int[]*/ ,__ref._sale_3 /*int[]*/ ,__ref._product1 /*String[]*/ ,__ref._maxsales1 /*int*/ ,__ref._titlestring1 /*String*/ );
RDebugUtils.currentLine=6684675;
 //BA.debugLineNum = 6684675;BA.debugLine="End Sub";
return "";
}
public String  _chkchange_checkedchange(b4a.example.bargraph __ref,boolean _checked) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "chkchange_checkedchange", false))
	 {return ((String) Debug.delegate(ba, "chkchange_checkedchange", new Object[] {_checked}));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk = null;
int _index = 0;
int _checkedcount = 0;
int _i = 0;
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub chkChange_CheckedChange(Checked As Boolean)";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="If Sender Is CheckBox Then";
if (__c.Sender(ba) instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="Dim chk As CheckBox = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper(), (android.widget.CheckBox)(__c.Sender(ba)));
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="Dim index As Int = chk.Tag";
_index = (int)(BA.ObjectToNumber(_chk.getTag()));
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="Dim checkedCount As Int = 0";
_checkedcount = (int) (0);
RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="For i = 0 To checkedSales.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (__ref._checkedsales /*boolean[]*/ .length-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="If checkedSales(i) = True Then checkedCount = c";
if (__ref._checkedsales /*boolean[]*/ [_i]==__c.True) { 
_checkedcount = (int) (_checkedcount+1);};
 }
};
RDebugUtils.currentLine=1310730;
 //BA.debugLineNum = 1310730;BA.debugLine="If Checked = False And checkedCount = 1 Then";
if (_checked==__c.False && _checkedcount==1) { 
RDebugUtils.currentLine=1310731;
 //BA.debugLineNum = 1310731;BA.debugLine="chk.Checked = True";
_chk.setChecked(__c.True);
RDebugUtils.currentLine=1310732;
 //BA.debugLineNum = 1310732;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1310735;
 //BA.debugLineNum = 1310735;BA.debugLine="checkedSales(index) = Checked";
__ref._checkedsales /*boolean[]*/ [_index] = _checked;
RDebugUtils.currentLine=1310736;
 //BA.debugLineNum = 1310736;BA.debugLine="DrawGraph(Active1, panel_l, sale_1, sale_2, sale";
__ref._drawgraph /*String*/ (null,__ref._active1 /*anywheresoftware.b4a.objects.ActivityWrapper*/ ,__ref._panel_l /*anywheresoftware.b4a.objects.PanelWrapper*/ ,__ref._sale_1 /*int[]*/ ,__ref._sale_2 /*int[]*/ ,__ref._sale_3 /*int[]*/ ,__ref._product1 /*String[]*/ ,__ref._maxsales1 /*int*/ ,__ref._titlestring1 /*String*/ );
RDebugUtils.currentLine=1310737;
 //BA.debugLineNum = 1310737;BA.debugLine="panel_l.Invalidate";
__ref._panel_l /*anywheresoftware.b4a.objects.PanelWrapper*/ .Invalidate();
 }else {
RDebugUtils.currentLine=1310739;
 //BA.debugLineNum = 1310739;BA.debugLine="Log(\"Error: Sender is not a CheckBox\")";
__c.LogImpl("51310739","Error: Sender is not a CheckBox",0);
 };
RDebugUtils.currentLine=1310741;
 //BA.debugLineNum = 1310741;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="Private checkBoxes() As CheckBox";
_checkboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[(int) (0)];
{
int d0 = _checkboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_checkboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="Private checkedSales() As Boolean";
_checkedsales = new boolean[(int) (0)];
;
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="Dim color() As Int = Array As Int(Colors.RGB(255,";
_color = new int[]{__c.Colors.RGB((int) (255),(int) (0),(int) (0)),__c.Colors.RGB((int) (200),(int) (20),(int) (20)),__c.Colors.RGB((int) (100),(int) (10),(int) (10))};
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="Dim legendPanel As Panel";
_legendpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="Dim Active1 As Activity";
_active1 = new anywheresoftware.b4a.objects.ActivityWrapper();
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="Dim panel_l As Panel";
_panel_l = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1114119;
 //BA.debugLineNum = 1114119;BA.debugLine="Dim sale_1() As Int";
_sale_1 = new int[(int) (0)];
;
RDebugUtils.currentLine=1114120;
 //BA.debugLineNum = 1114120;BA.debugLine="Dim sale_2() As Int";
_sale_2 = new int[(int) (0)];
;
RDebugUtils.currentLine=1114121;
 //BA.debugLineNum = 1114121;BA.debugLine="Dim sale_3() As Int";
_sale_3 = new int[(int) (0)];
;
RDebugUtils.currentLine=1114122;
 //BA.debugLineNum = 1114122;BA.debugLine="Dim product1() As String";
_product1 = new String[(int) (0)];
java.util.Arrays.fill(_product1,"");
RDebugUtils.currentLine=1114123;
 //BA.debugLineNum = 1114123;BA.debugLine="Dim legend1() As String";
_legend1 = new String[(int) (0)];
java.util.Arrays.fill(_legend1,"");
RDebugUtils.currentLine=1114124;
 //BA.debugLineNum = 1114124;BA.debugLine="Dim maxSales1 As Int = 0";
_maxsales1 = (int) (0);
RDebugUtils.currentLine=1114125;
 //BA.debugLineNum = 1114125;BA.debugLine="Dim titleString1 As String = \"\"";
_titlestring1 = "";
RDebugUtils.currentLine=1114126;
 //BA.debugLineNum = 1114126;BA.debugLine="Dim comId1() As Int";
_comid1 = new int[(int) (0)];
;
RDebugUtils.currentLine=1114128;
 //BA.debugLineNum = 1114128;BA.debugLine="Private currentPage As Int = 1";
_currentpage = (int) (1);
RDebugUtils.currentLine=1114129;
 //BA.debugLineNum = 1114129;BA.debugLine="Private itemsPerPage As Int = 5 ' Adjust this bas";
_itemsperpage = (int) (5);
RDebugUtils.currentLine=1114130;
 //BA.debugLineNum = 1114130;BA.debugLine="Private btnNext As Button";
_btnnext = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=1114131;
 //BA.debugLineNum = 1114131;BA.debugLine="Private btnBack As Button";
_btnback = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=1114132;
 //BA.debugLineNum = 1114132;BA.debugLine="Dim layout As String = \"\"";
_layout = "";
RDebugUtils.currentLine=1114133;
 //BA.debugLineNum = 1114133;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithsuffix(b4a.example.bargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithsuffix", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithsuffix", new Object[] {_number}));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
if (true) return __c.NumberFormat(_number/(double)1000000,(int) (1),(int) (1))+"M";
 }else 
{RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
if (true) return __c.NumberFormat(_number/(double)1000,(int) (1),(int) (1))+"k";
 }else {
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="Return NumberFormat(number, 1, 0)";
if (true) return __c.NumberFormat(_number,(int) (1),(int) (0));
 }}
;
RDebugUtils.currentLine=1376264;
 //BA.debugLineNum = 1376264;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithlabel(b4a.example.bargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithlabel", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithlabel", new Object[] {_number}));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub FormatNumberWithLabel(number As Int) As String";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="Return Floor(number / 1000000) & \"M\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000000))+"M";
 }else 
{RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="Return Floor(number / 1000) & \"k\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000))+"k";
 }else {
RDebugUtils.currentLine=1441798;
 //BA.debugLineNum = 1441798;BA.debugLine="Return number";
if (true) return BA.NumberToString(_number);
 }}
;
RDebugUtils.currentLine=1441800;
 //BA.debugLineNum = 1441800;BA.debugLine="End Sub";
return "";
}
public String  _productlabel_click(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "productlabel_click", false))
	 {return ((String) Debug.delegate(ba, "productlabel_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _clickedlabel = null;
int _selectedcompany = 0;
RDebugUtils.currentLine=6619136;
 //BA.debugLineNum = 6619136;BA.debugLine="Sub productLabel_Click";
RDebugUtils.currentLine=6619137;
 //BA.debugLineNum = 6619137;BA.debugLine="Dim clickedLabel As Label = Sender";
_clickedlabel = new anywheresoftware.b4a.objects.LabelWrapper();
_clickedlabel = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(__c.Sender(ba)));
RDebugUtils.currentLine=6619138;
 //BA.debugLineNum = 6619138;BA.debugLine="Dim selectedCompany As Int = clickedLabel.Tag";
_selectedcompany = (int)(BA.ObjectToNumber(_clickedlabel.getTag()));
RDebugUtils.currentLine=6619139;
 //BA.debugLineNum = 6619139;BA.debugLine="Log(\"Selected Company ID: \" & selectedCompany)";
__c.LogImpl("56619139","Selected Company ID: "+BA.NumberToString(_selectedcompany),0);
RDebugUtils.currentLine=6619140;
 //BA.debugLineNum = 6619140;BA.debugLine="StartActivity(layout)";
__c.StartActivity(ba,(Object)(__ref._layout /*String*/ ));
RDebugUtils.currentLine=6619141;
 //BA.debugLineNum = 6619141;BA.debugLine="Active1.Finish";
__ref._active1 /*anywheresoftware.b4a.objects.ActivityWrapper*/ .Finish();
RDebugUtils.currentLine=6619142;
 //BA.debugLineNum = 6619142;BA.debugLine="End Sub";
return "";
}
}