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
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub chkChange_CheckedChange(Checked As Boolean)";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="If Sender Is CheckBox Then";
if (__c.Sender(ba) instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="Dim chk As CheckBox = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper(), (android.widget.CheckBox)(__c.Sender(ba)));
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="Dim index As Int = chk.Tag";
_index = (int)(BA.ObjectToNumber(_chk.getTag()));
RDebugUtils.currentLine=3080197;
 //BA.debugLineNum = 3080197;BA.debugLine="Dim checkedCount As Int = 0";
_checkedcount = (int) (0);
RDebugUtils.currentLine=3080198;
 //BA.debugLineNum = 3080198;BA.debugLine="For i = 0 To checkedSales.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (__ref._checkedsales /*boolean[]*/ .length-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=3080199;
 //BA.debugLineNum = 3080199;BA.debugLine="If checkedSales(i) = True Then checkedCount = c";
if (__ref._checkedsales /*boolean[]*/ [_i]==__c.True) { 
_checkedcount = (int) (_checkedcount+1);};
 }
};
RDebugUtils.currentLine=3080202;
 //BA.debugLineNum = 3080202;BA.debugLine="If Checked = False And checkedCount = 1 Then";
if (_checked==__c.False && _checkedcount==1) { 
RDebugUtils.currentLine=3080203;
 //BA.debugLineNum = 3080203;BA.debugLine="chk.Checked = True";
_chk.setChecked(__c.True);
RDebugUtils.currentLine=3080204;
 //BA.debugLineNum = 3080204;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=3080207;
 //BA.debugLineNum = 3080207;BA.debugLine="checkedSales(index) = Checked";
__ref._checkedsales /*boolean[]*/ [_index] = _checked;
RDebugUtils.currentLine=3080208;
 //BA.debugLineNum = 3080208;BA.debugLine="DrawGraph ' Call DrawGraph without parameters";
__ref._drawgraph /*String*/ (null);
 }else {
RDebugUtils.currentLine=3080210;
 //BA.debugLineNum = 3080210;BA.debugLine="Log(\"Error: Sender is not a CheckBox\")";
__c.LogImpl("53080210","Error: Sender is not a CheckBox",0);
 };
RDebugUtils.currentLine=3080212;
 //BA.debugLineNum = 3080212;BA.debugLine="End Sub";
return "";
}
public String  _drawgraph(b4a.example.checkbargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "drawgraph", false))
	 {return ((String) Debug.delegate(ba, "drawgraph", null));}
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub DrawGraph()";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="DrawGraph1(Active, barPanel, nxtBtn, backBtn, sal";
__ref._drawgraph1 /*String*/ (null,__ref._active /*anywheresoftware.b4a.objects.ActivityWrapper*/ ,__ref._barpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ ,__ref._nxtbtn /*anywheresoftware.b4a.objects.ButtonWrapper*/ ,__ref._backbtn /*anywheresoftware.b4a.objects.ButtonWrapper*/ ,__ref._sales /*int[]*/ ,__ref._sales1 /*int[]*/ ,__ref._sales2 /*int[]*/ ,__ref._comname /*String[]*/ ,__ref._maxsale /*int*/ );
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.checkbargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="Private checkBoxes() As CheckBox";
_checkboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[(int) (0)];
{
int d0 = _checkboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_checkboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="Private checkedSales() As Boolean";
_checkedsales = new boolean[(int) (0)];
;
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="Private Active As Activity";
_active = new anywheresoftware.b4a.objects.ActivityWrapper();
RDebugUtils.currentLine=2883590;
 //BA.debugLineNum = 2883590;BA.debugLine="Private barPanel As Panel";
_barpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2883591;
 //BA.debugLineNum = 2883591;BA.debugLine="Private nxtBtn As Button";
_nxtbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=2883592;
 //BA.debugLineNum = 2883592;BA.debugLine="Private backBtn As Button";
_backbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=2883593;
 //BA.debugLineNum = 2883593;BA.debugLine="Private sales() As Int";
_sales = new int[(int) (0)];
;
RDebugUtils.currentLine=2883594;
 //BA.debugLineNum = 2883594;BA.debugLine="Private sales1() As Int";
_sales1 = new int[(int) (0)];
;
RDebugUtils.currentLine=2883595;
 //BA.debugLineNum = 2883595;BA.debugLine="Private sales2() As Int";
_sales2 = new int[(int) (0)];
;
RDebugUtils.currentLine=2883596;
 //BA.debugLineNum = 2883596;BA.debugLine="Private comName() As String";
_comname = new String[(int) (0)];
java.util.Arrays.fill(_comname,"");
RDebugUtils.currentLine=2883597;
 //BA.debugLineNum = 2883597;BA.debugLine="Private maxSale As Int";
_maxsale = 0;
RDebugUtils.currentLine=2883598;
 //BA.debugLineNum = 2883598;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Public Sub DrawGraph1(Active1 As Activity,barPanel";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="barPanel1.Initialize(\"\")";
_barpanel1.Initialize(ba,"");
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="barPanel1.RemoveAllViews ' Clear previous drawing";
_barpanel1.RemoveAllViews();
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="Dim Color() As Int = Array As Int(Colors.Red, Col";
_color = new int[]{__c.Colors.Red,__c.Colors.Green,__c.Colors.Blue};
RDebugUtils.currentLine=3145733;
 //BA.debugLineNum = 3145733;BA.debugLine="Dim activityPanel As Panel";
_activitypanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3145734;
 //BA.debugLineNum = 3145734;BA.debugLine="activityPanel.Initialize(\"\")";
_activitypanel.Initialize(ba,"");
RDebugUtils.currentLine=3145735;
 //BA.debugLineNum = 3145735;BA.debugLine="activityPanel.Width = 75%x";
_activitypanel.setWidth(__c.PerXToCurrent((float) (75),ba));
RDebugUtils.currentLine=3145736;
 //BA.debugLineNum = 3145736;BA.debugLine="If Active1.Width >800 Then";
if (_active1.getWidth()>800) { 
RDebugUtils.currentLine=3145737;
 //BA.debugLineNum = 3145737;BA.debugLine="activityPanel.Width = 70%x";
_activitypanel.setWidth(__c.PerXToCurrent((float) (70),ba));
 };
RDebugUtils.currentLine=3145739;
 //BA.debugLineNum = 3145739;BA.debugLine="activityPanel.Height = 250dip";
_activitypanel.setHeight(__c.DipToCurrent((int) (250)));
RDebugUtils.currentLine=3145740;
 //BA.debugLineNum = 3145740;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211, 2";
_activitypanel.setColor(__c.Colors.ARGB((int) (70),(int) (211),(int) (211),(int) (211)));
RDebugUtils.currentLine=3145742;
 //BA.debugLineNum = 3145742;BA.debugLine="Dim alignLeftCenter As Int = 0 ' Ensure left alig";
_alignleftcenter = (int) (0);
RDebugUtils.currentLine=3145743;
 //BA.debugLineNum = 3145743;BA.debugLine="If checkedSales.Length > 1 Then";
if (__ref._checkedsales /*boolean[]*/ .length>1) { 
RDebugUtils.currentLine=3145744;
 //BA.debugLineNum = 3145744;BA.debugLine="alignLeftCenter = (barPanel1.Width - activityPan";
_alignleftcenter = (int) ((_barpanel1.getWidth()-_activitypanel.getWidth())/(double)2);
 };
RDebugUtils.currentLine=3145747;
 //BA.debugLineNum = 3145747;BA.debugLine="Dim alignTopCenter As Int = (barPanel1.Height - a";
_aligntopcenter = (int) ((_barpanel1.getHeight()-_activitypanel.getHeight())/(double)2);
RDebugUtils.currentLine=3145748;
 //BA.debugLineNum = 3145748;BA.debugLine="Dim btnLeft As Int = 0";
_btnleft = (int) (0);
RDebugUtils.currentLine=3145750;
 //BA.debugLineNum = 3145750;BA.debugLine="Dim titleLabel As Label";
_titlelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3145751;
 //BA.debugLineNum = 3145751;BA.debugLine="titleLabel.Initialize(\"\")";
_titlelabel.Initialize(ba,"");
RDebugUtils.currentLine=3145752;
 //BA.debugLineNum = 3145752;BA.debugLine="titleLabel.Text=\"Total Sales For Each Company\"";
_titlelabel.setText(BA.ObjectToCharSequence("Total Sales For Each Company"));
RDebugUtils.currentLine=3145753;
 //BA.debugLineNum = 3145753;BA.debugLine="titleLabel.Gravity = Gravity.CENTER";
_titlelabel.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=3145754;
 //BA.debugLineNum = 3145754;BA.debugLine="titleLabel.Typeface = Typeface.MONOSPACE";
_titlelabel.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=3145755;
 //BA.debugLineNum = 3145755;BA.debugLine="titleLabel.TextSize = 20";
_titlelabel.setTextSize((float) (20));
RDebugUtils.currentLine=3145756;
 //BA.debugLineNum = 3145756;BA.debugLine="titleLabel.TextColor = Colors.Black";
_titlelabel.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=3145757;
 //BA.debugLineNum = 3145757;BA.debugLine="barPanel1.AddView(titleLabel,0,alignTopCenter - 4";
_barpanel1.AddView((android.view.View)(_titlelabel.getObject()),(int) (0),(int) (_aligntopcenter-__c.DipToCurrent((int) (40))),_barpanel1.getWidth(),__c.DipToCurrent((int) (50)));
RDebugUtils.currentLine=3145758;
 //BA.debugLineNum = 3145758;BA.debugLine="barPanel1.AddView(activityPanel, alignLeftCenter,";
_barpanel1.AddView((android.view.View)(_activitypanel.getObject()),_alignleftcenter,_aligntopcenter,_activitypanel.getWidth(),_activitypanel.getHeight());
RDebugUtils.currentLine=3145760;
 //BA.debugLineNum = 3145760;BA.debugLine="Dim graphCanvas As Canvas";
_graphcanvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=3145761;
 //BA.debugLineNum = 3145761;BA.debugLine="graphCanvas.Initialize(activityPanel)";
_graphcanvas.Initialize((android.view.View)(_activitypanel.getObject()));
RDebugUtils.currentLine=3145763;
 //BA.debugLineNum = 3145763;BA.debugLine="maxSale1 = maxSale1 * 1.2";
_maxsale1 = (int) (_maxsale1*1.2);
RDebugUtils.currentLine=3145764;
 //BA.debugLineNum = 3145764;BA.debugLine="Dim totalProducts As Int = sales_1.Length";
_totalproducts = _sales_1.length;
RDebugUtils.currentLine=3145765;
 //BA.debugLineNum = 3145765;BA.debugLine="Dim barsPerProduct As Int = 3";
_barsperproduct = (int) (3);
RDebugUtils.currentLine=3145766;
 //BA.debugLineNum = 3145766;BA.debugLine="Dim gap As Int = 15dip";
_gap = __c.DipToCurrent((int) (15));
RDebugUtils.currentLine=3145767;
 //BA.debugLineNum = 3145767;BA.debugLine="Dim productGap As Int = 5dip";
_productgap = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=3145768;
 //BA.debugLineNum = 3145768;BA.debugLine="Dim padding As Int = 0 ' Remove left padding when";
_padding = (int) (0);
RDebugUtils.currentLine=3145771;
 //BA.debugLineNum = 3145771;BA.debugLine="Dim numLabels As Int = 10";
_numlabels = (int) (10);
RDebugUtils.currentLine=3145772;
 //BA.debugLineNum = 3145772;BA.debugLine="Dim labelStep As Int = maxSale1 / numLabels";
_labelstep = (int) (_maxsale1/(double)_numlabels);
RDebugUtils.currentLine=3145773;
 //BA.debugLineNum = 3145773;BA.debugLine="Dim labelHeightStep As Int = activityPanel.Height";
_labelheightstep = (int) (_activitypanel.getHeight()/(double)_numlabels);
RDebugUtils.currentLine=3145775;
 //BA.debugLineNum = 3145775;BA.debugLine="For i = 0 To numLabels";
{
final int step38 = 1;
final int limit38 = _numlabels;
_i = (int) (0) ;
for (;_i <= limit38 ;_i = _i + step38 ) {
RDebugUtils.currentLine=3145776;
 //BA.debugLineNum = 3145776;BA.debugLine="Dim lblY As Int = activityPanel.Height - (i * la";
_lbly = (int) (_activitypanel.getHeight()-(_i*_labelheightstep)+_aligntopcenter-__c.DipToCurrent((int) (10)));
RDebugUtils.currentLine=3145777;
 //BA.debugLineNum = 3145777;BA.debugLine="Dim lblValue As Int = i * labelStep";
_lblvalue = (int) (_i*_labelstep);
RDebugUtils.currentLine=3145779;
 //BA.debugLineNum = 3145779;BA.debugLine="Dim lblLeft As Label";
_lblleft = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3145780;
 //BA.debugLineNum = 3145780;BA.debugLine="lblLeft.Initialize(\"\")";
_lblleft.Initialize(ba,"");
RDebugUtils.currentLine=3145781;
 //BA.debugLineNum = 3145781;BA.debugLine="lblLeft.Text = FormatNumberWithLabel(lblValue)";
_lblleft.setText(BA.ObjectToCharSequence(__ref._formatnumberwithlabel /*String*/ (null,_lblvalue)));
RDebugUtils.currentLine=3145782;
 //BA.debugLineNum = 3145782;BA.debugLine="lblLeft.TextColor = Colors.Black";
_lblleft.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=3145783;
 //BA.debugLineNum = 3145783;BA.debugLine="lblLeft.Gravity = Gravity.RIGHT";
_lblleft.setGravity(__c.Gravity.RIGHT);
RDebugUtils.currentLine=3145784;
 //BA.debugLineNum = 3145784;BA.debugLine="lblLeft.Typeface = Typeface.MONOSPACE";
_lblleft.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=3145785;
 //BA.debugLineNum = 3145785;BA.debugLine="lblLeft.TextSize = 10";
_lblleft.setTextSize((float) (10));
RDebugUtils.currentLine=3145786;
 //BA.debugLineNum = 3145786;BA.debugLine="lblLeft.Color = Colors.Transparent";
_lblleft.setColor(__c.Colors.Transparent);
RDebugUtils.currentLine=3145788;
 //BA.debugLineNum = 3145788;BA.debugLine="barPanel1.AddView(lblLeft, alignLeftCenter - 45d";
_barpanel1.AddView((android.view.View)(_lblleft.getObject()),(int) (_alignleftcenter-__c.DipToCurrent((int) (45))),_lbly,__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (20)));
 }
};
RDebugUtils.currentLine=3145791;
 //BA.debugLineNum = 3145791;BA.debugLine="Dim checkedCount As Int = 0";
_checkedcount = (int) (0);
RDebugUtils.currentLine=3145792;
 //BA.debugLineNum = 3145792;BA.debugLine="For i = 0 To checkedSales.Length - 1";
{
final int step52 = 1;
final int limit52 = (int) (__ref._checkedsales /*boolean[]*/ .length-1);
_i = (int) (0) ;
for (;_i <= limit52 ;_i = _i + step52 ) {
RDebugUtils.currentLine=3145793;
 //BA.debugLineNum = 3145793;BA.debugLine="If checkedSales(i) Then checkedCount = checkedCo";
if (__ref._checkedsales /*boolean[]*/ [_i]) { 
_checkedcount = (int) (_checkedcount+1);};
 }
};
RDebugUtils.currentLine=3145796;
 //BA.debugLineNum = 3145796;BA.debugLine="Dim availableWidth As Int = activityPanel.Width -";
_availablewidth = (int) (_activitypanel.getWidth()-((_totalproducts-1)*_productgap));
RDebugUtils.currentLine=3145797;
 //BA.debugLineNum = 3145797;BA.debugLine="Dim barWidth As Int = availableWidth / (totalProd";
_barwidth = (int) (_availablewidth/(double)(_totalproducts*_checkedcount));
RDebugUtils.currentLine=3145799;
 //BA.debugLineNum = 3145799;BA.debugLine="If sales_1.Length <= 4 Then";
if (_sales_1.length<=4) { 
RDebugUtils.currentLine=3145800;
 //BA.debugLineNum = 3145800;BA.debugLine="barWidth = 30dip";
_barwidth = __c.DipToCurrent((int) (30));
 };
RDebugUtils.currentLine=3145802;
 //BA.debugLineNum = 3145802;BA.debugLine="If Active1.Width > 800 Then";
if (_active1.getWidth()>800) { 
RDebugUtils.currentLine=3145803;
 //BA.debugLineNum = 3145803;BA.debugLine="If checkedCount =1 Then";
if (_checkedcount==1) { 
RDebugUtils.currentLine=3145804;
 //BA.debugLineNum = 3145804;BA.debugLine="barWidth = 30dip";
_barwidth = __c.DipToCurrent((int) (30));
RDebugUtils.currentLine=3145805;
 //BA.debugLineNum = 3145805;BA.debugLine="productGap = 45.5dip";
_productgap = __c.DipToCurrent((int) (45.5));
 };
 }else {
RDebugUtils.currentLine=3145808;
 //BA.debugLineNum = 3145808;BA.debugLine="If checkedCount =1 Then";
if (_checkedcount==1) { 
RDebugUtils.currentLine=3145809;
 //BA.debugLineNum = 3145809;BA.debugLine="barWidth = 30dip";
_barwidth = __c.DipToCurrent((int) (30));
RDebugUtils.currentLine=3145810;
 //BA.debugLineNum = 3145810;BA.debugLine="productGap = 18dip";
_productgap = __c.DipToCurrent((int) (18));
 };
 };
RDebugUtils.currentLine=3145815;
 //BA.debugLineNum = 3145815;BA.debugLine="Dim xStart As Int = 5dip ' Start from left when o";
_xstart = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=3145818;
 //BA.debugLineNum = 3145818;BA.debugLine="For i = 0 To totalProducts - 1";
{
final int step72 = 1;
final int limit72 = (int) (_totalproducts-1);
_i = (int) (0) ;
for (;_i <= limit72 ;_i = _i + step72 ) {
RDebugUtils.currentLine=3145819;
 //BA.debugLineNum = 3145819;BA.debugLine="Dim xPos As Int = xStart + (i * (checkedCount *";
_xpos = (int) (_xstart+(_i*(_checkedcount*_barwidth+_productgap)));
RDebugUtils.currentLine=3145820;
 //BA.debugLineNum = 3145820;BA.debugLine="Dim saleValues() As Int = Array As Int(sales_1(i";
_salevalues = new int[]{_sales_1[_i],_sales_2[_i],_sales_3[_i]};
RDebugUtils.currentLine=3145822;
 //BA.debugLineNum = 3145822;BA.debugLine="Dim indexOffset As Int = 0 ' Shift bars properly";
_indexoffset = (int) (0);
RDebugUtils.currentLine=3145824;
 //BA.debugLineNum = 3145824;BA.debugLine="For j = 0 To barsPerProduct - 1";
{
final int step76 = 1;
final int limit76 = (int) (_barsperproduct-1);
_j = (int) (0) ;
for (;_j <= limit76 ;_j = _j + step76 ) {
RDebugUtils.currentLine=3145825;
 //BA.debugLineNum = 3145825;BA.debugLine="If j < checkedSales.Length And checkedSales(j)";
if (_j<__ref._checkedsales /*boolean[]*/ .length && __ref._checkedsales /*boolean[]*/ [_j]) { 
RDebugUtils.currentLine=3145826;
 //BA.debugLineNum = 3145826;BA.debugLine="Dim sale As Int = saleValues(j)";
_sale = _salevalues[_j];
RDebugUtils.currentLine=3145827;
 //BA.debugLineNum = 3145827;BA.debugLine="Dim barHeight As Int = (sale / maxSale1) * act";
_barheight = (int) ((_sale/(double)_maxsale1)*_activitypanel.getHeight());
RDebugUtils.currentLine=3145828;
 //BA.debugLineNum = 3145828;BA.debugLine="Dim xBar As Int = xPos + indexOffset * barWidt";
_xbar = (int) (_xpos+_indexoffset*_barwidth);
RDebugUtils.currentLine=3145831;
 //BA.debugLineNum = 3145831;BA.debugLine="Dim lblSale As Label";
_lblsale = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3145832;
 //BA.debugLineNum = 3145832;BA.debugLine="lblSale.Initialize(\"\")";
_lblsale.Initialize(ba,"");
RDebugUtils.currentLine=3145833;
 //BA.debugLineNum = 3145833;BA.debugLine="lblSale.Text = FormatNumberWithSuffix(sale) '";
_lblsale.setText(BA.ObjectToCharSequence(__ref._formatnumberwithsuffix /*String*/ (null,_sale)));
RDebugUtils.currentLine=3145834;
 //BA.debugLineNum = 3145834;BA.debugLine="lblSale.TextColor = Colors.Black";
_lblsale.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=3145835;
 //BA.debugLineNum = 3145835;BA.debugLine="lblSale.Gravity = Gravity.CENTER";
_lblsale.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=3145836;
 //BA.debugLineNum = 3145836;BA.debugLine="lblSale.Typeface = Typeface.MONOSPACE";
_lblsale.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=3145837;
 //BA.debugLineNum = 3145837;BA.debugLine="lblSale.TextSize = 7";
_lblsale.setTextSize((float) (7));
RDebugUtils.currentLine=3145838;
 //BA.debugLineNum = 3145838;BA.debugLine="lblSale.Color = Colors.Transparent";
_lblsale.setColor(__c.Colors.Transparent);
RDebugUtils.currentLine=3145839;
 //BA.debugLineNum = 3145839;BA.debugLine="If Active1.Width > 800 Then";
if (_active1.getWidth()>800) { 
RDebugUtils.currentLine=3145840;
 //BA.debugLineNum = 3145840;BA.debugLine="If checkedCount > 2 Then";
if (_checkedcount>2) { 
RDebugUtils.currentLine=3145841;
 //BA.debugLineNum = 3145841;BA.debugLine="lblSale.TextSize = 5";
_lblsale.setTextSize((float) (5));
 };
 }else {
RDebugUtils.currentLine=3145844;
 //BA.debugLineNum = 3145844;BA.debugLine="If checkedCount =3 Then";
if (_checkedcount==3) { 
RDebugUtils.currentLine=3145845;
 //BA.debugLineNum = 3145845;BA.debugLine="lblSale.TextSize = 4";
_lblsale.setTextSize((float) (4));
 };
RDebugUtils.currentLine=3145847;
 //BA.debugLineNum = 3145847;BA.debugLine="If checkedCount =2 Then";
if (_checkedcount==2) { 
RDebugUtils.currentLine=3145848;
 //BA.debugLineNum = 3145848;BA.debugLine="lblSale.TextSize =3.8";
_lblsale.setTextSize((float) (3.8));
 };
 };
RDebugUtils.currentLine=3145852;
 //BA.debugLineNum = 3145852;BA.debugLine="Dim lblSaleLeft As Int = xBar + alignLeftCente";
_lblsaleleft = (int) (_xbar+_alignleftcenter);
RDebugUtils.currentLine=3145853;
 //BA.debugLineNum = 3145853;BA.debugLine="Dim lblSaleTop As Int = activityPanel.Height -";
_lblsaletop = (int) (_activitypanel.getHeight()-_barheight-__c.DipToCurrent((int) (15))+_aligntopcenter);
RDebugUtils.currentLine=3145855;
 //BA.debugLineNum = 3145855;BA.debugLine="barPanel1.AddView(lblSale, lblSaleLeft, lblSal";
_barpanel1.AddView((android.view.View)(_lblsale.getObject()),_lblsaleleft,_lblsaletop,_barwidth,__c.DipToCurrent((int) (15)));
RDebugUtils.currentLine=3145859;
 //BA.debugLineNum = 3145859;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=3145860;
 //BA.debugLineNum = 3145860;BA.debugLine="r.Initialize(xBar, activityPanel.Height - barH";
_r.Initialize(_xbar,(int) (_activitypanel.getHeight()-_barheight),(int) (_xbar+_barwidth),_activitypanel.getHeight());
RDebugUtils.currentLine=3145861;
 //BA.debugLineNum = 3145861;BA.debugLine="graphCanvas.DrawRect(r, Color(j), True, 2dip)";
_graphcanvas.DrawRect((android.graphics.Rect)(_r.getObject()),_color[_j],__c.True,(float) (__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=3145863;
 //BA.debugLineNum = 3145863;BA.debugLine="indexOffset = indexOffset + 1 ' Increase offse";
_indexoffset = (int) (_indexoffset+1);
 };
 }
};
RDebugUtils.currentLine=3145866;
 //BA.debugLineNum = 3145866;BA.debugLine="Dim lblCompany As Label";
_lblcompany = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3145867;
 //BA.debugLineNum = 3145867;BA.debugLine="lblCompany.Initialize(\"\")";
_lblcompany.Initialize(ba,"");
RDebugUtils.currentLine=3145868;
 //BA.debugLineNum = 3145868;BA.debugLine="lblCompany.Text = comName(i)";
_lblcompany.setText(BA.ObjectToCharSequence(__ref._comname /*String[]*/ [_i]));
RDebugUtils.currentLine=3145869;
 //BA.debugLineNum = 3145869;BA.debugLine="lblCompany.TextColor = Colors.Black";
_lblcompany.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=3145870;
 //BA.debugLineNum = 3145870;BA.debugLine="lblCompany.Gravity = Gravity.CENTER";
_lblcompany.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=3145871;
 //BA.debugLineNum = 3145871;BA.debugLine="lblCompany.Typeface = Typeface.MONOSPACE";
_lblcompany.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=3145872;
 //BA.debugLineNum = 3145872;BA.debugLine="lblCompany.TextSize = 10";
_lblcompany.setTextSize((float) (10));
RDebugUtils.currentLine=3145873;
 //BA.debugLineNum = 3145873;BA.debugLine="lblCompany.Color = Colors.Transparent";
_lblcompany.setColor(__c.Colors.Transparent);
RDebugUtils.currentLine=3145874;
 //BA.debugLineNum = 3145874;BA.debugLine="If Active1.Width <= 800 Then";
if (_active1.getWidth()<=800) { 
RDebugUtils.currentLine=3145875;
 //BA.debugLineNum = 3145875;BA.debugLine="lblCompany.TextSize = 7";
_lblcompany.setTextSize((float) (7));
RDebugUtils.currentLine=3145876;
 //BA.debugLineNum = 3145876;BA.debugLine="If checkedCount = 1 Then";
if (_checkedcount==1) { 
RDebugUtils.currentLine=3145877;
 //BA.debugLineNum = 3145877;BA.debugLine="lblCompany.TextSize = 8";
_lblcompany.setTextSize((float) (8));
 };
 };
RDebugUtils.currentLine=3145880;
 //BA.debugLineNum = 3145880;BA.debugLine="Dim totalBarWidth As Int = checkedCount * barWid";
_totalbarwidth = (int) (_checkedcount*_barwidth);
RDebugUtils.currentLine=3145881;
 //BA.debugLineNum = 3145881;BA.debugLine="Dim lblCompanyWidth As Int = totalBarWidth ' Set";
_lblcompanywidth = _totalbarwidth;
RDebugUtils.currentLine=3145882;
 //BA.debugLineNum = 3145882;BA.debugLine="Dim lblCompanyLeft As Int = xPos + (totalBarWidt";
_lblcompanyleft = (int) (_xpos+(_totalbarwidth/(double)2)-(_lblcompanywidth/(double)2)+_alignleftcenter);
RDebugUtils.currentLine=3145883;
 //BA.debugLineNum = 3145883;BA.debugLine="If checkedCount =1 Then";
if (_checkedcount==1) { 
RDebugUtils.currentLine=3145884;
 //BA.debugLineNum = 3145884;BA.debugLine="lblCompanyWidth = productGap";
_lblcompanywidth = _productgap;
RDebugUtils.currentLine=3145885;
 //BA.debugLineNum = 3145885;BA.debugLine="lblCompany.Gravity = Gravity.LEFT";
_lblcompany.setGravity(__c.Gravity.LEFT);
RDebugUtils.currentLine=3145886;
 //BA.debugLineNum = 3145886;BA.debugLine="lblCompanyWidth = productGap + barWidth";
_lblcompanywidth = (int) (_productgap+_barwidth);
 };
RDebugUtils.currentLine=3145889;
 //BA.debugLineNum = 3145889;BA.debugLine="Dim lblCompanyTop As Int = activityPanel.Height";
_lblcompanytop = (int) (_activitypanel.getHeight()+__c.DipToCurrent((int) (5))+_aligntopcenter);
RDebugUtils.currentLine=3145891;
 //BA.debugLineNum = 3145891;BA.debugLine="barPanel1.AddView(lblCompany, lblCompanyLeft, lb";
_barpanel1.AddView((android.view.View)(_lblcompany.getObject()),_lblcompanyleft,_lblcompanytop,_lblcompanywidth,__c.DipToCurrent((int) (15)));
 }
};
RDebugUtils.currentLine=3145894;
 //BA.debugLineNum = 3145894;BA.debugLine="bckBtn.Initialize(\"backBtn\")";
_bckbtn.Initialize(ba,"backBtn");
RDebugUtils.currentLine=3145895;
 //BA.debugLineNum = 3145895;BA.debugLine="bckBtn.Color = Colors.ARGB(50,0,0,0)";
_bckbtn.setColor(__c.Colors.ARGB((int) (50),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=3145896;
 //BA.debugLineNum = 3145896;BA.debugLine="bckBtn.Gravity =Gravity.FILL";
_bckbtn.setGravity(__c.Gravity.FILL);
RDebugUtils.currentLine=3145898;
 //BA.debugLineNum = 3145898;BA.debugLine="If Active1.Width > 800 Then";
if (_active1.getWidth()>800) { 
RDebugUtils.currentLine=3145899;
 //BA.debugLineNum = 3145899;BA.debugLine="btnLeft = (alignLeftCenter/2)";
_btnleft = (int) ((_alignleftcenter/(double)2));
 }else {
RDebugUtils.currentLine=3145901;
 //BA.debugLineNum = 3145901;BA.debugLine="btnLeft = (alignLeftCenter/2)-30dip";
_btnleft = (int) ((_alignleftcenter/(double)2)-__c.DipToCurrent((int) (30)));
 };
RDebugUtils.currentLine=3145903;
 //BA.debugLineNum = 3145903;BA.debugLine="barPanel1.AddView(bckBtn,btnLeft,(barPanel1.Heigh";
_barpanel1.AddView((android.view.View)(_bckbtn.getObject()),_btnleft,(int) ((_barpanel1.getHeight()/(double)2)-__c.DipToCurrent((int) (10))),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=3145905;
 //BA.debugLineNum = 3145905;BA.debugLine="nextBtn.Initialize(\"nextBtn\")";
_nextbtn.Initialize(ba,"nextBtn");
RDebugUtils.currentLine=3145906;
 //BA.debugLineNum = 3145906;BA.debugLine="nextBtn.Color = Colors.ARGB(50,0,0,0)";
_nextbtn.setColor(__c.Colors.ARGB((int) (50),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=3145907;
 //BA.debugLineNum = 3145907;BA.debugLine="barPanel1.AddView(nextBtn,activityPanel.Width+(al";
_barpanel1.AddView((android.view.View)(_nextbtn.getObject()),(int) (_activitypanel.getWidth()+(_alignleftcenter)+__c.DipToCurrent((int) (15))),(int) ((_barpanel1.getHeight()/(double)2)-__c.DipToCurrent((int) (5))),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=3145908;
 //BA.debugLineNum = 3145908;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithlabel(b4a.example.checkbargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithlabel", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithlabel", new Object[] {_number}));}
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub FormatNumberWithLabel(number As Int) As String";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="Return Floor(number / 1000000) & \"M\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000000))+"M";
 }else 
{RDebugUtils.currentLine=3342339;
 //BA.debugLineNum = 3342339;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=3342340;
 //BA.debugLineNum = 3342340;BA.debugLine="Return Floor(number / 1000) & \"k\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000))+"k";
 }else {
RDebugUtils.currentLine=3342342;
 //BA.debugLineNum = 3342342;BA.debugLine="Return Floor(number)";
if (true) return BA.NumberToString(__c.Floor(_number));
 }}
;
RDebugUtils.currentLine=3342344;
 //BA.debugLineNum = 3342344;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithsuffix(b4a.example.checkbargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithsuffix", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithsuffix", new Object[] {_number}));}
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
if (true) return __c.NumberFormat(_number/(double)1000000,(int) (1),(int) (1))+"M";
 }else 
{RDebugUtils.currentLine=3276803;
 //BA.debugLineNum = 3276803;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=3276804;
 //BA.debugLineNum = 3276804;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
if (true) return __c.NumberFormat(_number/(double)1000,(int) (1),(int) (1))+"k";
 }else {
RDebugUtils.currentLine=3276806;
 //BA.debugLineNum = 3276806;BA.debugLine="Return NumberFormat(number, 1, 0)";
if (true) return __c.NumberFormat(_number,(int) (1),(int) (0));
 }}
;
RDebugUtils.currentLine=3276808;
 //BA.debugLineNum = 3276808;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub DrawWrappedTextRotated(canvas As Canvas, text";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="Dim words() As String = Regex.Split(\" \", text)";
_words = __c.Regex.Split(" ",_text);
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="Dim line As String = \"\"";
_line = "";
RDebugUtils.currentLine=3211267;
 //BA.debugLineNum = 3211267;BA.debugLine="Dim lineHeight As Int = 20dip ' Space between lin";
_lineheight = __c.DipToCurrent((int) (20));
RDebugUtils.currentLine=3211268;
 //BA.debugLineNum = 3211268;BA.debugLine="Dim originalY As Int = y ' Store original Y posit";
_originaly = _y;
RDebugUtils.currentLine=3211270;
 //BA.debugLineNum = 3211270;BA.debugLine="For Each word As String In words";
{
final String[] group5 = _words;
final int groupLen5 = group5.length
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_word = group5[index5];
RDebugUtils.currentLine=3211271;
 //BA.debugLineNum = 3211271;BA.debugLine="Dim testLine As String = line & word & \" \"";
_testline = _line+_word+" ";
RDebugUtils.currentLine=3211272;
 //BA.debugLineNum = 3211272;BA.debugLine="Dim textWidth As Int = canvas.MeasureStringWidth";
_textwidth = (int) (_canvas.MeasureStringWidth(_testline,__c.Typeface.MONOSPACE,_fontsize));
RDebugUtils.currentLine=3211274;
 //BA.debugLineNum = 3211274;BA.debugLine="If textWidth > maxWidth And line <> \"\" Then";
if (_textwidth>_maxwidth && (_line).equals("") == false) { 
RDebugUtils.currentLine=3211276;
 //BA.debugLineNum = 3211276;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEF";
_canvas.DrawTextRotated(ba,_line,(float) (_x),(float) (_y),__c.Typeface.DEFAULT_BOLD,_fontsize,_color,BA.getEnumFromString(android.graphics.Paint.Align.class,_alignment),_angle);
RDebugUtils.currentLine=3211277;
 //BA.debugLineNum = 3211277;BA.debugLine="y = y + lineHeight ' Move to next line";
_y = (int) (_y+_lineheight);
RDebugUtils.currentLine=3211278;
 //BA.debugLineNum = 3211278;BA.debugLine="line = word & \" \" ' Start new line";
_line = _word+" ";
 }else {
RDebugUtils.currentLine=3211280;
 //BA.debugLineNum = 3211280;BA.debugLine="line = testLine ' Add word to current line";
_line = _testline;
 };
 }
};
RDebugUtils.currentLine=3211285;
 //BA.debugLineNum = 3211285;BA.debugLine="If line <> \"\" Then";
if ((_line).equals("") == false) { 
RDebugUtils.currentLine=3211286;
 //BA.debugLineNum = 3211286;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEFA";
_canvas.DrawTextRotated(ba,_line,(float) (_x),(float) (_y),__c.Typeface.DEFAULT_BOLD,_fontsize,_color,BA.getEnumFromString(android.graphics.Paint.Align.class,_alignment),_angle);
RDebugUtils.currentLine=3211287;
 //BA.debugLineNum = 3211287;BA.debugLine="y = y + lineHeight ' Move final Y position";
_y = (int) (_y+_lineheight);
 };
RDebugUtils.currentLine=3211291;
 //BA.debugLineNum = 3211291;BA.debugLine="Return y - originalY";
if (true) return (int) (_y-_originaly);
RDebugUtils.currentLine=3211292;
 //BA.debugLineNum = 3211292;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Public Sub Initialize(Active1 As Activity, Panel A";
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="Active = Active1";
__ref._active /*anywheresoftware.b4a.objects.ActivityWrapper*/  = _active1;
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="nxtBtn = nextBtn";
__ref._nxtbtn /*anywheresoftware.b4a.objects.ButtonWrapper*/  = _nextbtn;
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="backBtn = bckBtn";
__ref._backbtn /*anywheresoftware.b4a.objects.ButtonWrapper*/  = _bckbtn;
RDebugUtils.currentLine=2949125;
 //BA.debugLineNum = 2949125;BA.debugLine="sales = sales_1";
__ref._sales /*int[]*/  = _sales_1;
RDebugUtils.currentLine=2949126;
 //BA.debugLineNum = 2949126;BA.debugLine="sales1 = sales_2";
__ref._sales1 /*int[]*/  = _sales_2;
RDebugUtils.currentLine=2949127;
 //BA.debugLineNum = 2949127;BA.debugLine="sales2 = sales_3";
__ref._sales2 /*int[]*/  = _sales_3;
RDebugUtils.currentLine=2949128;
 //BA.debugLineNum = 2949128;BA.debugLine="comName = comName1";
__ref._comname /*String[]*/  = _comname1;
RDebugUtils.currentLine=2949129;
 //BA.debugLineNum = 2949129;BA.debugLine="maxSale = maxSale1";
__ref._maxsale /*int*/  = _maxsale1;
RDebugUtils.currentLine=2949130;
 //BA.debugLineNum = 2949130;BA.debugLine="Panel.Initialize(\"\")";
_panel.Initialize(ba,"");
RDebugUtils.currentLine=2949131;
 //BA.debugLineNum = 2949131;BA.debugLine="nextBtn.Initialize(\"nxtBtn\")";
_nextbtn.Initialize(ba,"nxtBtn");
RDebugUtils.currentLine=2949132;
 //BA.debugLineNum = 2949132;BA.debugLine="bckBtn.Initialize(\"bckBtn\")";
_bckbtn.Initialize(ba,"bckBtn");
RDebugUtils.currentLine=2949135;
 //BA.debugLineNum = 2949135;BA.debugLine="Dim legendCount As Int = legend.Length";
_legendcount = _legend.length;
RDebugUtils.currentLine=2949138;
 //BA.debugLineNum = 2949138;BA.debugLine="checkBoxes = Array As CheckBox()";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/  = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]{};
RDebugUtils.currentLine=2949139;
 //BA.debugLineNum = 2949139;BA.debugLine="checkedSales = Array As Boolean()";
__ref._checkedsales /*boolean[]*/  = new boolean[]{};
RDebugUtils.currentLine=2949141;
 //BA.debugLineNum = 2949141;BA.debugLine="Dim checkBoxes(legendCount) As CheckBox   ' Resiz";
_checkboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[_legendcount];
{
int d0 = _checkboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_checkboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=2949142;
 //BA.debugLineNum = 2949142;BA.debugLine="Dim checkedSales(legendCount) As Boolean";
_checkedsales = new boolean[_legendcount];
;
RDebugUtils.currentLine=2949144;
 //BA.debugLineNum = 2949144;BA.debugLine="Dim legendPanel As Panel";
_legendpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2949145;
 //BA.debugLineNum = 2949145;BA.debugLine="legendPanel.Initialize(\"\")";
_legendpanel.Initialize(ba,"");
RDebugUtils.currentLine=2949146;
 //BA.debugLineNum = 2949146;BA.debugLine="legendPanel.Width = Active.Width";
_legendpanel.setWidth(__ref._active /*anywheresoftware.b4a.objects.ActivityWrapper*/ .getWidth());
RDebugUtils.currentLine=2949147;
 //BA.debugLineNum = 2949147;BA.debugLine="legendPanel.Height = 50dip";
_legendpanel.setHeight(__c.DipToCurrent((int) (50)));
RDebugUtils.currentLine=2949148;
 //BA.debugLineNum = 2949148;BA.debugLine="Panel.AddView(legendPanel, (Panel.Width / 3.5), 0";
_panel.AddView((android.view.View)(_legendpanel.getObject()),(int) ((_panel.getWidth()/(double)3.5)),(int) (0),(int) (_panel.getWidth()/(double)1.5),__c.DipToCurrent((int) (50)));
RDebugUtils.currentLine=2949150;
 //BA.debugLineNum = 2949150;BA.debugLine="Dim Color() As Int = Array As Int(Colors.Red, Col";
_color = new int[]{__c.Colors.Red,__c.Colors.Green,__c.Colors.Blue};
RDebugUtils.currentLine=2949151;
 //BA.debugLineNum = 2949151;BA.debugLine="Dim legendWidth As Int = legendPanel.Width / lege";
_legendwidth = (int) (_legendpanel.getWidth()/(double)_legend.length);
RDebugUtils.currentLine=2949153;
 //BA.debugLineNum = 2949153;BA.debugLine="For i = 0 To legendCount - 1";
{
final int step24 = 1;
final int limit24 = (int) (_legendcount-1);
_i = (int) (0) ;
for (;_i <= limit24 ;_i = _i + step24 ) {
RDebugUtils.currentLine=2949154;
 //BA.debugLineNum = 2949154;BA.debugLine="Dim chk As CheckBox";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=2949155;
 //BA.debugLineNum = 2949155;BA.debugLine="chk.Initialize(\"chkChange\") ' Ensure correct eve";
_chk.Initialize(ba,"chkChange");
RDebugUtils.currentLine=2949156;
 //BA.debugLineNum = 2949156;BA.debugLine="chk.Text = legend(i)";
_chk.setText(BA.ObjectToCharSequence(_legend[_i]));
RDebugUtils.currentLine=2949157;
 //BA.debugLineNum = 2949157;BA.debugLine="chk.TextSize = 10";
_chk.setTextSize((float) (10));
RDebugUtils.currentLine=2949158;
 //BA.debugLineNum = 2949158;BA.debugLine="chk.Typeface = Typeface.MONOSPACE";
_chk.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=2949159;
 //BA.debugLineNum = 2949159;BA.debugLine="chk.TextColor = Color(i)";
_chk.setTextColor(_color[_i]);
RDebugUtils.currentLine=2949160;
 //BA.debugLineNum = 2949160;BA.debugLine="chk.Tag = i";
_chk.setTag((Object)(_i));
RDebugUtils.currentLine=2949161;
 //BA.debugLineNum = 2949161;BA.debugLine="chk.Checked = True ' Initially checked";
_chk.setChecked(__c.True);
RDebugUtils.currentLine=2949163;
 //BA.debugLineNum = 2949163;BA.debugLine="legendPanel.AddView(chk, (legendWidth * i) + 10d";
_legendpanel.AddView((android.view.View)(_chk.getObject()),(int) ((_legendwidth*_i)+__c.DipToCurrent((int) (10))),__c.DipToCurrent((int) (5)),(int) (_legendwidth-__c.DipToCurrent((int) (20))),__c.DipToCurrent((int) (40)));
RDebugUtils.currentLine=2949165;
 //BA.debugLineNum = 2949165;BA.debugLine="checkBoxes(i) = chk ' Store reference in global";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/ [_i] = _chk;
RDebugUtils.currentLine=2949166;
 //BA.debugLineNum = 2949166;BA.debugLine="checkedSales(i) = True";
__ref._checkedsales /*boolean[]*/ [_i] = __c.True;
 }
};
RDebugUtils.currentLine=2949169;
 //BA.debugLineNum = 2949169;BA.debugLine="Dim barPanel1 As Panel";
_barpanel1 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2949170;
 //BA.debugLineNum = 2949170;BA.debugLine="barPanel1.Initialize(\"\")";
_barpanel1.Initialize(ba,"");
RDebugUtils.currentLine=2949171;
 //BA.debugLineNum = 2949171;BA.debugLine="Panel.AddView(barPanel1, 0, legendPanel.Height, P";
_panel.AddView((android.view.View)(_barpanel1.getObject()),(int) (0),_legendpanel.getHeight(),_panel.getWidth(),__c.DipToCurrent((int) (350)));
RDebugUtils.currentLine=2949172;
 //BA.debugLineNum = 2949172;BA.debugLine="barPanel = barPanel1";
__ref._barpanel /*anywheresoftware.b4a.objects.PanelWrapper*/  = _barpanel1;
RDebugUtils.currentLine=2949174;
 //BA.debugLineNum = 2949174;BA.debugLine="DrawGraph";
__ref._drawgraph /*String*/ (null);
RDebugUtils.currentLine=2949175;
 //BA.debugLineNum = 2949175;BA.debugLine="End Sub";
return "";
}
}