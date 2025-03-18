package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class checkbargraph extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.checkbargraph");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.checkbargraph.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.ActivityWrapper _active = null;
public anywheresoftware.b4a.objects.PanelWrapper _barpanel = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nxtbtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _backbtn = null;
public int[] _sales = null;
public int[] _sales1 = null;
public int[] _sales2 = null;
public String[] _comname = null;
public int _maxsale = 0;
public b4a.example.main _main = null;
public b4a.example.branch _branch = null;
public b4a.example.device _device = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public String  _chkchange_checkedchange(b4a.example.checkbargraph __ref,boolean _checked) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "chkchange_checkedchange", false))
	 {return ((String) Debug.delegate(ba, "chkchange_checkedchange", new Object[] {_checked}));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk = null;
int _index = 0;
int _checkedcount = 0;
int _i = 0;
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub chkChange_CheckedChange(Checked As Boolean)";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="If Sender Is CheckBox Then";
if (__c.Sender(ba) instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="Dim chk As CheckBox = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper(), (android.widget.CheckBox)(__c.Sender(ba)));
RDebugUtils.currentLine=3342339;
 //BA.debugLineNum = 3342339;BA.debugLine="Dim index As Int = chk.Tag";
_index = (int)(BA.ObjectToNumber(_chk.getTag()));
RDebugUtils.currentLine=3342341;
 //BA.debugLineNum = 3342341;BA.debugLine="Dim checkedCount As Int = 0";
_checkedcount = (int) (0);
RDebugUtils.currentLine=3342342;
 //BA.debugLineNum = 3342342;BA.debugLine="For i = 0 To checkedSales.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (__ref._checkedsales /*boolean[]*/ .length-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=3342343;
 //BA.debugLineNum = 3342343;BA.debugLine="If checkedSales(i) = True Then checkedCount = c";
if (__ref._checkedsales /*boolean[]*/ [_i]==__c.True) { 
_checkedcount = (int) (_checkedcount+1);};
 }
};
RDebugUtils.currentLine=3342346;
 //BA.debugLineNum = 3342346;BA.debugLine="If Checked = False And checkedCount = 1 Then";
if (_checked==__c.False && _checkedcount==1) { 
RDebugUtils.currentLine=3342347;
 //BA.debugLineNum = 3342347;BA.debugLine="chk.Checked = True";
_chk.setChecked(__c.True);
RDebugUtils.currentLine=3342348;
 //BA.debugLineNum = 3342348;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=3342351;
 //BA.debugLineNum = 3342351;BA.debugLine="checkedSales(index) = Checked";
__ref._checkedsales /*boolean[]*/ [_index] = _checked;
RDebugUtils.currentLine=3342352;
 //BA.debugLineNum = 3342352;BA.debugLine="DrawGraph ' Call DrawGraph without parameters";
__ref._drawgraph /*String*/ (null);
 }else {
RDebugUtils.currentLine=3342354;
 //BA.debugLineNum = 3342354;BA.debugLine="Log(\"Error: Sender is not a CheckBox\")";
__c.LogImpl("63342354","Error: Sender is not a CheckBox",0);
 };
RDebugUtils.currentLine=3342356;
 //BA.debugLineNum = 3342356;BA.debugLine="End Sub";
return "";
}
public String  _drawgraph(b4a.example.checkbargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "drawgraph", false))
	 {return ((String) Debug.delegate(ba, "drawgraph", null));}
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub DrawGraph()";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="DrawGraph1(Active, barPanel, nxtBtn, backBtn, sal";
__ref._drawgraph1 /*String*/ (null,__ref._active /*anywheresoftware.b4a.objects.ActivityWrapper*/ ,__ref._barpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ ,__ref._nxtbtn /*anywheresoftware.b4a.objects.ButtonWrapper*/ ,__ref._backbtn /*anywheresoftware.b4a.objects.ButtonWrapper*/ ,__ref._sales /*int[]*/ ,__ref._sales1 /*int[]*/ ,__ref._sales2 /*int[]*/ ,__ref._comname /*String[]*/ ,__ref._maxsale /*int*/ );
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.checkbargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="Private checkBoxes() As CheckBox";
_checkboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[(int) (0)];
{
int d0 = _checkboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_checkboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="Private checkedSales() As Boolean";
_checkedsales = new boolean[(int) (0)];
;
RDebugUtils.currentLine=3145733;
 //BA.debugLineNum = 3145733;BA.debugLine="Private Active As Activity";
_active = new anywheresoftware.b4a.objects.ActivityWrapper();
RDebugUtils.currentLine=3145734;
 //BA.debugLineNum = 3145734;BA.debugLine="Private barPanel As Panel";
_barpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3145735;
 //BA.debugLineNum = 3145735;BA.debugLine="Private nxtBtn As Button";
_nxtbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=3145736;
 //BA.debugLineNum = 3145736;BA.debugLine="Private backBtn As Button";
_backbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=3145737;
 //BA.debugLineNum = 3145737;BA.debugLine="Private sales() As Int";
_sales = new int[(int) (0)];
;
RDebugUtils.currentLine=3145738;
 //BA.debugLineNum = 3145738;BA.debugLine="Private sales1() As Int";
_sales1 = new int[(int) (0)];
;
RDebugUtils.currentLine=3145739;
 //BA.debugLineNum = 3145739;BA.debugLine="Private sales2() As Int";
_sales2 = new int[(int) (0)];
;
RDebugUtils.currentLine=3145740;
 //BA.debugLineNum = 3145740;BA.debugLine="Private comName() As String";
_comname = new String[(int) (0)];
java.util.Arrays.fill(_comname,"");
RDebugUtils.currentLine=3145741;
 //BA.debugLineNum = 3145741;BA.debugLine="Private maxSale As Int";
_maxsale = 0;
RDebugUtils.currentLine=3145742;
 //BA.debugLineNum = 3145742;BA.debugLine="End Sub";
return "";
}
public String  _drawgraph1(b4a.example.checkbargraph __ref,anywheresoftware.b4a.objects.ActivityWrapper _active1,anywheresoftware.b4a.objects.PanelWrapper _barpanel1,anywheresoftware.b4a.objects.ButtonWrapper _nextbtn,anywheresoftware.b4a.objects.ButtonWrapper _bckbtn,int[] _sales_1,int[] _sales_2,int[] _sales_3,String[] _comname1,int _maxsale1) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "drawgraph1", false))
	 {return ((String) Debug.delegate(ba, "drawgraph1", new Object[] {_active1,_barpanel1,_nextbtn,_bckbtn,_sales_1,_sales_2,_sales_3,_comname1,_maxsale1}));}
int[] _color = null;
anywheresoftware.b4a.objects.PanelWrapper _activitypanel = null;
int _alignleftcenter = 0;
int _aligntopcenter = 0;
int _btnleft = 0;
anywheresoftware.b4a.objects.LabelWrapper _titlelabel = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _graphcanvas = null;
int _totalproducts = 0;
int _barsperproduct = 0;
int _gap = 0;
int _productgap = 0;
int _padding = 0;
int _numlabels = 0;
int _labelstep = 0;
int _labelheightstep = 0;
int _i = 0;
int _lbly = 0;
int _lblvalue = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblleft = null;
int _checkedcount = 0;
int _availablewidth = 0;
int _barwidth = 0;
int _xstart = 0;
int _xpos = 0;
int[] _salevalues = null;
int _indexoffset = 0;
int _j = 0;
int _sale = 0;
int _barheight = 0;
int _xbar = 0;
anywheresoftware.b4a.objects.LabelWrapper _lblsale = null;
int _lblsaleleft = 0;
int _lblsaletop = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r = null;
anywheresoftware.b4a.objects.LabelWrapper _lblcompany = null;
int _totalbarwidth = 0;
int _lblcompanywidth = 0;
int _lblcompanyleft = 0;
int _lblcompanytop = 0;
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Public Sub DrawGraph1(Active1 As Activity,barPanel";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="barPanel1.Initialize(\"\")";
_barpanel1.Initialize(ba,"");
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="barPanel1.RemoveAllViews ' Clear previous drawing";
_barpanel1.RemoveAllViews();
RDebugUtils.currentLine=3407876;
 //BA.debugLineNum = 3407876;BA.debugLine="Dim Color() As Int = Array As Int(Colors.Red, Col";
_color = new int[]{__c.Colors.Red,__c.Colors.Green,__c.Colors.Blue};
RDebugUtils.currentLine=3407877;
 //BA.debugLineNum = 3407877;BA.debugLine="Dim activityPanel As Panel";
_activitypanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3407878;
 //BA.debugLineNum = 3407878;BA.debugLine="activityPanel.Initialize(\"\")";
_activitypanel.Initialize(ba,"");
RDebugUtils.currentLine=3407879;
 //BA.debugLineNum = 3407879;BA.debugLine="activityPanel.Width = 75%x";
_activitypanel.setWidth(__c.PerXToCurrent((float) (75),ba));
RDebugUtils.currentLine=3407880;
 //BA.debugLineNum = 3407880;BA.debugLine="If Active1.Width >800 Then";
if (_active1.getWidth()>800) { 
RDebugUtils.currentLine=3407881;
 //BA.debugLineNum = 3407881;BA.debugLine="activityPanel.Width = 70%x";
_activitypanel.setWidth(__c.PerXToCurrent((float) (70),ba));
 };
RDebugUtils.currentLine=3407883;
 //BA.debugLineNum = 3407883;BA.debugLine="activityPanel.Height = 250dip";
_activitypanel.setHeight(__c.DipToCurrent((int) (250)));
RDebugUtils.currentLine=3407884;
 //BA.debugLineNum = 3407884;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211, 2";
_activitypanel.setColor(__c.Colors.ARGB((int) (70),(int) (211),(int) (211),(int) (211)));
RDebugUtils.currentLine=3407886;
 //BA.debugLineNum = 3407886;BA.debugLine="Dim alignLeftCenter As Int = 0 ' Ensure left alig";
_alignleftcenter = (int) (0);
RDebugUtils.currentLine=3407887;
 //BA.debugLineNum = 3407887;BA.debugLine="If checkedSales.Length > 1 Then";
if (__ref._checkedsales /*boolean[]*/ .length>1) { 
RDebugUtils.currentLine=3407888;
 //BA.debugLineNum = 3407888;BA.debugLine="alignLeftCenter = (barPanel1.Width - activityPan";
_alignleftcenter = (int) ((_barpanel1.getWidth()-_activitypanel.getWidth())/(double)2);
 };
RDebugUtils.currentLine=3407891;
 //BA.debugLineNum = 3407891;BA.debugLine="Dim alignTopCenter As Int = (barPanel1.Height - a";
_aligntopcenter = (int) ((_barpanel1.getHeight()-_activitypanel.getHeight())/(double)2);
RDebugUtils.currentLine=3407892;
 //BA.debugLineNum = 3407892;BA.debugLine="Dim btnLeft As Int = 0";
_btnleft = (int) (0);
RDebugUtils.currentLine=3407894;
 //BA.debugLineNum = 3407894;BA.debugLine="Dim titleLabel As Label";
_titlelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3407895;
 //BA.debugLineNum = 3407895;BA.debugLine="titleLabel.Initialize(\"\")";
_titlelabel.Initialize(ba,"");
RDebugUtils.currentLine=3407896;
 //BA.debugLineNum = 3407896;BA.debugLine="titleLabel.Text=\"Total Sales For Each Company\"";
_titlelabel.setText(BA.ObjectToCharSequence("Total Sales For Each Company"));
RDebugUtils.currentLine=3407897;
 //BA.debugLineNum = 3407897;BA.debugLine="titleLabel.Gravity = Gravity.CENTER";
_titlelabel.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=3407898;
 //BA.debugLineNum = 3407898;BA.debugLine="titleLabel.Typeface = Typeface.MONOSPACE";
_titlelabel.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=3407899;
 //BA.debugLineNum = 3407899;BA.debugLine="titleLabel.TextSize = 20";
_titlelabel.setTextSize((float) (20));
RDebugUtils.currentLine=3407900;
 //BA.debugLineNum = 3407900;BA.debugLine="titleLabel.TextColor = Colors.Black";
_titlelabel.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=3407901;
 //BA.debugLineNum = 3407901;BA.debugLine="barPanel1.AddView(titleLabel,0,alignTopCenter - 4";
_barpanel1.AddView((android.view.View)(_titlelabel.getObject()),(int) (0),(int) (_aligntopcenter-__c.DipToCurrent((int) (40))),_barpanel1.getWidth(),__c.DipToCurrent((int) (50)));
RDebugUtils.currentLine=3407902;
 //BA.debugLineNum = 3407902;BA.debugLine="barPanel1.AddView(activityPanel, alignLeftCenter,";
_barpanel1.AddView((android.view.View)(_activitypanel.getObject()),_alignleftcenter,_aligntopcenter,_activitypanel.getWidth(),_activitypanel.getHeight());
RDebugUtils.currentLine=3407904;
 //BA.debugLineNum = 3407904;BA.debugLine="Dim graphCanvas As Canvas";
_graphcanvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=3407905;
 //BA.debugLineNum = 3407905;BA.debugLine="graphCanvas.Initialize(activityPanel)";
_graphcanvas.Initialize((android.view.View)(_activitypanel.getObject()));
RDebugUtils.currentLine=3407907;
 //BA.debugLineNum = 3407907;BA.debugLine="maxSale1 = maxSale1 * 1.2";
_maxsale1 = (int) (_maxsale1*1.2);
RDebugUtils.currentLine=3407908;
 //BA.debugLineNum = 3407908;BA.debugLine="Dim totalProducts As Int = sales_1.Length";
_totalproducts = _sales_1.length;
RDebugUtils.currentLine=3407909;
 //BA.debugLineNum = 3407909;BA.debugLine="Dim barsPerProduct As Int = 3";
_barsperproduct = (int) (3);
RDebugUtils.currentLine=3407910;
 //BA.debugLineNum = 3407910;BA.debugLine="Dim gap As Int = 15dip";
_gap = __c.DipToCurrent((int) (15));
RDebugUtils.currentLine=3407911;
 //BA.debugLineNum = 3407911;BA.debugLine="Dim productGap As Int = 5dip";
_productgap = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=3407912;
 //BA.debugLineNum = 3407912;BA.debugLine="Dim padding As Int = 0 ' Remove left padding when";
_padding = (int) (0);
RDebugUtils.currentLine=3407915;
 //BA.debugLineNum = 3407915;BA.debugLine="Dim numLabels As Int = 10";
_numlabels = (int) (10);
RDebugUtils.currentLine=3407916;
 //BA.debugLineNum = 3407916;BA.debugLine="Dim labelStep As Int = maxSale1 / numLabels";
_labelstep = (int) (_maxsale1/(double)_numlabels);
RDebugUtils.currentLine=3407917;
 //BA.debugLineNum = 3407917;BA.debugLine="Dim labelHeightStep As Int = activityPanel.Height";
_labelheightstep = (int) (_activitypanel.getHeight()/(double)_numlabels);
RDebugUtils.currentLine=3407919;
 //BA.debugLineNum = 3407919;BA.debugLine="For i = 0 To numLabels";
{
final int step38 = 1;
final int limit38 = _numlabels;
_i = (int) (0) ;
for (;_i <= limit38 ;_i = _i + step38 ) {
RDebugUtils.currentLine=3407920;
 //BA.debugLineNum = 3407920;BA.debugLine="Dim lblY As Int = activityPanel.Height - (i * la";
_lbly = (int) (_activitypanel.getHeight()-(_i*_labelheightstep)+_aligntopcenter-__c.DipToCurrent((int) (10)));
RDebugUtils.currentLine=3407921;
 //BA.debugLineNum = 3407921;BA.debugLine="Dim lblValue As Int = i * labelStep";
_lblvalue = (int) (_i*_labelstep);
RDebugUtils.currentLine=3407923;
 //BA.debugLineNum = 3407923;BA.debugLine="Dim lblLeft As Label";
_lblleft = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3407924;
 //BA.debugLineNum = 3407924;BA.debugLine="lblLeft.Initialize(\"\")";
_lblleft.Initialize(ba,"");
RDebugUtils.currentLine=3407925;
 //BA.debugLineNum = 3407925;BA.debugLine="lblLeft.Text = FormatNumberWithLabel(lblValue)";
_lblleft.setText(BA.ObjectToCharSequence(__ref._formatnumberwithlabel /*String*/ (null,_lblvalue)));
RDebugUtils.currentLine=3407926;
 //BA.debugLineNum = 3407926;BA.debugLine="lblLeft.TextColor = Colors.Black";
_lblleft.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=3407927;
 //BA.debugLineNum = 3407927;BA.debugLine="lblLeft.Gravity = Gravity.RIGHT";
_lblleft.setGravity(__c.Gravity.RIGHT);
RDebugUtils.currentLine=3407928;
 //BA.debugLineNum = 3407928;BA.debugLine="lblLeft.Typeface = Typeface.MONOSPACE";
_lblleft.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=3407929;
 //BA.debugLineNum = 3407929;BA.debugLine="lblLeft.TextSize = 10";
_lblleft.setTextSize((float) (10));
RDebugUtils.currentLine=3407930;
 //BA.debugLineNum = 3407930;BA.debugLine="lblLeft.Color = Colors.Transparent";
_lblleft.setColor(__c.Colors.Transparent);
RDebugUtils.currentLine=3407932;
 //BA.debugLineNum = 3407932;BA.debugLine="barPanel1.AddView(lblLeft, alignLeftCenter - 45d";
_barpanel1.AddView((android.view.View)(_lblleft.getObject()),(int) (_alignleftcenter-__c.DipToCurrent((int) (45))),_lbly,__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (20)));
 }
};
RDebugUtils.currentLine=3407935;
 //BA.debugLineNum = 3407935;BA.debugLine="Dim checkedCount As Int = 0";
_checkedcount = (int) (0);
RDebugUtils.currentLine=3407936;
 //BA.debugLineNum = 3407936;BA.debugLine="For i = 0 To checkedSales.Length - 1";
{
final int step52 = 1;
final int limit52 = (int) (__ref._checkedsales /*boolean[]*/ .length-1);
_i = (int) (0) ;
for (;_i <= limit52 ;_i = _i + step52 ) {
RDebugUtils.currentLine=3407937;
 //BA.debugLineNum = 3407937;BA.debugLine="If checkedSales(i) Then checkedCount = checkedCo";
if (__ref._checkedsales /*boolean[]*/ [_i]) { 
_checkedcount = (int) (_checkedcount+1);};
 }
};
RDebugUtils.currentLine=3407940;
 //BA.debugLineNum = 3407940;BA.debugLine="Dim availableWidth As Int = activityPanel.Width -";
_availablewidth = (int) (_activitypanel.getWidth()-((_totalproducts-1)*_productgap));
RDebugUtils.currentLine=3407941;
 //BA.debugLineNum = 3407941;BA.debugLine="Dim barWidth As Int = availableWidth / (totalProd";
_barwidth = (int) (_availablewidth/(double)(_totalproducts*_checkedcount));
RDebugUtils.currentLine=3407943;
 //BA.debugLineNum = 3407943;BA.debugLine="If sales_1.Length <= 4 Then";
if (_sales_1.length<=4) { 
RDebugUtils.currentLine=3407944;
 //BA.debugLineNum = 3407944;BA.debugLine="barWidth = 30dip";
_barwidth = __c.DipToCurrent((int) (30));
 };
RDebugUtils.currentLine=3407946;
 //BA.debugLineNum = 3407946;BA.debugLine="If Active1.Width > 800 Then";
if (_active1.getWidth()>800) { 
RDebugUtils.currentLine=3407947;
 //BA.debugLineNum = 3407947;BA.debugLine="If checkedCount =1 Then";
if (_checkedcount==1) { 
RDebugUtils.currentLine=3407948;
 //BA.debugLineNum = 3407948;BA.debugLine="barWidth = 30dip";
_barwidth = __c.DipToCurrent((int) (30));
RDebugUtils.currentLine=3407949;
 //BA.debugLineNum = 3407949;BA.debugLine="productGap = 45.5dip";
_productgap = __c.DipToCurrent((int) (45.5));
 };
 }else {
RDebugUtils.currentLine=3407952;
 //BA.debugLineNum = 3407952;BA.debugLine="If checkedCount =1 Then";
if (_checkedcount==1) { 
RDebugUtils.currentLine=3407953;
 //BA.debugLineNum = 3407953;BA.debugLine="barWidth = 30dip";
_barwidth = __c.DipToCurrent((int) (30));
RDebugUtils.currentLine=3407954;
 //BA.debugLineNum = 3407954;BA.debugLine="productGap = 18dip";
_productgap = __c.DipToCurrent((int) (18));
 };
 };
RDebugUtils.currentLine=3407959;
 //BA.debugLineNum = 3407959;BA.debugLine="Dim xStart As Int = 5dip ' Start from left when o";
_xstart = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=3407962;
 //BA.debugLineNum = 3407962;BA.debugLine="For i = 0 To totalProducts - 1";
{
final int step72 = 1;
final int limit72 = (int) (_totalproducts-1);
_i = (int) (0) ;
for (;_i <= limit72 ;_i = _i + step72 ) {
RDebugUtils.currentLine=3407963;
 //BA.debugLineNum = 3407963;BA.debugLine="Dim xPos As Int = xStart + (i * (checkedCount *";
_xpos = (int) (_xstart+(_i*(_checkedcount*_barwidth+_productgap)));
RDebugUtils.currentLine=3407964;
 //BA.debugLineNum = 3407964;BA.debugLine="Dim saleValues() As Int = Array As Int(sales_1(i";
_salevalues = new int[]{_sales_1[_i],_sales_2[_i],_sales_3[_i]};
RDebugUtils.currentLine=3407966;
 //BA.debugLineNum = 3407966;BA.debugLine="Dim indexOffset As Int = 0 ' Shift bars properly";
_indexoffset = (int) (0);
RDebugUtils.currentLine=3407968;
 //BA.debugLineNum = 3407968;BA.debugLine="For j = 0 To barsPerProduct - 1";
{
final int step76 = 1;
final int limit76 = (int) (_barsperproduct-1);
_j = (int) (0) ;
for (;_j <= limit76 ;_j = _j + step76 ) {
RDebugUtils.currentLine=3407969;
 //BA.debugLineNum = 3407969;BA.debugLine="If j < checkedSales.Length And checkedSales(j)";
if (_j<__ref._checkedsales /*boolean[]*/ .length && __ref._checkedsales /*boolean[]*/ [_j]) { 
RDebugUtils.currentLine=3407970;
 //BA.debugLineNum = 3407970;BA.debugLine="Dim sale As Int = saleValues(j)";
_sale = _salevalues[_j];
RDebugUtils.currentLine=3407971;
 //BA.debugLineNum = 3407971;BA.debugLine="Dim barHeight As Int = (sale / maxSale1) * act";
_barheight = (int) ((_sale/(double)_maxsale1)*_activitypanel.getHeight());
RDebugUtils.currentLine=3407972;
 //BA.debugLineNum = 3407972;BA.debugLine="Dim xBar As Int = xPos + indexOffset * barWidt";
_xbar = (int) (_xpos+_indexoffset*_barwidth);
RDebugUtils.currentLine=3407975;
 //BA.debugLineNum = 3407975;BA.debugLine="Dim lblSale As Label";
_lblsale = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3407976;
 //BA.debugLineNum = 3407976;BA.debugLine="lblSale.Initialize(\"\")";
_lblsale.Initialize(ba,"");
RDebugUtils.currentLine=3407977;
 //BA.debugLineNum = 3407977;BA.debugLine="lblSale.Text = FormatNumberWithSuffix(sale) '";
_lblsale.setText(BA.ObjectToCharSequence(__ref._formatnumberwithsuffix /*String*/ (null,_sale)));
RDebugUtils.currentLine=3407978;
 //BA.debugLineNum = 3407978;BA.debugLine="lblSale.TextColor = Colors.Black";
_lblsale.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=3407979;
 //BA.debugLineNum = 3407979;BA.debugLine="lblSale.Gravity = Gravity.CENTER";
_lblsale.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=3407980;
 //BA.debugLineNum = 3407980;BA.debugLine="lblSale.Typeface = Typeface.MONOSPACE";
_lblsale.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=3407981;
 //BA.debugLineNum = 3407981;BA.debugLine="lblSale.TextSize = 7";
_lblsale.setTextSize((float) (7));
RDebugUtils.currentLine=3407982;
 //BA.debugLineNum = 3407982;BA.debugLine="lblSale.Color = Colors.Transparent";
_lblsale.setColor(__c.Colors.Transparent);
RDebugUtils.currentLine=3407983;
 //BA.debugLineNum = 3407983;BA.debugLine="If Active1.Width > 800 Then";
if (_active1.getWidth()>800) { 
RDebugUtils.currentLine=3407984;
 //BA.debugLineNum = 3407984;BA.debugLine="If checkedCount > 2 Then";
if (_checkedcount>2) { 
RDebugUtils.currentLine=3407985;
 //BA.debugLineNum = 3407985;BA.debugLine="lblSale.TextSize = 5";
_lblsale.setTextSize((float) (5));
 };
 }else {
RDebugUtils.currentLine=3407988;
 //BA.debugLineNum = 3407988;BA.debugLine="If checkedCount =3 Then";
if (_checkedcount==3) { 
RDebugUtils.currentLine=3407989;
 //BA.debugLineNum = 3407989;BA.debugLine="lblSale.TextSize = 4";
_lblsale.setTextSize((float) (4));
 };
RDebugUtils.currentLine=3407991;
 //BA.debugLineNum = 3407991;BA.debugLine="If checkedCount =2 Then";
if (_checkedcount==2) { 
RDebugUtils.currentLine=3407992;
 //BA.debugLineNum = 3407992;BA.debugLine="lblSale.TextSize =3.8";
_lblsale.setTextSize((float) (3.8));
 };
 };
RDebugUtils.currentLine=3407996;
 //BA.debugLineNum = 3407996;BA.debugLine="Dim lblSaleLeft As Int = xBar + alignLeftCente";
_lblsaleleft = (int) (_xbar+_alignleftcenter);
RDebugUtils.currentLine=3407997;
 //BA.debugLineNum = 3407997;BA.debugLine="Dim lblSaleTop As Int = activityPanel.Height -";
_lblsaletop = (int) (_activitypanel.getHeight()-_barheight-__c.DipToCurrent((int) (15))+_aligntopcenter);
RDebugUtils.currentLine=3407999;
 //BA.debugLineNum = 3407999;BA.debugLine="barPanel1.AddView(lblSale, lblSaleLeft, lblSal";
_barpanel1.AddView((android.view.View)(_lblsale.getObject()),_lblsaleleft,_lblsaletop,_barwidth,__c.DipToCurrent((int) (15)));
RDebugUtils.currentLine=3408003;
 //BA.debugLineNum = 3408003;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=3408004;
 //BA.debugLineNum = 3408004;BA.debugLine="r.Initialize(xBar, activityPanel.Height - barH";
_r.Initialize(_xbar,(int) (_activitypanel.getHeight()-_barheight),(int) (_xbar+_barwidth),_activitypanel.getHeight());
RDebugUtils.currentLine=3408005;
 //BA.debugLineNum = 3408005;BA.debugLine="graphCanvas.DrawRect(r, Color(j), True, 2dip)";
_graphcanvas.DrawRect((android.graphics.Rect)(_r.getObject()),_color[_j],__c.True,(float) (__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=3408007;
 //BA.debugLineNum = 3408007;BA.debugLine="indexOffset = indexOffset + 1 ' Increase offse";
_indexoffset = (int) (_indexoffset+1);
 };
 }
};
RDebugUtils.currentLine=3408010;
 //BA.debugLineNum = 3408010;BA.debugLine="Dim lblCompany As Label";
_lblcompany = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3408011;
 //BA.debugLineNum = 3408011;BA.debugLine="lblCompany.Initialize(\"\")";
_lblcompany.Initialize(ba,"");
RDebugUtils.currentLine=3408012;
 //BA.debugLineNum = 3408012;BA.debugLine="lblCompany.Text = comName(i)";
_lblcompany.setText(BA.ObjectToCharSequence(__ref._comname /*String[]*/ [_i]));
RDebugUtils.currentLine=3408013;
 //BA.debugLineNum = 3408013;BA.debugLine="lblCompany.TextColor = Colors.Black";
_lblcompany.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=3408014;
 //BA.debugLineNum = 3408014;BA.debugLine="lblCompany.Gravity = Gravity.CENTER";
_lblcompany.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=3408015;
 //BA.debugLineNum = 3408015;BA.debugLine="lblCompany.Typeface = Typeface.MONOSPACE";
_lblcompany.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=3408016;
 //BA.debugLineNum = 3408016;BA.debugLine="lblCompany.TextSize = 10";
_lblcompany.setTextSize((float) (10));
RDebugUtils.currentLine=3408017;
 //BA.debugLineNum = 3408017;BA.debugLine="lblCompany.Color = Colors.Transparent";
_lblcompany.setColor(__c.Colors.Transparent);
RDebugUtils.currentLine=3408018;
 //BA.debugLineNum = 3408018;BA.debugLine="If Active1.Width <= 800 Then";
if (_active1.getWidth()<=800) { 
RDebugUtils.currentLine=3408019;
 //BA.debugLineNum = 3408019;BA.debugLine="lblCompany.TextSize = 7";
_lblcompany.setTextSize((float) (7));
RDebugUtils.currentLine=3408020;
 //BA.debugLineNum = 3408020;BA.debugLine="If checkedCount = 1 Then";
if (_checkedcount==1) { 
RDebugUtils.currentLine=3408021;
 //BA.debugLineNum = 3408021;BA.debugLine="lblCompany.TextSize = 8";
_lblcompany.setTextSize((float) (8));
 };
 };
RDebugUtils.currentLine=3408024;
 //BA.debugLineNum = 3408024;BA.debugLine="Dim totalBarWidth As Int = checkedCount * barWid";
_totalbarwidth = (int) (_checkedcount*_barwidth);
RDebugUtils.currentLine=3408025;
 //BA.debugLineNum = 3408025;BA.debugLine="Dim lblCompanyWidth As Int = totalBarWidth ' Set";
_lblcompanywidth = _totalbarwidth;
RDebugUtils.currentLine=3408026;
 //BA.debugLineNum = 3408026;BA.debugLine="Dim lblCompanyLeft As Int = xPos + (totalBarWidt";
_lblcompanyleft = (int) (_xpos+(_totalbarwidth/(double)2)-(_lblcompanywidth/(double)2)+_alignleftcenter);
RDebugUtils.currentLine=3408027;
 //BA.debugLineNum = 3408027;BA.debugLine="If checkedCount =1 Then";
if (_checkedcount==1) { 
RDebugUtils.currentLine=3408028;
 //BA.debugLineNum = 3408028;BA.debugLine="lblCompanyWidth = productGap";
_lblcompanywidth = _productgap;
RDebugUtils.currentLine=3408029;
 //BA.debugLineNum = 3408029;BA.debugLine="lblCompany.Gravity = Gravity.LEFT";
_lblcompany.setGravity(__c.Gravity.LEFT);
RDebugUtils.currentLine=3408030;
 //BA.debugLineNum = 3408030;BA.debugLine="lblCompanyWidth = productGap + barWidth";
_lblcompanywidth = (int) (_productgap+_barwidth);
 };
RDebugUtils.currentLine=3408033;
 //BA.debugLineNum = 3408033;BA.debugLine="Dim lblCompanyTop As Int = activityPanel.Height";
_lblcompanytop = (int) (_activitypanel.getHeight()+__c.DipToCurrent((int) (5))+_aligntopcenter);
RDebugUtils.currentLine=3408035;
 //BA.debugLineNum = 3408035;BA.debugLine="barPanel1.AddView(lblCompany, lblCompanyLeft, lb";
_barpanel1.AddView((android.view.View)(_lblcompany.getObject()),_lblcompanyleft,_lblcompanytop,_lblcompanywidth,__c.DipToCurrent((int) (15)));
 }
};
RDebugUtils.currentLine=3408038;
 //BA.debugLineNum = 3408038;BA.debugLine="bckBtn.Initialize(\"backBtn\")";
_bckbtn.Initialize(ba,"backBtn");
RDebugUtils.currentLine=3408039;
 //BA.debugLineNum = 3408039;BA.debugLine="bckBtn.Color = Colors.ARGB(50,0,0,0)";
_bckbtn.setColor(__c.Colors.ARGB((int) (50),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=3408040;
 //BA.debugLineNum = 3408040;BA.debugLine="bckBtn.Gravity =Gravity.FILL";
_bckbtn.setGravity(__c.Gravity.FILL);
RDebugUtils.currentLine=3408042;
 //BA.debugLineNum = 3408042;BA.debugLine="If Active1.Width > 800 Then";
if (_active1.getWidth()>800) { 
RDebugUtils.currentLine=3408043;
 //BA.debugLineNum = 3408043;BA.debugLine="btnLeft = (alignLeftCenter/2)";
_btnleft = (int) ((_alignleftcenter/(double)2));
 }else {
RDebugUtils.currentLine=3408045;
 //BA.debugLineNum = 3408045;BA.debugLine="btnLeft = (alignLeftCenter/2)-30dip";
_btnleft = (int) ((_alignleftcenter/(double)2)-__c.DipToCurrent((int) (30)));
 };
RDebugUtils.currentLine=3408047;
 //BA.debugLineNum = 3408047;BA.debugLine="barPanel1.AddView(bckBtn,btnLeft,(barPanel1.Heigh";
_barpanel1.AddView((android.view.View)(_bckbtn.getObject()),_btnleft,(int) ((_barpanel1.getHeight()/(double)2)-__c.DipToCurrent((int) (10))),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=3408049;
 //BA.debugLineNum = 3408049;BA.debugLine="nextBtn.Initialize(\"nextBtn\")";
_nextbtn.Initialize(ba,"nextBtn");
RDebugUtils.currentLine=3408050;
 //BA.debugLineNum = 3408050;BA.debugLine="nextBtn.Color = Colors.ARGB(50,0,0,0)";
_nextbtn.setColor(__c.Colors.ARGB((int) (50),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=3408051;
 //BA.debugLineNum = 3408051;BA.debugLine="barPanel1.AddView(nextBtn,activityPanel.Width+(al";
_barpanel1.AddView((android.view.View)(_nextbtn.getObject()),(int) (_activitypanel.getWidth()+(_alignleftcenter)+__c.DipToCurrent((int) (15))),(int) ((_barpanel1.getHeight()/(double)2)-__c.DipToCurrent((int) (5))),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=3408052;
 //BA.debugLineNum = 3408052;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithlabel(b4a.example.checkbargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithlabel", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithlabel", new Object[] {_number}));}
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub FormatNumberWithLabel(number As Int) As String";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="Return Floor(number / 1000000) & \"M\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000000))+"M";
 }else 
{RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="Return Floor(number / 1000) & \"k\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000))+"k";
 }else {
RDebugUtils.currentLine=3604486;
 //BA.debugLineNum = 3604486;BA.debugLine="Return Floor(number)";
if (true) return BA.NumberToString(__c.Floor(_number));
 }}
;
RDebugUtils.currentLine=3604488;
 //BA.debugLineNum = 3604488;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithsuffix(b4a.example.checkbargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithsuffix", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithsuffix", new Object[] {_number}));}
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
if (true) return __c.NumberFormat(_number/(double)1000000,(int) (1),(int) (1))+"M";
 }else 
{RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=3538948;
 //BA.debugLineNum = 3538948;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
if (true) return __c.NumberFormat(_number/(double)1000,(int) (1),(int) (1))+"k";
 }else {
RDebugUtils.currentLine=3538950;
 //BA.debugLineNum = 3538950;BA.debugLine="Return NumberFormat(number, 1, 0)";
if (true) return __c.NumberFormat(_number,(int) (1),(int) (0));
 }}
;
RDebugUtils.currentLine=3538952;
 //BA.debugLineNum = 3538952;BA.debugLine="End Sub";
return "";
}
public int  _drawwrappedtextrotated(b4a.example.checkbargraph __ref,anywheresoftware.b4a.objects.drawable.CanvasWrapper _canvas,String _text,int _x,int _y,int _maxwidth,float _fontsize,int _color,String _alignment,float _angle) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "drawwrappedtextrotated", false))
	 {return ((Integer) Debug.delegate(ba, "drawwrappedtextrotated", new Object[] {_canvas,_text,_x,_y,_maxwidth,_fontsize,_color,_alignment,_angle}));}
String[] _words = null;
String _line = "";
int _lineheight = 0;
int _originaly = 0;
String _word = "";
String _testline = "";
int _textwidth = 0;
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub DrawWrappedTextRotated(canvas As Canvas, text";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="Dim words() As String = Regex.Split(\" \", text)";
_words = __c.Regex.Split(" ",_text);
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="Dim line As String = \"\"";
_line = "";
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="Dim lineHeight As Int = 20dip ' Space between lin";
_lineheight = __c.DipToCurrent((int) (20));
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="Dim originalY As Int = y ' Store original Y posit";
_originaly = _y;
RDebugUtils.currentLine=3473414;
 //BA.debugLineNum = 3473414;BA.debugLine="For Each word As String In words";
{
final String[] group5 = _words;
final int groupLen5 = group5.length
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_word = group5[index5];
RDebugUtils.currentLine=3473415;
 //BA.debugLineNum = 3473415;BA.debugLine="Dim testLine As String = line & word & \" \"";
_testline = _line+_word+" ";
RDebugUtils.currentLine=3473416;
 //BA.debugLineNum = 3473416;BA.debugLine="Dim textWidth As Int = canvas.MeasureStringWidth";
_textwidth = (int) (_canvas.MeasureStringWidth(_testline,__c.Typeface.MONOSPACE,_fontsize));
RDebugUtils.currentLine=3473418;
 //BA.debugLineNum = 3473418;BA.debugLine="If textWidth > maxWidth And line <> \"\" Then";
if (_textwidth>_maxwidth && (_line).equals("") == false) { 
RDebugUtils.currentLine=3473420;
 //BA.debugLineNum = 3473420;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEF";
_canvas.DrawTextRotated(ba,_line,(float) (_x),(float) (_y),__c.Typeface.DEFAULT_BOLD,_fontsize,_color,BA.getEnumFromString(android.graphics.Paint.Align.class,_alignment),_angle);
RDebugUtils.currentLine=3473421;
 //BA.debugLineNum = 3473421;BA.debugLine="y = y + lineHeight ' Move to next line";
_y = (int) (_y+_lineheight);
RDebugUtils.currentLine=3473422;
 //BA.debugLineNum = 3473422;BA.debugLine="line = word & \" \" ' Start new line";
_line = _word+" ";
 }else {
RDebugUtils.currentLine=3473424;
 //BA.debugLineNum = 3473424;BA.debugLine="line = testLine ' Add word to current line";
_line = _testline;
 };
 }
};
RDebugUtils.currentLine=3473429;
 //BA.debugLineNum = 3473429;BA.debugLine="If line <> \"\" Then";
if ((_line).equals("") == false) { 
RDebugUtils.currentLine=3473430;
 //BA.debugLineNum = 3473430;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEFA";
_canvas.DrawTextRotated(ba,_line,(float) (_x),(float) (_y),__c.Typeface.DEFAULT_BOLD,_fontsize,_color,BA.getEnumFromString(android.graphics.Paint.Align.class,_alignment),_angle);
RDebugUtils.currentLine=3473431;
 //BA.debugLineNum = 3473431;BA.debugLine="y = y + lineHeight ' Move final Y position";
_y = (int) (_y+_lineheight);
 };
RDebugUtils.currentLine=3473435;
 //BA.debugLineNum = 3473435;BA.debugLine="Return y - originalY";
if (true) return (int) (_y-_originaly);
RDebugUtils.currentLine=3473436;
 //BA.debugLineNum = 3473436;BA.debugLine="End Sub";
return 0;
}
public String  _initialize(b4a.example.checkbargraph __ref,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _active1,anywheresoftware.b4a.objects.PanelWrapper _panel,anywheresoftware.b4a.objects.ButtonWrapper _nextbtn,anywheresoftware.b4a.objects.ButtonWrapper _bckbtn,int[] _sales_1,int[] _sales_2,int[] _sales_3,String[] _comname1,int _maxsale1,String[] _legend) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_active1,_panel,_nextbtn,_bckbtn,_sales_1,_sales_2,_sales_3,_comname1,_maxsale1,_legend}));}
int _legendcount = 0;
anywheresoftware.b4a.objects.PanelWrapper _legendpanel = null;
int[] _color = null;
int _legendwidth = 0;
int _i = 0;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk = null;
anywheresoftware.b4a.objects.PanelWrapper _barpanel1 = null;
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Public Sub Initialize(Active1 As Activity, Panel A";
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="Active = Active1";
__ref._active /*anywheresoftware.b4a.objects.ActivityWrapper*/  = _active1;
RDebugUtils.currentLine=3211267;
 //BA.debugLineNum = 3211267;BA.debugLine="nxtBtn = nextBtn";
__ref._nxtbtn /*anywheresoftware.b4a.objects.ButtonWrapper*/  = _nextbtn;
RDebugUtils.currentLine=3211268;
 //BA.debugLineNum = 3211268;BA.debugLine="backBtn = bckBtn";
__ref._backbtn /*anywheresoftware.b4a.objects.ButtonWrapper*/  = _bckbtn;
RDebugUtils.currentLine=3211269;
 //BA.debugLineNum = 3211269;BA.debugLine="sales = sales_1";
__ref._sales /*int[]*/  = _sales_1;
RDebugUtils.currentLine=3211270;
 //BA.debugLineNum = 3211270;BA.debugLine="sales1 = sales_2";
__ref._sales1 /*int[]*/  = _sales_2;
RDebugUtils.currentLine=3211271;
 //BA.debugLineNum = 3211271;BA.debugLine="sales2 = sales_3";
__ref._sales2 /*int[]*/  = _sales_3;
RDebugUtils.currentLine=3211272;
 //BA.debugLineNum = 3211272;BA.debugLine="comName = comName1";
__ref._comname /*String[]*/  = _comname1;
RDebugUtils.currentLine=3211273;
 //BA.debugLineNum = 3211273;BA.debugLine="maxSale = maxSale1";
__ref._maxsale /*int*/  = _maxsale1;
RDebugUtils.currentLine=3211274;
 //BA.debugLineNum = 3211274;BA.debugLine="Panel.Initialize(\"\")";
_panel.Initialize(ba,"");
RDebugUtils.currentLine=3211275;
 //BA.debugLineNum = 3211275;BA.debugLine="nextBtn.Initialize(\"nxtBtn\")";
_nextbtn.Initialize(ba,"nxtBtn");
RDebugUtils.currentLine=3211276;
 //BA.debugLineNum = 3211276;BA.debugLine="bckBtn.Initialize(\"bckBtn\")";
_bckbtn.Initialize(ba,"bckBtn");
RDebugUtils.currentLine=3211279;
 //BA.debugLineNum = 3211279;BA.debugLine="Dim legendCount As Int = legend.Length";
_legendcount = _legend.length;
RDebugUtils.currentLine=3211282;
 //BA.debugLineNum = 3211282;BA.debugLine="checkBoxes = Array As CheckBox()";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/  = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]{};
RDebugUtils.currentLine=3211283;
 //BA.debugLineNum = 3211283;BA.debugLine="checkedSales = Array As Boolean()";
__ref._checkedsales /*boolean[]*/  = new boolean[]{};
RDebugUtils.currentLine=3211285;
 //BA.debugLineNum = 3211285;BA.debugLine="Dim checkBoxes(legendCount) As CheckBox   ' Resiz";
_checkboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[_legendcount];
{
int d0 = _checkboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_checkboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=3211286;
 //BA.debugLineNum = 3211286;BA.debugLine="Dim checkedSales(legendCount) As Boolean";
_checkedsales = new boolean[_legendcount];
;
RDebugUtils.currentLine=3211288;
 //BA.debugLineNum = 3211288;BA.debugLine="Dim legendPanel As Panel";
_legendpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3211289;
 //BA.debugLineNum = 3211289;BA.debugLine="legendPanel.Initialize(\"\")";
_legendpanel.Initialize(ba,"");
RDebugUtils.currentLine=3211290;
 //BA.debugLineNum = 3211290;BA.debugLine="legendPanel.Width = Active.Width";
_legendpanel.setWidth(__ref._active /*anywheresoftware.b4a.objects.ActivityWrapper*/ .getWidth());
RDebugUtils.currentLine=3211291;
 //BA.debugLineNum = 3211291;BA.debugLine="legendPanel.Height = 50dip";
_legendpanel.setHeight(__c.DipToCurrent((int) (50)));
RDebugUtils.currentLine=3211292;
 //BA.debugLineNum = 3211292;BA.debugLine="Panel.AddView(legendPanel, (Panel.Width / 3.5), 0";
_panel.AddView((android.view.View)(_legendpanel.getObject()),(int) ((_panel.getWidth()/(double)3.5)),(int) (0),(int) (_panel.getWidth()/(double)1.5),__c.DipToCurrent((int) (50)));
RDebugUtils.currentLine=3211294;
 //BA.debugLineNum = 3211294;BA.debugLine="Dim Color() As Int = Array As Int(Colors.Red, Col";
_color = new int[]{__c.Colors.Red,__c.Colors.Green,__c.Colors.Blue};
RDebugUtils.currentLine=3211295;
 //BA.debugLineNum = 3211295;BA.debugLine="Dim legendWidth As Int = legendPanel.Width / lege";
_legendwidth = (int) (_legendpanel.getWidth()/(double)_legend.length);
RDebugUtils.currentLine=3211297;
 //BA.debugLineNum = 3211297;BA.debugLine="For i = 0 To legendCount - 1";
{
final int step24 = 1;
final int limit24 = (int) (_legendcount-1);
_i = (int) (0) ;
for (;_i <= limit24 ;_i = _i + step24 ) {
RDebugUtils.currentLine=3211298;
 //BA.debugLineNum = 3211298;BA.debugLine="Dim chk As CheckBox";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=3211299;
 //BA.debugLineNum = 3211299;BA.debugLine="chk.Initialize(\"chkChange\") ' Ensure correct eve";
_chk.Initialize(ba,"chkChange");
RDebugUtils.currentLine=3211300;
 //BA.debugLineNum = 3211300;BA.debugLine="chk.Text = legend(i)";
_chk.setText(BA.ObjectToCharSequence(_legend[_i]));
RDebugUtils.currentLine=3211301;
 //BA.debugLineNum = 3211301;BA.debugLine="chk.TextSize = 10";
_chk.setTextSize((float) (10));
RDebugUtils.currentLine=3211302;
 //BA.debugLineNum = 3211302;BA.debugLine="chk.Typeface = Typeface.MONOSPACE";
_chk.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=3211303;
 //BA.debugLineNum = 3211303;BA.debugLine="chk.TextColor = Color(i)";
_chk.setTextColor(_color[_i]);
RDebugUtils.currentLine=3211304;
 //BA.debugLineNum = 3211304;BA.debugLine="chk.Tag = i";
_chk.setTag((Object)(_i));
RDebugUtils.currentLine=3211305;
 //BA.debugLineNum = 3211305;BA.debugLine="chk.Checked = True ' Initially checked";
_chk.setChecked(__c.True);
RDebugUtils.currentLine=3211307;
 //BA.debugLineNum = 3211307;BA.debugLine="legendPanel.AddView(chk, (legendWidth * i) + 10d";
_legendpanel.AddView((android.view.View)(_chk.getObject()),(int) ((_legendwidth*_i)+__c.DipToCurrent((int) (10))),__c.DipToCurrent((int) (5)),(int) (_legendwidth-__c.DipToCurrent((int) (20))),__c.DipToCurrent((int) (40)));
RDebugUtils.currentLine=3211309;
 //BA.debugLineNum = 3211309;BA.debugLine="checkBoxes(i) = chk ' Store reference in global";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/ [_i] = _chk;
RDebugUtils.currentLine=3211310;
 //BA.debugLineNum = 3211310;BA.debugLine="checkedSales(i) = True";
__ref._checkedsales /*boolean[]*/ [_i] = __c.True;
 }
};
RDebugUtils.currentLine=3211313;
 //BA.debugLineNum = 3211313;BA.debugLine="Dim barPanel1 As Panel";
_barpanel1 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3211314;
 //BA.debugLineNum = 3211314;BA.debugLine="barPanel1.Initialize(\"\")";
_barpanel1.Initialize(ba,"");
RDebugUtils.currentLine=3211315;
 //BA.debugLineNum = 3211315;BA.debugLine="Panel.AddView(barPanel1, 0, legendPanel.Height, P";
_panel.AddView((android.view.View)(_barpanel1.getObject()),(int) (0),_legendpanel.getHeight(),_panel.getWidth(),__c.DipToCurrent((int) (350)));
RDebugUtils.currentLine=3211316;
 //BA.debugLineNum = 3211316;BA.debugLine="barPanel = barPanel1";
__ref._barpanel /*anywheresoftware.b4a.objects.PanelWrapper*/  = _barpanel1;
RDebugUtils.currentLine=3211318;
 //BA.debugLineNum = 3211318;BA.debugLine="DrawGraph";
__ref._drawgraph /*String*/ (null);
RDebugUtils.currentLine=3211319;
 //BA.debugLineNum = 3211319;BA.debugLine="End Sub";
return "";
}
}