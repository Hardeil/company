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
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub chkChange_CheckedChange(Checked As Boolean)";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="If Sender Is CheckBox Then";
if (__c.Sender(ba) instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="Dim chk As CheckBox = Sender";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
_chk = (anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper(), (android.widget.CheckBox)(__c.Sender(ba)));
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="Dim index As Int = chk.Tag";
_index = (int)(BA.ObjectToNumber(_chk.getTag()));
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="Dim checkedCount As Int = 0";
_checkedcount = (int) (0);
RDebugUtils.currentLine=2883590;
 //BA.debugLineNum = 2883590;BA.debugLine="For i = 0 To checkedSales.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (__ref._checkedsales /*boolean[]*/ .length-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=2883591;
 //BA.debugLineNum = 2883591;BA.debugLine="If checkedSales(i) = True Then checkedCount = c";
if (__ref._checkedsales /*boolean[]*/ [_i]==__c.True) { 
_checkedcount = (int) (_checkedcount+1);};
 }
};
RDebugUtils.currentLine=2883594;
 //BA.debugLineNum = 2883594;BA.debugLine="If Checked = False And checkedCount = 1 Then";
if (_checked==__c.False && _checkedcount==1) { 
RDebugUtils.currentLine=2883595;
 //BA.debugLineNum = 2883595;BA.debugLine="chk.Checked = True";
_chk.setChecked(__c.True);
RDebugUtils.currentLine=2883596;
 //BA.debugLineNum = 2883596;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2883599;
 //BA.debugLineNum = 2883599;BA.debugLine="checkedSales(index) = Checked";
__ref._checkedsales /*boolean[]*/ [_index] = _checked;
RDebugUtils.currentLine=2883600;
 //BA.debugLineNum = 2883600;BA.debugLine="DrawGraph ' Call DrawGraph without parameters";
__ref._drawgraph /*String*/ (null);
 }else {
RDebugUtils.currentLine=2883602;
 //BA.debugLineNum = 2883602;BA.debugLine="Log(\"Error: Sender is not a CheckBox\")";
__c.LogImpl("82883602","Error: Sender is not a CheckBox",0);
 };
RDebugUtils.currentLine=2883604;
 //BA.debugLineNum = 2883604;BA.debugLine="End Sub";
return "";
}
public String  _drawgraph(b4a.example.checkbargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "drawgraph", false))
	 {return ((String) Debug.delegate(ba, "drawgraph", null));}
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub DrawGraph()";
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="DrawGraph1(Active, barPanel, nxtBtn, backBtn, sal";
__ref._drawgraph1 /*String*/ (null,__ref._active /*anywheresoftware.b4a.objects.ActivityWrapper*/ ,__ref._barpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ ,__ref._nxtbtn /*anywheresoftware.b4a.objects.ButtonWrapper*/ ,__ref._backbtn /*anywheresoftware.b4a.objects.ButtonWrapper*/ ,__ref._sales /*int[]*/ ,__ref._sales1 /*int[]*/ ,__ref._sales2 /*int[]*/ ,__ref._comname /*String[]*/ ,__ref._maxsale /*int*/ );
RDebugUtils.currentLine=2818051;
 //BA.debugLineNum = 2818051;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.checkbargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="Private checkBoxes() As CheckBox";
_checkboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[(int) (0)];
{
int d0 = _checkboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_checkboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="Private checkedSales() As Boolean";
_checkedsales = new boolean[(int) (0)];
;
RDebugUtils.currentLine=2686981;
 //BA.debugLineNum = 2686981;BA.debugLine="Private Active As Activity";
_active = new anywheresoftware.b4a.objects.ActivityWrapper();
RDebugUtils.currentLine=2686982;
 //BA.debugLineNum = 2686982;BA.debugLine="Private barPanel As Panel";
_barpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2686983;
 //BA.debugLineNum = 2686983;BA.debugLine="Private nxtBtn As Button";
_nxtbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=2686984;
 //BA.debugLineNum = 2686984;BA.debugLine="Private backBtn As Button";
_backbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=2686985;
 //BA.debugLineNum = 2686985;BA.debugLine="Private sales() As Int";
_sales = new int[(int) (0)];
;
RDebugUtils.currentLine=2686986;
 //BA.debugLineNum = 2686986;BA.debugLine="Private sales1() As Int";
_sales1 = new int[(int) (0)];
;
RDebugUtils.currentLine=2686987;
 //BA.debugLineNum = 2686987;BA.debugLine="Private sales2() As Int";
_sales2 = new int[(int) (0)];
;
RDebugUtils.currentLine=2686988;
 //BA.debugLineNum = 2686988;BA.debugLine="Private comName() As String";
_comname = new String[(int) (0)];
java.util.Arrays.fill(_comname,"");
RDebugUtils.currentLine=2686989;
 //BA.debugLineNum = 2686989;BA.debugLine="Private maxSale As Int";
_maxsale = 0;
RDebugUtils.currentLine=2686990;
 //BA.debugLineNum = 2686990;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Public Sub DrawGraph1(Active1 As Activity,barPanel";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="barPanel1.RemoveAllViews ' Clear previous drawing";
_barpanel1.RemoveAllViews();
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="Dim Color() As Int = Array As Int(Colors.Red, Col";
_color = new int[]{__c.Colors.Red,__c.Colors.Green,__c.Colors.Blue};
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="Dim activityPanel As Panel";
_activitypanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2949125;
 //BA.debugLineNum = 2949125;BA.debugLine="activityPanel.Initialize(\"\")";
_activitypanel.Initialize(ba,"");
RDebugUtils.currentLine=2949126;
 //BA.debugLineNum = 2949126;BA.debugLine="activityPanel.Width = 75%x";
_activitypanel.setWidth(__c.PerXToCurrent((float) (75),ba));
RDebugUtils.currentLine=2949127;
 //BA.debugLineNum = 2949127;BA.debugLine="If Active1.Width >800 Then";
if (_active1.getWidth()>800) { 
RDebugUtils.currentLine=2949128;
 //BA.debugLineNum = 2949128;BA.debugLine="activityPanel.Width = 70%x";
_activitypanel.setWidth(__c.PerXToCurrent((float) (70),ba));
 };
RDebugUtils.currentLine=2949130;
 //BA.debugLineNum = 2949130;BA.debugLine="activityPanel.Height = 250dip";
_activitypanel.setHeight(__c.DipToCurrent((int) (250)));
RDebugUtils.currentLine=2949131;
 //BA.debugLineNum = 2949131;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211, 2";
_activitypanel.setColor(__c.Colors.ARGB((int) (70),(int) (211),(int) (211),(int) (211)));
RDebugUtils.currentLine=2949133;
 //BA.debugLineNum = 2949133;BA.debugLine="Dim alignLeftCenter As Int = 0 ' Ensure left alig";
_alignleftcenter = (int) (0);
RDebugUtils.currentLine=2949134;
 //BA.debugLineNum = 2949134;BA.debugLine="If checkedSales.Length > 1 Then";
if (__ref._checkedsales /*boolean[]*/ .length>1) { 
RDebugUtils.currentLine=2949135;
 //BA.debugLineNum = 2949135;BA.debugLine="alignLeftCenter = (barPanel1.Width - activityPan";
_alignleftcenter = (int) ((_barpanel1.getWidth()-_activitypanel.getWidth())/(double)2);
 };
RDebugUtils.currentLine=2949138;
 //BA.debugLineNum = 2949138;BA.debugLine="Dim alignTopCenter As Int = (barPanel1.Height - a";
_aligntopcenter = (int) ((_barpanel1.getHeight()-_activitypanel.getHeight())/(double)2);
RDebugUtils.currentLine=2949139;
 //BA.debugLineNum = 2949139;BA.debugLine="Dim btnLeft As Int = 0";
_btnleft = (int) (0);
RDebugUtils.currentLine=2949141;
 //BA.debugLineNum = 2949141;BA.debugLine="bckBtn.Initialize(\"backBtn\")";
_bckbtn.Initialize(ba,"backBtn");
RDebugUtils.currentLine=2949142;
 //BA.debugLineNum = 2949142;BA.debugLine="bckBtn.Color = Colors.ARGB(50,0,0,0)";
_bckbtn.setColor(__c.Colors.ARGB((int) (50),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=2949143;
 //BA.debugLineNum = 2949143;BA.debugLine="If Active1.Width > 800 Then";
if (_active1.getWidth()>800) { 
RDebugUtils.currentLine=2949144;
 //BA.debugLineNum = 2949144;BA.debugLine="btnLeft = (alignLeftCenter/2)";
_btnleft = (int) ((_alignleftcenter/(double)2));
 }else {
RDebugUtils.currentLine=2949146;
 //BA.debugLineNum = 2949146;BA.debugLine="btnLeft = (alignLeftCenter/2)-30dip";
_btnleft = (int) ((_alignleftcenter/(double)2)-__c.DipToCurrent((int) (30)));
 };
RDebugUtils.currentLine=2949148;
 //BA.debugLineNum = 2949148;BA.debugLine="barPanel1.AddView(bckBtn,btnLeft,(barPanel1.Heigh";
_barpanel1.AddView((android.view.View)(_bckbtn.getObject()),_btnleft,(int) ((_barpanel1.getHeight()/(double)2)-__c.DipToCurrent((int) (10))),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=2949150;
 //BA.debugLineNum = 2949150;BA.debugLine="nextBtn.Initialize(\"nxtBtn\")";
_nextbtn.Initialize(ba,"nxtBtn");
RDebugUtils.currentLine=2949151;
 //BA.debugLineNum = 2949151;BA.debugLine="nextBtn.Color = Colors.ARGB(50,0,0,0)";
_nextbtn.setColor(__c.Colors.ARGB((int) (50),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=2949152;
 //BA.debugLineNum = 2949152;BA.debugLine="barPanel1.AddView(nextBtn,activityPanel.Width+(al";
_barpanel1.AddView((android.view.View)(_nextbtn.getObject()),(int) (_activitypanel.getWidth()+(_alignleftcenter)+__c.DipToCurrent((int) (15))),(int) ((_barpanel1.getHeight()/(double)2)-__c.DipToCurrent((int) (5))),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=2949154;
 //BA.debugLineNum = 2949154;BA.debugLine="If sales_1.Length <= 10 Then";
if (_sales_1.length<=10) { 
RDebugUtils.currentLine=2949155;
 //BA.debugLineNum = 2949155;BA.debugLine="nextBtn.Visible = False";
_nextbtn.setVisible(__c.False);
RDebugUtils.currentLine=2949156;
 //BA.debugLineNum = 2949156;BA.debugLine="bckBtn.Visible = False";
_bckbtn.setVisible(__c.False);
 };
RDebugUtils.currentLine=2949159;
 //BA.debugLineNum = 2949159;BA.debugLine="Dim titleLabel As Label";
_titlelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2949160;
 //BA.debugLineNum = 2949160;BA.debugLine="titleLabel.Initialize(\"\")";
_titlelabel.Initialize(ba,"");
RDebugUtils.currentLine=2949161;
 //BA.debugLineNum = 2949161;BA.debugLine="titleLabel.Text=\"Total Sales For Each Company\"";
_titlelabel.setText(BA.ObjectToCharSequence("Total Sales For Each Company"));
RDebugUtils.currentLine=2949162;
 //BA.debugLineNum = 2949162;BA.debugLine="titleLabel.Gravity = Gravity.CENTER";
_titlelabel.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=2949163;
 //BA.debugLineNum = 2949163;BA.debugLine="titleLabel.Typeface = Typeface.MONOSPACE";
_titlelabel.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=2949164;
 //BA.debugLineNum = 2949164;BA.debugLine="titleLabel.TextSize = 20";
_titlelabel.setTextSize((float) (20));
RDebugUtils.currentLine=2949165;
 //BA.debugLineNum = 2949165;BA.debugLine="titleLabel.TextColor = Colors.Black";
_titlelabel.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=2949166;
 //BA.debugLineNum = 2949166;BA.debugLine="barPanel1.AddView(titleLabel,0,alignTopCenter - 4";
_barpanel1.AddView((android.view.View)(_titlelabel.getObject()),(int) (0),(int) (_aligntopcenter-__c.DipToCurrent((int) (40))),_barpanel1.getWidth(),__c.DipToCurrent((int) (50)));
RDebugUtils.currentLine=2949168;
 //BA.debugLineNum = 2949168;BA.debugLine="barPanel1.AddView(activityPanel, alignLeftCenter,";
_barpanel1.AddView((android.view.View)(_activitypanel.getObject()),_alignleftcenter,_aligntopcenter,_activitypanel.getWidth(),_activitypanel.getHeight());
RDebugUtils.currentLine=2949170;
 //BA.debugLineNum = 2949170;BA.debugLine="Dim graphCanvas As Canvas";
_graphcanvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=2949171;
 //BA.debugLineNum = 2949171;BA.debugLine="graphCanvas.Initialize(activityPanel)";
_graphcanvas.Initialize((android.view.View)(_activitypanel.getObject()));
RDebugUtils.currentLine=2949173;
 //BA.debugLineNum = 2949173;BA.debugLine="maxSale1 = maxSale1 * 1.2";
_maxsale1 = (int) (_maxsale1*1.2);
RDebugUtils.currentLine=2949174;
 //BA.debugLineNum = 2949174;BA.debugLine="Dim totalProducts As Int = sales_1.Length";
_totalproducts = _sales_1.length;
RDebugUtils.currentLine=2949175;
 //BA.debugLineNum = 2949175;BA.debugLine="Dim barsPerProduct As Int = 3";
_barsperproduct = (int) (3);
RDebugUtils.currentLine=2949176;
 //BA.debugLineNum = 2949176;BA.debugLine="Dim gap As Int = 15dip";
_gap = __c.DipToCurrent((int) (15));
RDebugUtils.currentLine=2949177;
 //BA.debugLineNum = 2949177;BA.debugLine="Dim productGap As Int = 5dip";
_productgap = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=2949178;
 //BA.debugLineNum = 2949178;BA.debugLine="Dim padding As Int = 0 ' Remove left padding when";
_padding = (int) (0);
RDebugUtils.currentLine=2949181;
 //BA.debugLineNum = 2949181;BA.debugLine="Dim numLabels As Int = 10";
_numlabels = (int) (10);
RDebugUtils.currentLine=2949182;
 //BA.debugLineNum = 2949182;BA.debugLine="Dim labelStep As Int = maxSale1 / numLabels";
_labelstep = (int) (_maxsale1/(double)_numlabels);
RDebugUtils.currentLine=2949183;
 //BA.debugLineNum = 2949183;BA.debugLine="Dim labelHeightStep As Int = activityPanel.Height";
_labelheightstep = (int) (_activitypanel.getHeight()/(double)_numlabels);
RDebugUtils.currentLine=2949185;
 //BA.debugLineNum = 2949185;BA.debugLine="For i = 0 To numLabels";
{
final int step52 = 1;
final int limit52 = _numlabels;
_i = (int) (0) ;
for (;_i <= limit52 ;_i = _i + step52 ) {
RDebugUtils.currentLine=2949186;
 //BA.debugLineNum = 2949186;BA.debugLine="Dim lblY As Int = activityPanel.Height - (i * la";
_lbly = (int) (_activitypanel.getHeight()-(_i*_labelheightstep)+_aligntopcenter-__c.DipToCurrent((int) (10)));
RDebugUtils.currentLine=2949187;
 //BA.debugLineNum = 2949187;BA.debugLine="Dim lblValue As Int = i * labelStep";
_lblvalue = (int) (_i*_labelstep);
RDebugUtils.currentLine=2949189;
 //BA.debugLineNum = 2949189;BA.debugLine="Dim lblLeft As Label";
_lblleft = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2949190;
 //BA.debugLineNum = 2949190;BA.debugLine="lblLeft.Initialize(\"\")";
_lblleft.Initialize(ba,"");
RDebugUtils.currentLine=2949191;
 //BA.debugLineNum = 2949191;BA.debugLine="lblLeft.Text = FormatNumberWithLabel(lblValue)";
_lblleft.setText(BA.ObjectToCharSequence(__ref._formatnumberwithlabel /*String*/ (null,_lblvalue)));
RDebugUtils.currentLine=2949192;
 //BA.debugLineNum = 2949192;BA.debugLine="lblLeft.TextColor = Colors.Black";
_lblleft.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=2949193;
 //BA.debugLineNum = 2949193;BA.debugLine="lblLeft.Gravity = Gravity.RIGHT";
_lblleft.setGravity(__c.Gravity.RIGHT);
RDebugUtils.currentLine=2949194;
 //BA.debugLineNum = 2949194;BA.debugLine="lblLeft.Typeface = Typeface.MONOSPACE";
_lblleft.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=2949195;
 //BA.debugLineNum = 2949195;BA.debugLine="lblLeft.TextSize = 10";
_lblleft.setTextSize((float) (10));
RDebugUtils.currentLine=2949196;
 //BA.debugLineNum = 2949196;BA.debugLine="lblLeft.Color = Colors.Transparent";
_lblleft.setColor(__c.Colors.Transparent);
RDebugUtils.currentLine=2949198;
 //BA.debugLineNum = 2949198;BA.debugLine="barPanel1.AddView(lblLeft, alignLeftCenter - 45d";
_barpanel1.AddView((android.view.View)(_lblleft.getObject()),(int) (_alignleftcenter-__c.DipToCurrent((int) (45))),_lbly,__c.DipToCurrent((int) (40)),__c.DipToCurrent((int) (20)));
 }
};
RDebugUtils.currentLine=2949201;
 //BA.debugLineNum = 2949201;BA.debugLine="Dim checkedCount As Int = 0";
_checkedcount = (int) (0);
RDebugUtils.currentLine=2949202;
 //BA.debugLineNum = 2949202;BA.debugLine="For i = 0 To checkedSales.Length - 1";
{
final int step66 = 1;
final int limit66 = (int) (__ref._checkedsales /*boolean[]*/ .length-1);
_i = (int) (0) ;
for (;_i <= limit66 ;_i = _i + step66 ) {
RDebugUtils.currentLine=2949203;
 //BA.debugLineNum = 2949203;BA.debugLine="If checkedSales(i) Then checkedCount = checkedCo";
if (__ref._checkedsales /*boolean[]*/ [_i]) { 
_checkedcount = (int) (_checkedcount+1);};
 }
};
RDebugUtils.currentLine=2949206;
 //BA.debugLineNum = 2949206;BA.debugLine="Dim availableWidth As Int = activityPanel.Width -";
_availablewidth = (int) (_activitypanel.getWidth()-((_totalproducts-1)*_productgap));
RDebugUtils.currentLine=2949207;
 //BA.debugLineNum = 2949207;BA.debugLine="Dim barWidth As Int = availableWidth / (totalProd";
_barwidth = (int) (_availablewidth/(double)(_totalproducts*_checkedcount));
RDebugUtils.currentLine=2949209;
 //BA.debugLineNum = 2949209;BA.debugLine="If sales_1.Length <= 4 Then";
if (_sales_1.length<=4) { 
RDebugUtils.currentLine=2949210;
 //BA.debugLineNum = 2949210;BA.debugLine="barWidth = 30dip";
_barwidth = __c.DipToCurrent((int) (30));
 };
RDebugUtils.currentLine=2949212;
 //BA.debugLineNum = 2949212;BA.debugLine="If Active1.Width > 800 Then";
if (_active1.getWidth()>800) { 
RDebugUtils.currentLine=2949213;
 //BA.debugLineNum = 2949213;BA.debugLine="If checkedCount =1 Then";
if (_checkedcount==1) { 
RDebugUtils.currentLine=2949214;
 //BA.debugLineNum = 2949214;BA.debugLine="barWidth = 30dip";
_barwidth = __c.DipToCurrent((int) (30));
RDebugUtils.currentLine=2949215;
 //BA.debugLineNum = 2949215;BA.debugLine="productGap = 45.5dip";
_productgap = __c.DipToCurrent((int) (45.5));
 };
 }else {
RDebugUtils.currentLine=2949218;
 //BA.debugLineNum = 2949218;BA.debugLine="If checkedCount =1 Then";
if (_checkedcount==1) { 
RDebugUtils.currentLine=2949219;
 //BA.debugLineNum = 2949219;BA.debugLine="barWidth = 30dip";
_barwidth = __c.DipToCurrent((int) (30));
RDebugUtils.currentLine=2949220;
 //BA.debugLineNum = 2949220;BA.debugLine="productGap = 18dip";
_productgap = __c.DipToCurrent((int) (18));
 };
 };
RDebugUtils.currentLine=2949225;
 //BA.debugLineNum = 2949225;BA.debugLine="Dim xStart As Int = 5dip ' Start from left when o";
_xstart = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=2949228;
 //BA.debugLineNum = 2949228;BA.debugLine="For i = 0 To totalProducts - 1";
{
final int step86 = 1;
final int limit86 = (int) (_totalproducts-1);
_i = (int) (0) ;
for (;_i <= limit86 ;_i = _i + step86 ) {
RDebugUtils.currentLine=2949229;
 //BA.debugLineNum = 2949229;BA.debugLine="Dim xPos As Int = xStart + (i * (checkedCount *";
_xpos = (int) (_xstart+(_i*(_checkedcount*_barwidth+_productgap)));
RDebugUtils.currentLine=2949230;
 //BA.debugLineNum = 2949230;BA.debugLine="Dim saleValues() As Int = Array As Int(sales_1(i";
_salevalues = new int[]{_sales_1[_i],_sales_2[_i],_sales_3[_i]};
RDebugUtils.currentLine=2949232;
 //BA.debugLineNum = 2949232;BA.debugLine="Dim indexOffset As Int = 0 ' Shift bars properly";
_indexoffset = (int) (0);
RDebugUtils.currentLine=2949234;
 //BA.debugLineNum = 2949234;BA.debugLine="For j = 0 To barsPerProduct - 1";
{
final int step90 = 1;
final int limit90 = (int) (_barsperproduct-1);
_j = (int) (0) ;
for (;_j <= limit90 ;_j = _j + step90 ) {
RDebugUtils.currentLine=2949235;
 //BA.debugLineNum = 2949235;BA.debugLine="If j < checkedSales.Length And checkedSales(j)";
if (_j<__ref._checkedsales /*boolean[]*/ .length && __ref._checkedsales /*boolean[]*/ [_j]) { 
RDebugUtils.currentLine=2949236;
 //BA.debugLineNum = 2949236;BA.debugLine="Dim sale As Int = saleValues(j)";
_sale = _salevalues[_j];
RDebugUtils.currentLine=2949237;
 //BA.debugLineNum = 2949237;BA.debugLine="Dim barHeight As Int = (sale / maxSale1) * act";
_barheight = (int) ((_sale/(double)_maxsale1)*_activitypanel.getHeight());
RDebugUtils.currentLine=2949238;
 //BA.debugLineNum = 2949238;BA.debugLine="Dim xBar As Int = xPos + indexOffset * barWidt";
_xbar = (int) (_xpos+_indexoffset*_barwidth);
RDebugUtils.currentLine=2949241;
 //BA.debugLineNum = 2949241;BA.debugLine="Dim lblSale As Label";
_lblsale = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2949242;
 //BA.debugLineNum = 2949242;BA.debugLine="lblSale.Initialize(\"\")";
_lblsale.Initialize(ba,"");
RDebugUtils.currentLine=2949243;
 //BA.debugLineNum = 2949243;BA.debugLine="lblSale.Text = FormatNumberWithSuffix(sale) '";
_lblsale.setText(BA.ObjectToCharSequence(__ref._formatnumberwithsuffix /*String*/ (null,_sale)));
RDebugUtils.currentLine=2949244;
 //BA.debugLineNum = 2949244;BA.debugLine="lblSale.TextColor = Colors.Black";
_lblsale.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=2949245;
 //BA.debugLineNum = 2949245;BA.debugLine="lblSale.Gravity = Gravity.CENTER";
_lblsale.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=2949246;
 //BA.debugLineNum = 2949246;BA.debugLine="lblSale.Typeface = Typeface.MONOSPACE";
_lblsale.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=2949247;
 //BA.debugLineNum = 2949247;BA.debugLine="lblSale.TextSize = 7";
_lblsale.setTextSize((float) (7));
RDebugUtils.currentLine=2949248;
 //BA.debugLineNum = 2949248;BA.debugLine="lblSale.Color = Colors.Transparent";
_lblsale.setColor(__c.Colors.Transparent);
RDebugUtils.currentLine=2949249;
 //BA.debugLineNum = 2949249;BA.debugLine="If Active1.Width > 800 Then";
if (_active1.getWidth()>800) { 
RDebugUtils.currentLine=2949250;
 //BA.debugLineNum = 2949250;BA.debugLine="If checkedCount > 2 Then";
if (_checkedcount>2) { 
RDebugUtils.currentLine=2949251;
 //BA.debugLineNum = 2949251;BA.debugLine="lblSale.TextSize = 5";
_lblsale.setTextSize((float) (5));
 };
 }else {
RDebugUtils.currentLine=2949254;
 //BA.debugLineNum = 2949254;BA.debugLine="If checkedCount =3 Then";
if (_checkedcount==3) { 
RDebugUtils.currentLine=2949255;
 //BA.debugLineNum = 2949255;BA.debugLine="lblSale.TextSize = 4";
_lblsale.setTextSize((float) (4));
 };
RDebugUtils.currentLine=2949257;
 //BA.debugLineNum = 2949257;BA.debugLine="If checkedCount =2 Then";
if (_checkedcount==2) { 
RDebugUtils.currentLine=2949258;
 //BA.debugLineNum = 2949258;BA.debugLine="lblSale.TextSize =3.8";
_lblsale.setTextSize((float) (3.8));
 };
 };
RDebugUtils.currentLine=2949262;
 //BA.debugLineNum = 2949262;BA.debugLine="Dim lblSaleLeft As Int = xBar + alignLeftCente";
_lblsaleleft = (int) (_xbar+_alignleftcenter);
RDebugUtils.currentLine=2949263;
 //BA.debugLineNum = 2949263;BA.debugLine="Dim lblSaleTop As Int = activityPanel.Height -";
_lblsaletop = (int) (_activitypanel.getHeight()-_barheight-__c.DipToCurrent((int) (15))+_aligntopcenter);
RDebugUtils.currentLine=2949265;
 //BA.debugLineNum = 2949265;BA.debugLine="barPanel1.AddView(lblSale, lblSaleLeft, lblSal";
_barpanel1.AddView((android.view.View)(_lblsale.getObject()),_lblsaleleft,_lblsaletop,_barwidth,__c.DipToCurrent((int) (15)));
RDebugUtils.currentLine=2949269;
 //BA.debugLineNum = 2949269;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=2949270;
 //BA.debugLineNum = 2949270;BA.debugLine="r.Initialize(xBar, activityPanel.Height - barH";
_r.Initialize(_xbar,(int) (_activitypanel.getHeight()-_barheight),(int) (_xbar+_barwidth),_activitypanel.getHeight());
RDebugUtils.currentLine=2949271;
 //BA.debugLineNum = 2949271;BA.debugLine="graphCanvas.DrawRect(r, Color(j), True, 2dip)";
_graphcanvas.DrawRect((android.graphics.Rect)(_r.getObject()),_color[_j],__c.True,(float) (__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=2949273;
 //BA.debugLineNum = 2949273;BA.debugLine="indexOffset = indexOffset + 1 ' Increase offse";
_indexoffset = (int) (_indexoffset+1);
 };
 }
};
RDebugUtils.currentLine=2949276;
 //BA.debugLineNum = 2949276;BA.debugLine="Dim lblCompany As Label";
_lblcompany = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2949277;
 //BA.debugLineNum = 2949277;BA.debugLine="lblCompany.Initialize(\"\")";
_lblcompany.Initialize(ba,"");
RDebugUtils.currentLine=2949278;
 //BA.debugLineNum = 2949278;BA.debugLine="lblCompany.Text = comName(i)";
_lblcompany.setText(BA.ObjectToCharSequence(__ref._comname /*String[]*/ [_i]));
RDebugUtils.currentLine=2949279;
 //BA.debugLineNum = 2949279;BA.debugLine="lblCompany.TextColor = Colors.Black";
_lblcompany.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=2949280;
 //BA.debugLineNum = 2949280;BA.debugLine="lblCompany.Gravity = Gravity.CENTER";
_lblcompany.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=2949281;
 //BA.debugLineNum = 2949281;BA.debugLine="lblCompany.Typeface = Typeface.MONOSPACE";
_lblcompany.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=2949282;
 //BA.debugLineNum = 2949282;BA.debugLine="lblCompany.TextSize = 10";
_lblcompany.setTextSize((float) (10));
RDebugUtils.currentLine=2949283;
 //BA.debugLineNum = 2949283;BA.debugLine="lblCompany.Color = Colors.Transparent";
_lblcompany.setColor(__c.Colors.Transparent);
RDebugUtils.currentLine=2949284;
 //BA.debugLineNum = 2949284;BA.debugLine="If Active1.Width <= 800 Then";
if (_active1.getWidth()<=800) { 
RDebugUtils.currentLine=2949285;
 //BA.debugLineNum = 2949285;BA.debugLine="lblCompany.TextSize = 7";
_lblcompany.setTextSize((float) (7));
RDebugUtils.currentLine=2949286;
 //BA.debugLineNum = 2949286;BA.debugLine="If checkedCount = 1 Then";
if (_checkedcount==1) { 
RDebugUtils.currentLine=2949287;
 //BA.debugLineNum = 2949287;BA.debugLine="lblCompany.TextSize = 8";
_lblcompany.setTextSize((float) (8));
 };
 };
RDebugUtils.currentLine=2949290;
 //BA.debugLineNum = 2949290;BA.debugLine="Dim totalBarWidth As Int = checkedCount * barWid";
_totalbarwidth = (int) (_checkedcount*_barwidth);
RDebugUtils.currentLine=2949291;
 //BA.debugLineNum = 2949291;BA.debugLine="Dim lblCompanyWidth As Int = totalBarWidth ' Set";
_lblcompanywidth = _totalbarwidth;
RDebugUtils.currentLine=2949292;
 //BA.debugLineNum = 2949292;BA.debugLine="Dim lblCompanyLeft As Int = xPos + (totalBarWidt";
_lblcompanyleft = (int) (_xpos+(_totalbarwidth/(double)2)-(_lblcompanywidth/(double)2)+_alignleftcenter);
RDebugUtils.currentLine=2949293;
 //BA.debugLineNum = 2949293;BA.debugLine="If checkedCount =1 Then";
if (_checkedcount==1) { 
RDebugUtils.currentLine=2949294;
 //BA.debugLineNum = 2949294;BA.debugLine="lblCompanyWidth = productGap";
_lblcompanywidth = _productgap;
RDebugUtils.currentLine=2949295;
 //BA.debugLineNum = 2949295;BA.debugLine="lblCompany.Gravity = Gravity.LEFT";
_lblcompany.setGravity(__c.Gravity.LEFT);
RDebugUtils.currentLine=2949296;
 //BA.debugLineNum = 2949296;BA.debugLine="lblCompanyWidth = productGap + barWidth";
_lblcompanywidth = (int) (_productgap+_barwidth);
 };
RDebugUtils.currentLine=2949299;
 //BA.debugLineNum = 2949299;BA.debugLine="Dim lblCompanyTop As Int = activityPanel.Height";
_lblcompanytop = (int) (_activitypanel.getHeight()+__c.DipToCurrent((int) (5))+_aligntopcenter);
RDebugUtils.currentLine=2949301;
 //BA.debugLineNum = 2949301;BA.debugLine="barPanel1.AddView(lblCompany, lblCompanyLeft, lb";
_barpanel1.AddView((android.view.View)(_lblcompany.getObject()),_lblcompanyleft,_lblcompanytop,_lblcompanywidth,__c.DipToCurrent((int) (15)));
 }
};
RDebugUtils.currentLine=2949305;
 //BA.debugLineNum = 2949305;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithlabel(b4a.example.checkbargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithlabel", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithlabel", new Object[] {_number}));}
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub FormatNumberWithLabel(number As Int) As String";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="Return Floor(number / 1000000) & \"M\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000000))+"M";
 }else 
{RDebugUtils.currentLine=3145731;
 //BA.debugLineNum = 3145731;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="Return Floor(number / 1000) & \"k\"";
if (true) return BA.NumberToString(__c.Floor(_number/(double)1000))+"k";
 }else {
RDebugUtils.currentLine=3145734;
 //BA.debugLineNum = 3145734;BA.debugLine="Return Floor(number)";
if (true) return BA.NumberToString(__c.Floor(_number));
 }}
;
RDebugUtils.currentLine=3145736;
 //BA.debugLineNum = 3145736;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithsuffix(b4a.example.checkbargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithsuffix", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithsuffix", new Object[] {_number}));}
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
if (true) return __c.NumberFormat(_number/(double)1000000,(int) (1),(int) (1))+"M";
 }else 
{RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=3080196;
 //BA.debugLineNum = 3080196;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
if (true) return __c.NumberFormat(_number/(double)1000,(int) (1),(int) (1))+"k";
 }else {
RDebugUtils.currentLine=3080198;
 //BA.debugLineNum = 3080198;BA.debugLine="Return NumberFormat(number, 1, 0)";
if (true) return __c.NumberFormat(_number,(int) (1),(int) (0));
 }}
;
RDebugUtils.currentLine=3080200;
 //BA.debugLineNum = 3080200;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub DrawWrappedTextRotated(canvas As Canvas, text";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="Dim words() As String = Regex.Split(\" \", text)";
_words = __c.Regex.Split(" ",_text);
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="Dim line As String = \"\"";
_line = "";
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="Dim lineHeight As Int = 20dip ' Space between lin";
_lineheight = __c.DipToCurrent((int) (20));
RDebugUtils.currentLine=3014660;
 //BA.debugLineNum = 3014660;BA.debugLine="Dim originalY As Int = y ' Store original Y posit";
_originaly = _y;
RDebugUtils.currentLine=3014662;
 //BA.debugLineNum = 3014662;BA.debugLine="For Each word As String In words";
{
final String[] group5 = _words;
final int groupLen5 = group5.length
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_word = group5[index5];
RDebugUtils.currentLine=3014663;
 //BA.debugLineNum = 3014663;BA.debugLine="Dim testLine As String = line & word & \" \"";
_testline = _line+_word+" ";
RDebugUtils.currentLine=3014664;
 //BA.debugLineNum = 3014664;BA.debugLine="Dim textWidth As Int = canvas.MeasureStringWidth";
_textwidth = (int) (_canvas.MeasureStringWidth(_testline,__c.Typeface.MONOSPACE,_fontsize));
RDebugUtils.currentLine=3014666;
 //BA.debugLineNum = 3014666;BA.debugLine="If textWidth > maxWidth And line <> \"\" Then";
if (_textwidth>_maxwidth && (_line).equals("") == false) { 
RDebugUtils.currentLine=3014668;
 //BA.debugLineNum = 3014668;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEF";
_canvas.DrawTextRotated(ba,_line,(float) (_x),(float) (_y),__c.Typeface.DEFAULT_BOLD,_fontsize,_color,BA.getEnumFromString(android.graphics.Paint.Align.class,_alignment),_angle);
RDebugUtils.currentLine=3014669;
 //BA.debugLineNum = 3014669;BA.debugLine="y = y + lineHeight ' Move to next line";
_y = (int) (_y+_lineheight);
RDebugUtils.currentLine=3014670;
 //BA.debugLineNum = 3014670;BA.debugLine="line = word & \" \" ' Start new line";
_line = _word+" ";
 }else {
RDebugUtils.currentLine=3014672;
 //BA.debugLineNum = 3014672;BA.debugLine="line = testLine ' Add word to current line";
_line = _testline;
 };
 }
};
RDebugUtils.currentLine=3014677;
 //BA.debugLineNum = 3014677;BA.debugLine="If line <> \"\" Then";
if ((_line).equals("") == false) { 
RDebugUtils.currentLine=3014678;
 //BA.debugLineNum = 3014678;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEFA";
_canvas.DrawTextRotated(ba,_line,(float) (_x),(float) (_y),__c.Typeface.DEFAULT_BOLD,_fontsize,_color,BA.getEnumFromString(android.graphics.Paint.Align.class,_alignment),_angle);
RDebugUtils.currentLine=3014679;
 //BA.debugLineNum = 3014679;BA.debugLine="y = y + lineHeight ' Move final Y position";
_y = (int) (_y+_lineheight);
 };
RDebugUtils.currentLine=3014683;
 //BA.debugLineNum = 3014683;BA.debugLine="Return y - originalY";
if (true) return (int) (_y-_originaly);
RDebugUtils.currentLine=3014684;
 //BA.debugLineNum = 3014684;BA.debugLine="End Sub";
return 0;
}
public String  _initialize(b4a.example.checkbargraph __ref,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _active1,anywheresoftware.b4a.objects.PanelWrapper _barpanel1,anywheresoftware.b4a.objects.ButtonWrapper _nextbtn,anywheresoftware.b4a.objects.ButtonWrapper _bckbtn,int[] _sales_1,int[] _sales_2,int[] _sales_3,String[] _comname1,int _maxsale1,String[] _legend) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="checkbargraph";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_active1,_barpanel1,_nextbtn,_bckbtn,_sales_1,_sales_2,_sales_3,_comname1,_maxsale1,_legend}));}
int _legendcount = 0;
anywheresoftware.b4a.objects.PanelWrapper _legendpanel = null;
int[] _color = null;
int _legendwidth = 0;
int _i = 0;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chk = null;
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Public Sub Initialize(Active1 As Activity, barPane";
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="Active = Active1";
__ref._active /*anywheresoftware.b4a.objects.ActivityWrapper*/  = _active1;
RDebugUtils.currentLine=2752515;
 //BA.debugLineNum = 2752515;BA.debugLine="barPanel = barPanel1";
__ref._barpanel /*anywheresoftware.b4a.objects.PanelWrapper*/  = _barpanel1;
RDebugUtils.currentLine=2752516;
 //BA.debugLineNum = 2752516;BA.debugLine="nxtBtn = nextBtn";
__ref._nxtbtn /*anywheresoftware.b4a.objects.ButtonWrapper*/  = _nextbtn;
RDebugUtils.currentLine=2752517;
 //BA.debugLineNum = 2752517;BA.debugLine="backBtn = bckBtn";
__ref._backbtn /*anywheresoftware.b4a.objects.ButtonWrapper*/  = _bckbtn;
RDebugUtils.currentLine=2752518;
 //BA.debugLineNum = 2752518;BA.debugLine="sales = sales_1";
__ref._sales /*int[]*/  = _sales_1;
RDebugUtils.currentLine=2752519;
 //BA.debugLineNum = 2752519;BA.debugLine="sales1 = sales_2";
__ref._sales1 /*int[]*/  = _sales_2;
RDebugUtils.currentLine=2752520;
 //BA.debugLineNum = 2752520;BA.debugLine="sales2 = sales_3";
__ref._sales2 /*int[]*/  = _sales_3;
RDebugUtils.currentLine=2752521;
 //BA.debugLineNum = 2752521;BA.debugLine="comName = comName1";
__ref._comname /*String[]*/  = _comname1;
RDebugUtils.currentLine=2752522;
 //BA.debugLineNum = 2752522;BA.debugLine="maxSale = maxSale1";
__ref._maxsale /*int*/  = _maxsale1;
RDebugUtils.currentLine=2752524;
 //BA.debugLineNum = 2752524;BA.debugLine="Dim legendCount As Int = legend.Length";
_legendcount = _legend.length;
RDebugUtils.currentLine=2752525;
 //BA.debugLineNum = 2752525;BA.debugLine="checkBoxes = Array As CheckBox()";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/  = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]{};
RDebugUtils.currentLine=2752526;
 //BA.debugLineNum = 2752526;BA.debugLine="checkedSales = Array As Boolean()";
__ref._checkedsales /*boolean[]*/  = new boolean[]{};
RDebugUtils.currentLine=2752527;
 //BA.debugLineNum = 2752527;BA.debugLine="Dim checkBoxes(legendCount) As CheckBox";
_checkboxes = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[_legendcount];
{
int d0 = _checkboxes.length;
for (int i0 = 0;i0 < d0;i0++) {
_checkboxes[i0] = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
}
}
;
RDebugUtils.currentLine=2752528;
 //BA.debugLineNum = 2752528;BA.debugLine="Dim checkedSales(legendCount) As Boolean";
_checkedsales = new boolean[_legendcount];
;
RDebugUtils.currentLine=2752530;
 //BA.debugLineNum = 2752530;BA.debugLine="Dim legendPanel As Panel";
_legendpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2752531;
 //BA.debugLineNum = 2752531;BA.debugLine="legendPanel.Initialize(\"\")";
_legendpanel.Initialize(ba,"");
RDebugUtils.currentLine=2752532;
 //BA.debugLineNum = 2752532;BA.debugLine="legendPanel.Width = Active.Width";
_legendpanel.setWidth(__ref._active /*anywheresoftware.b4a.objects.ActivityWrapper*/ .getWidth());
RDebugUtils.currentLine=2752533;
 //BA.debugLineNum = 2752533;BA.debugLine="legendPanel.Height = 50dip";
_legendpanel.setHeight(__c.DipToCurrent((int) (50)));
RDebugUtils.currentLine=2752534;
 //BA.debugLineNum = 2752534;BA.debugLine="Active1.AddView(legendPanel, (barPanel1.Width/3.5";
_active1.AddView((android.view.View)(_legendpanel.getObject()),(int) ((_barpanel1.getWidth()/(double)3.5)),(int) (_barpanel1.getTop()+__c.DipToCurrent((int) (5))),(int) (_barpanel1.getWidth()/(double)1.5),__c.DipToCurrent((int) (50)));
RDebugUtils.currentLine=2752536;
 //BA.debugLineNum = 2752536;BA.debugLine="Dim Color() As Int = Array As Int(Colors.Red, Col";
_color = new int[]{__c.Colors.Red,__c.Colors.Green,__c.Colors.Blue};
RDebugUtils.currentLine=2752537;
 //BA.debugLineNum = 2752537;BA.debugLine="Dim legendWidth As Int = legendPanel.Width / lege";
_legendwidth = (int) (_legendpanel.getWidth()/(double)_legend.length);
RDebugUtils.currentLine=2752539;
 //BA.debugLineNum = 2752539;BA.debugLine="For i = 0 To legendCount - 1";
{
final int step22 = 1;
final int limit22 = (int) (_legendcount-1);
_i = (int) (0) ;
for (;_i <= limit22 ;_i = _i + step22 ) {
RDebugUtils.currentLine=2752540;
 //BA.debugLineNum = 2752540;BA.debugLine="Dim chk As CheckBox";
_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=2752541;
 //BA.debugLineNum = 2752541;BA.debugLine="chk.Initialize(\"chkChange\") ' Ensure correct eve";
_chk.Initialize(ba,"chkChange");
RDebugUtils.currentLine=2752542;
 //BA.debugLineNum = 2752542;BA.debugLine="chk.Text = legend(i)";
_chk.setText(BA.ObjectToCharSequence(_legend[_i]));
RDebugUtils.currentLine=2752543;
 //BA.debugLineNum = 2752543;BA.debugLine="chk.TextSize = 10";
_chk.setTextSize((float) (10));
RDebugUtils.currentLine=2752544;
 //BA.debugLineNum = 2752544;BA.debugLine="chk.Typeface = Typeface.MONOSPACE";
_chk.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=2752545;
 //BA.debugLineNum = 2752545;BA.debugLine="chk.TextColor = Color(i)";
_chk.setTextColor(_color[_i]);
RDebugUtils.currentLine=2752546;
 //BA.debugLineNum = 2752546;BA.debugLine="chk.Tag = i";
_chk.setTag((Object)(_i));
RDebugUtils.currentLine=2752547;
 //BA.debugLineNum = 2752547;BA.debugLine="chk.Checked = True ' Initially checked";
_chk.setChecked(__c.True);
RDebugUtils.currentLine=2752549;
 //BA.debugLineNum = 2752549;BA.debugLine="legendPanel.AddView(chk, (legendWidth * i) + 10d";
_legendpanel.AddView((android.view.View)(_chk.getObject()),(int) ((_legendwidth*_i)+__c.DipToCurrent((int) (10))),__c.DipToCurrent((int) (5)),(int) (_legendwidth-__c.DipToCurrent((int) (20))),__c.DipToCurrent((int) (40)));
RDebugUtils.currentLine=2752550;
 //BA.debugLineNum = 2752550;BA.debugLine="checkBoxes(i) = chk";
__ref._checkboxes /*anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[]*/ [_i] = _chk;
RDebugUtils.currentLine=2752551;
 //BA.debugLineNum = 2752551;BA.debugLine="checkedSales(i) = True";
__ref._checkedsales /*boolean[]*/ [_i] = __c.True;
 }
};
RDebugUtils.currentLine=2752553;
 //BA.debugLineNum = 2752553;BA.debugLine="DrawGraph";
__ref._drawgraph /*String*/ (null);
RDebugUtils.currentLine=2752554;
 //BA.debugLineNum = 2752554;BA.debugLine="End Sub";
return "";
}
}