package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,66);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _gradient = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.GradientDrawable");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 66;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(4);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 68;BA.debugLine="Panel1.Color = Colors.Black";
Debug.ShouldStop(8);
main.mostCurrent._panel1.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 69;BA.debugLine="Label1.Text = Label1.Text.ToUpperCase";
Debug.ShouldStop(16);
main.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._label1.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 70;BA.debugLine="Label1.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(32);
main.mostCurrent._label1.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 71;BA.debugLine="ScrollView1.Panel.Color = Colors.ARGB(255, 241, 2";
Debug.ShouldStop(64);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 241)),(Object)(BA.numberCast(int.class, 241)),(Object)(BA.numberCast(int.class, 241))));
 BA.debugLineNum = 72;BA.debugLine="Dim gradient As GradientDrawable";
Debug.ShouldStop(128);
_gradient = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("gradient", _gradient);
 BA.debugLineNum = 73;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
Debug.ShouldStop(256);
_gradient.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"RIGHT_LEFT")),(Object)(RemoteObject.createNewArray("int",new int[] {2},new Object[] {main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 225)),(Object)(BA.numberCast(int.class, 218)),(Object)(BA.numberCast(int.class, 218))),main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 189)),(Object)(BA.numberCast(int.class, 202)),(Object)(BA.numberCast(int.class, 217)))})));
 BA.debugLineNum = 75;BA.debugLine="ScrollView1.Background = gradient";
Debug.ShouldStop(1024);
main.mostCurrent._scrollview1.runMethod(false,"setBackground",(_gradient.getObject()));
 BA.debugLineNum = 76;BA.debugLine="ScrollView1.Panel.Height = Activity.Height";
Debug.ShouldStop(2048);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",main.mostCurrent._activity.runMethod(true,"getHeight"));
 BA.debugLineNum = 77;BA.debugLine="Dim gradient As GradientDrawable";
Debug.ShouldStop(4096);
_gradient = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("gradient", _gradient);
 BA.debugLineNum = 78;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
Debug.ShouldStop(8192);
_gradient.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"RIGHT_LEFT")),(Object)(RemoteObject.createNewArray("int",new int[] {2},new Object[] {main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 185)),(Object)(BA.numberCast(int.class, 46)),(Object)(BA.numberCast(int.class, 52))),main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 61)),(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 2)))})));
 BA.debugLineNum = 80;BA.debugLine="Panel2.Background = gradient";
Debug.ShouldStop(32768);
main.mostCurrent._panel2.runMethod(false,"setBackground",(_gradient.getObject()));
 BA.debugLineNum = 81;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(65536);
_loadcompanydata();
 BA.debugLineNum = 82;BA.debugLine="LoadGraphData";
Debug.ShouldStop(131072);
_loadgraphdata();
 BA.debugLineNum = 83;BA.debugLine="barPanel.Initialize(\"\")";
Debug.ShouldStop(262144);
main.mostCurrent._barpanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 86;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,433);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 433;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 435;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,429);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 429;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4096);
 BA.debugLineNum = 431;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _adjustfontsizetoheight(RemoteObject _lbl,RemoteObject _fontscalefactor) throws Exception{
try {
		Debug.PushSubsStack("AdjustFontSizeToHeight (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,507);
if (RapidSub.canDelegate("adjustfontsizetoheight")) { return b4a.example.main.remoteMe.runUserSub(false, "main","adjustfontsizetoheight", _lbl, _fontscalefactor);}
RemoteObject _fontsize = RemoteObject.createImmutable(0f);
Debug.locals.put("lbl", _lbl);
Debug.locals.put("fontScaleFactor", _fontscalefactor);
 BA.debugLineNum = 507;BA.debugLine="Sub AdjustFontSizeToHeight(lbl As Label, fontScale";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 508;BA.debugLine="Dim fontSize As Float = lbl.Height * fontScaleFac";
Debug.ShouldStop(134217728);
_fontsize = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_lbl.runMethod(true,"getHeight"),_fontscalefactor,_getdevicedensity()}, "*/",0, 0));Debug.locals.put("fontSize", _fontsize);Debug.locals.put("fontSize", _fontsize);
 BA.debugLineNum = 509;BA.debugLine="Return fontSize";
Debug.ShouldStop(268435456);
Debug.CheckDeviceExceptions();if (true) return _fontsize;
 BA.debugLineNum = 510;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(0f);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _defbtn_click() throws Exception{
try {
		Debug.PushSubsStack("defBtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,461);
if (RapidSub.canDelegate("defbtn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","defbtn_click");}
 BA.debugLineNum = 461;BA.debugLine="Sub defBtn_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 462;BA.debugLine="Log(\"Default\")";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5786433",RemoteObject.createImmutable("Default"),0);
 BA.debugLineNum = 463;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getdevicedensity() throws Exception{
try {
		Debug.PushSubsStack("GetDeviceDensity (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,511);
if (RapidSub.canDelegate("getdevicedensity")) { return b4a.example.main.remoteMe.runUserSub(false, "main","getdevicedensity");}
RemoteObject _pixelwidth = RemoteObject.createImmutable(0);
RemoteObject _dipwidth = RemoteObject.createImmutable(0);
RemoteObject _dense = RemoteObject.createImmutable(0f);
 BA.debugLineNum = 511;BA.debugLine="Sub GetDeviceDensity As Float";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 512;BA.debugLine="Dim pixelWidth As Int = 100%x ' Screen width in p";
Debug.ShouldStop(-2147483648);
_pixelwidth = main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA);Debug.locals.put("pixelWidth", _pixelwidth);Debug.locals.put("pixelWidth", _pixelwidth);
 BA.debugLineNum = 513;BA.debugLine="Dim dipWidth As Int = 100dip  ' 100 DIPs in pixel";
Debug.ShouldStop(1);
_dipwidth = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)));Debug.locals.put("dipWidth", _dipwidth);Debug.locals.put("dipWidth", _dipwidth);
 BA.debugLineNum = 514;BA.debugLine="Dim Dense As Float = pixelWidth / dipWidth";
Debug.ShouldStop(2);
_dense = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_pixelwidth,_dipwidth}, "/",0, 0));Debug.locals.put("Dense", _dense);Debug.locals.put("Dense", _dense);
 BA.debugLineNum = 515;BA.debugLine="Return Dense";
Debug.ShouldStop(4);
Debug.CheckDeviceExceptions();if (true) return _dense;
 BA.debugLineNum = 516;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable(0f);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getmapvalueordefault(RemoteObject _m,RemoteObject _key,RemoteObject _defaultvalue) throws Exception{
try {
		Debug.PushSubsStack("GetMapValueOrDefault (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,421);
if (RapidSub.canDelegate("getmapvalueordefault")) { return b4a.example.main.remoteMe.runUserSub(false, "main","getmapvalueordefault", _m, _key, _defaultvalue);}
Debug.locals.put("m", _m);
Debug.locals.put("Key", _key);
Debug.locals.put("DefaultValue", _defaultvalue);
 BA.debugLineNum = 421;BA.debugLine="Sub GetMapValueOrDefault(m As Map, Key As String,";
Debug.ShouldStop(16);
 BA.debugLineNum = 422;BA.debugLine="If m.ContainsKey(Key) Then";
Debug.ShouldStop(32);
if (_m.runMethod(true,"ContainsKey",(Object)((_key))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 423;BA.debugLine="Return m.Get(Key)";
Debug.ShouldStop(64);
Debug.CheckDeviceExceptions();if (true) return _m.runMethod(false,"Get",(Object)((_key)));
 }else {
 BA.debugLineNum = 425;BA.debugLine="Return DefaultValue";
Debug.ShouldStop(256);
Debug.CheckDeviceExceptions();if (true) return _defaultvalue;
 };
 BA.debugLineNum = 427;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 25;BA.debugLine="Private ScrollView1 As ScrollView";
main.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Dim PHPURL As String = \"https://192.168.8.117/Com";
main.mostCurrent._phpurl = BA.ObjectToString("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page=1");
 //BA.debugLineNum = 28;BA.debugLine="Dim TableDetails As List";
main.mostCurrent._tabledetails = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 30;BA.debugLine="Private Button1 As Button";
main.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private navigate As Label";
main.mostCurrent._navigate = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Dim primaryFontSize As Int = 1.4%y";
main._primaryfontsize = main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1.4)),main.mostCurrent.activityBA);
 //BA.debugLineNum = 33;BA.debugLine="Dim secondaryFontSize As Int = 1%y";
main._secondaryfontsize = main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1)),main.mostCurrent.activityBA);
 //BA.debugLineNum = 34;BA.debugLine="Private Panel1 As Panel";
main.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private Label1 As Label";
main.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private Panel2 As Panel";
main.mostCurrent._panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Dim barGraph As barGraph";
main.mostCurrent._bargraph = RemoteObject.createNew ("b4a.example.bargraph");
 //BA.debugLineNum = 38;BA.debugLine="Dim barGraph1 As barGraph";
main.mostCurrent._bargraph1 = RemoteObject.createNew ("b4a.example.bargraph");
 //BA.debugLineNum = 39;BA.debugLine="Dim purchasePanel As Panel";
main.mostCurrent._purchasepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Dim barPanel As Panel";
main.mostCurrent._barpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Dim activityPanel As Panel";
main.mostCurrent._activitypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Dim saleNxtBtn As Button";
main.mostCurrent._salenxtbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Dim saleBackBtn As Button";
main.mostCurrent._salebackbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Dim purchNxtBtn As Button";
main.mostCurrent._purchnxtbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Dim purchBackBtn As Button";
main.mostCurrent._purchbackbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Dim sortBtn1 As RadioButton";
main.mostCurrent._sortbtn1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Public defBtn As RadioButton";
main.mostCurrent._defbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Public sortBtn2 As RadioButton";
main.mostCurrent._sortbtn2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Public sales1btn As RadioButton";
main.mostCurrent._sales1btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Public sales2btn As RadioButton";
main.mostCurrent._sales2btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Public sales3btn As RadioButton";
main.mostCurrent._sales3btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Public legend() As String = Array As String(\"Sale";
main.mostCurrent._legend = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Sales1"),BA.ObjectToString("Sales2"),RemoteObject.createImmutable("Sales3")});
 //BA.debugLineNum = 53;BA.debugLine="Dim height As Int = 0";
main._height = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 54;BA.debugLine="Dim companyPanel As Panel";
main.mostCurrent._companypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Dim totalGraphDataHeight As Int = 0";
main._totalgraphdataheight = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 56;BA.debugLine="Dim totalGetDataHeight As Int = 0";
main._totalgetdataheight = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 57;BA.debugLine="Dim sortDefaultValue As String = \"\"";
main.mostCurrent._sortdefaultvalue = BA.ObjectToString("");
 //BA.debugLineNum = 58;BA.debugLine="Dim salesData1 As Int = 1";
main._salesdata1 = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 59;BA.debugLine="Dim currentPage As Int = 1";
main._currentpage = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 60;BA.debugLine="Dim barGraphInitialized As Boolean = False";
main._bargraphinitialized = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 61;BA.debugLine="Dim PHPURLCompany As String = $\"https://192.168.8";
main.mostCurrent._phpurlcompany = (RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._currentpage))),RemoteObject.createImmutable("&company_sales="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._salesdata1))),RemoteObject.createImmutable("&company_type="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable("")));
 //BA.debugLineNum = 62;BA.debugLine="Dim calculatedSize As Float = 0";
main._calculatedsize = BA.numberCast(float.class, 0);
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,116);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.main.remoteMe.runUserSub(false, "main","jobdone", _job);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _scrollheight = RemoteObject.createImmutable(0);
RemoteObject _salesarray = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _padding = RemoteObject.createImmutable(0);
RemoteObject _count = RemoteObject.createImmutable(0);
RemoteObject _rownum = RemoteObject.createImmutable(0);
RemoteObject _mainpanelwidth = RemoteObject.createImmutable(0);
RemoteObject _panelheight = RemoteObject.createImmutable(0);
RemoteObject _record = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _col = RemoteObject.createImmutable(0);
RemoteObject _row = RemoteObject.createImmutable(0);
RemoteObject _name = RemoteObject.createImmutable("");
RemoteObject _company_id = RemoteObject.createImmutable(0);
RemoteObject _total_count = RemoteObject.createImmutable(0);
RemoteObject _total_pos = RemoteObject.createImmutable(0);
RemoteObject _dashpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _myimage = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _imgview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _dashlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _panel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _paneltitle = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _label17 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _resizedimage = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _panelwidth = RemoteObject.createImmutable(0);
RemoteObject _labelheight = RemoteObject.createImmutable(0);
RemoteObject _totalstore = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalstorelabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalpos = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalposlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _totalcompanies = RemoteObject.createImmutable(0);
RemoteObject _sales = null;
RemoteObject _comid = null;
RemoteObject _sales1 = null;
RemoteObject _sales2 = null;
RemoteObject _purchase = null;
RemoteObject _purchase1 = null;
RemoteObject _purchase2 = null;
RemoteObject _companyname = null;
RemoteObject _max_value = null;
RemoteObject _maxsale = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _totalsalepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _totalsalelabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalpurchasepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _totalpurchaselabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _shadowpurchpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
Debug.locals.put("job", _job);
 BA.debugLineNum = 116;BA.debugLine="Sub JobDone(job As HttpJob)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 117;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 118;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 119;BA.debugLine="Try";
Debug.ShouldStop(4194304);
try { BA.debugLineNum = 121;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(16777216);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 122;BA.debugLine="parser.Initialize(job.GetString)";
Debug.ShouldStop(33554432);
_parser.runVoidMethod ("Initialize",(Object)(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ )));
 BA.debugLineNum = 125;BA.debugLine="Select Case job.JobName";
Debug.ShouldStop(268435456);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("GetData"),BA.ObjectToString("GetCompany"),BA.ObjectToString("UpdateData"))) {
case 0: {
 BA.debugLineNum = 127;BA.debugLine="Dim scrollHeight As Int = 0";
Debug.ShouldStop(1073741824);
_scrollheight = BA.numberCast(int.class, 0);Debug.locals.put("scrollHeight", _scrollheight);Debug.locals.put("scrollHeight", _scrollheight);
 BA.debugLineNum = 128;BA.debugLine="Dim salesArray As List = parser.NextArray";
Debug.ShouldStop(-2147483648);
_salesarray = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_salesarray = _parser.runMethod(false,"NextArray");Debug.locals.put("salesArray", _salesarray);Debug.locals.put("salesArray", _salesarray);
 BA.debugLineNum = 129;BA.debugLine="If salesArray.Size = 0 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_salesarray.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 130;BA.debugLine="ToastMessageShow(\"No data received\", True)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No data received")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 131;BA.debugLine="Return";
Debug.ShouldStop(4);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 133;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(16);
_padding = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 134;BA.debugLine="Dim count As Int = 0 ' Track panel count";
Debug.ShouldStop(32);
_count = BA.numberCast(int.class, 0);Debug.locals.put("count", _count);Debug.locals.put("count", _count);
 BA.debugLineNum = 135;BA.debugLine="Dim rowNum As Int = 3";
Debug.ShouldStop(64);
_rownum = BA.numberCast(int.class, 3);Debug.locals.put("rowNum", _rownum);Debug.locals.put("rowNum", _rownum);
 BA.debugLineNum = 136;BA.debugLine="Dim mainPanelWidth As Int = 0";
Debug.ShouldStop(128);
_mainpanelwidth = BA.numberCast(int.class, 0);Debug.locals.put("mainPanelWidth", _mainpanelwidth);Debug.locals.put("mainPanelWidth", _mainpanelwidth);
 BA.debugLineNum = 137;BA.debugLine="Dim panelHeight As Int = 150dip ' Adjust heig";
Debug.ShouldStop(256);
_panelheight = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)));Debug.locals.put("panelHeight", _panelheight);Debug.locals.put("panelHeight", _panelheight);
 BA.debugLineNum = 138;BA.debugLine="height = panelHeight - 70dip";
Debug.ShouldStop(512);
main._height = RemoteObject.solve(new RemoteObject[] {_panelheight,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))}, "-",1, 1);
 BA.debugLineNum = 140;BA.debugLine="For Each record As Map In salesArray";
Debug.ShouldStop(2048);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group20 = _salesarray;
final int groupLen20 = group20.runMethod(true,"getSize").<Integer>get()
;int index20 = 0;
;
for (; index20 < groupLen20;index20++){
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group20.runMethod(false,"Get",index20));Debug.locals.put("record", _record);
Debug.locals.put("record", _record);
 BA.debugLineNum = 141;BA.debugLine="If count Mod 3 = 0 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {_count,RemoteObject.createImmutable(3)}, "%",0, 1),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 142;BA.debugLine="height = height + panelHeight";
Debug.ShouldStop(8192);
main._height = RemoteObject.solve(new RemoteObject[] {main._height,_panelheight}, "+",1, 1);
 };
 BA.debugLineNum = 144;BA.debugLine="Dim col As Int = count Mod 3  ' Column posit";
Debug.ShouldStop(32768);
_col = RemoteObject.solve(new RemoteObject[] {_count,RemoteObject.createImmutable(3)}, "%",0, 1);Debug.locals.put("col", _col);Debug.locals.put("col", _col);
 BA.debugLineNum = 145;BA.debugLine="Dim row As Int = Floor(count / 3)";
Debug.ShouldStop(65536);
_row = BA.numberCast(int.class, main.mostCurrent.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {_count,RemoteObject.createImmutable(3)}, "/",0, 0))));Debug.locals.put("row", _row);Debug.locals.put("row", _row);
 BA.debugLineNum = 146;BA.debugLine="Dim name As String = record.Get(\"company_nam";
Debug.ShouldStop(131072);
_name = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("company_name")))));Debug.locals.put("name", _name);Debug.locals.put("name", _name);
 BA.debugLineNum = 147;BA.debugLine="Dim company_id As Int = record.Get(\"company_";
Debug.ShouldStop(262144);
_company_id = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("company_id")))));Debug.locals.put("company_id", _company_id);Debug.locals.put("company_id", _company_id);
 BA.debugLineNum = 148;BA.debugLine="Dim total_count As Int = record.Get(\"total_c";
Debug.ShouldStop(524288);
_total_count = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("total_count")))));Debug.locals.put("total_count", _total_count);Debug.locals.put("total_count", _total_count);
 BA.debugLineNum = 149;BA.debugLine="Dim total_pos As Int = record.Get(\"totalDevi";
Debug.ShouldStop(1048576);
_total_pos = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("totalDevices")))));Debug.locals.put("total_pos", _total_pos);Debug.locals.put("total_pos", _total_pos);
 BA.debugLineNum = 150;BA.debugLine="Dim dashPanel As Panel";
Debug.ShouldStop(2097152);
_dashpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("dashPanel", _dashpanel);
 BA.debugLineNum = 151;BA.debugLine="dashPanel.Initialize(\"\")";
Debug.ShouldStop(4194304);
_dashpanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 152;BA.debugLine="ScrollView1.Panel.AddView(dashPanel, 5dip, P";
Debug.ShouldStop(8388608);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_dashpanel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(main.mostCurrent._panel2.runMethod(true,"getHeight")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 155;BA.debugLine="Dim myImage As Bitmap";
Debug.ShouldStop(67108864);
_myimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 156;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"dashbo";
Debug.ShouldStop(134217728);
_myimage = main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("dashboard.png")));Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 158;BA.debugLine="Dim imgView As ImageView";
Debug.ShouldStop(536870912);
_imgview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("imgView", _imgview);
 BA.debugLineNum = 159;BA.debugLine="imgView.Initialize(\"\")";
Debug.ShouldStop(1073741824);
_imgview.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 160;BA.debugLine="imgView.Gravity = Gravity.FILL";
Debug.ShouldStop(-2147483648);
_imgview.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 161;BA.debugLine="imgView.Bitmap = myImage";
Debug.ShouldStop(1);
_imgview.runMethod(false,"setBitmap",(_myimage.getObject()));
 BA.debugLineNum = 162;BA.debugLine="dashPanel.AddView(imgView, 0dip, 12.5dip, 15";
Debug.ShouldStop(2);
_dashpanel.runVoidMethod ("AddView",(Object)((_imgview.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12.5)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))),(Object)(RemoteObject.solve(new RemoteObject[] {_dashpanel.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))}, "-",1, 1)));
 BA.debugLineNum = 164;BA.debugLine="Dim dashLabel As Label";
Debug.ShouldStop(8);
_dashlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("dashLabel", _dashlabel);
 BA.debugLineNum = 165;BA.debugLine="dashLabel.Initialize(\"\")";
Debug.ShouldStop(16);
_dashlabel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 166;BA.debugLine="dashLabel.Text = \"Dashboard\"";
Debug.ShouldStop(32);
_dashlabel.runMethod(true,"setText",BA.ObjectToCharSequence("Dashboard"));
 BA.debugLineNum = 167;BA.debugLine="dashLabel.TextColor = Colors.ARGB(50,156,0,0";
Debug.ShouldStop(64);
_dashlabel.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 156)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 168;BA.debugLine="dashLabel.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(128);
_dashlabel.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 169;BA.debugLine="dashLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(256);
_dashlabel.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 170;BA.debugLine="dashPanel.AddView(dashLabel, imgView.Width+5";
Debug.ShouldStop(512);
_dashpanel.runVoidMethod ("AddView",(Object)((_dashlabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_imgview.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "+",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(_dashpanel.runMethod(true,"getWidth")),(Object)(_dashpanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 171;BA.debugLine="calculatedSize = AdjustFontSizeToHeight(dash";
Debug.ShouldStop(1024);
main._calculatedsize = _adjustfontsizetoheight(_dashlabel,BA.numberCast(float.class, 2));
 BA.debugLineNum = 172;BA.debugLine="dashLabel.TextSize = calculatedSize";
Debug.ShouldStop(2048);
_dashlabel.runMethod(true,"setTextSize",main._calculatedsize);
 BA.debugLineNum = 175;BA.debugLine="companyPanel.Initialize(\"Panel\")";
Debug.ShouldStop(16384);
main.mostCurrent._companypanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel")));
 BA.debugLineNum = 176;BA.debugLine="ScrollView1.Panel.AddView(companyPanel, 5dip";
Debug.ShouldStop(32768);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((main.mostCurrent._companypanel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(_dashpanel.runMethod(true,"getHeight")),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1)),(Object)(main._height));
 BA.debugLineNum = 179;BA.debugLine="mainPanelWidth = companyPanel.Width / rowNum";
Debug.ShouldStop(262144);
_mainpanelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._companypanel.runMethod(true,"getWidth"),_rownum}, "/",0, 0));Debug.locals.put("mainPanelWidth", _mainpanelwidth);
 BA.debugLineNum = 180;BA.debugLine="Dim Panel As Panel";
Debug.ShouldStop(524288);
_panel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("Panel", _panel);
 BA.debugLineNum = 181;BA.debugLine="Panel.Initialize(\"\")";
Debug.ShouldStop(1048576);
_panel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 182;BA.debugLine="companyPanel.AddView(Panel, col * (mainPanel";
Debug.ShouldStop(2097152);
main.mostCurrent._companypanel.runVoidMethod ("AddView",(Object)((_panel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_col,(RemoteObject.solve(new RemoteObject[] {_mainpanelwidth,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "+",1, 1))}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._panel2.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {_row,(RemoteObject.solve(new RemoteObject[] {_panelheight,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "+",1, 1))}, "*",0, 1))}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_mainpanelwidth,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1)),(Object)(_panelheight));
 BA.debugLineNum = 184;BA.debugLine="Dim PanelTitle As Panel";
Debug.ShouldStop(8388608);
_paneltitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("PanelTitle", _paneltitle);
 BA.debugLineNum = 185;BA.debugLine="PanelTitle.Initialize(\"Panel2\")";
Debug.ShouldStop(16777216);
_paneltitle.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel2")));
 BA.debugLineNum = 186;BA.debugLine="PanelTitle.Color = Colors.Black";
Debug.ShouldStop(33554432);
_paneltitle.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 187;BA.debugLine="PanelTitle.Tag = name";
Debug.ShouldStop(67108864);
_paneltitle.runMethod(false,"setTag",(_name));
 BA.debugLineNum = 188;BA.debugLine="Panel.AddView(PanelTitle, 0, 0, Panel.Width,";
Debug.ShouldStop(134217728);
_panel.runVoidMethod ("AddView",(Object)((_paneltitle.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_panel.runMethod(true,"getWidth")),(Object)(RemoteObject.solve(new RemoteObject[] {_panelheight,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))}, "-",1, 1)));
 BA.debugLineNum = 191;BA.debugLine="Dim Label17 As Label";
Debug.ShouldStop(1073741824);
_label17 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Label17", _label17);
 BA.debugLineNum = 192;BA.debugLine="Label17.Initialize(\"Label17\")";
Debug.ShouldStop(-2147483648);
_label17.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Label17")));
 BA.debugLineNum = 193;BA.debugLine="Label17.Text = name.ToUpperCase";
Debug.ShouldStop(1);
_label17.runMethod(true,"setText",BA.ObjectToCharSequence(_name.runMethod(true,"toUpperCase")));
 BA.debugLineNum = 194;BA.debugLine="Label17.Tag = company_id";
Debug.ShouldStop(2);
_label17.runMethod(false,"setTag",(_company_id));
 BA.debugLineNum = 195;BA.debugLine="Label17.TextSize = 18";
Debug.ShouldStop(4);
_label17.runMethod(true,"setTextSize",BA.numberCast(float.class, 18));
 BA.debugLineNum = 196;BA.debugLine="Label17.TextColor = Colors.White";
Debug.ShouldStop(8);
_label17.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 197;BA.debugLine="Label17.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(16);
_label17.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 198;BA.debugLine="Label17.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(32);
_label17.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 199;BA.debugLine="PanelTitle.AddView(Label17, 5dip, 0dip, Pane";
Debug.ShouldStop(64);
_paneltitle.runVoidMethod ("AddView",(Object)((_label17.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(_paneltitle.runMethod(true,"getWidth")),(Object)(_paneltitle.runMethod(true,"getHeight")));
 BA.debugLineNum = 202;BA.debugLine="Dim myImage As Bitmap";
Debug.ShouldStop(512);
_myimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 203;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"arrow";
Debug.ShouldStop(1024);
_myimage = main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("arrows-removebg-preview.png")));Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 204;BA.debugLine="If myImage.IsInitialized Then";
Debug.ShouldStop(2048);
if (_myimage.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 205;BA.debugLine="Dim resizedImage As Bitmap = myImage.Resiz";
Debug.ShouldStop(4096);
_resizedimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_resizedimage = _myimage.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 4.5)),main.mostCurrent.activityBA))))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_myimage.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 2)),main.mostCurrent.activityBA))),_myimage.runMethod(true,"getWidth")}, "*/",0, 0))),(Object)(main.mostCurrent.__c.getField(true,"True")));Debug.locals.put("resizedImage", _resizedimage);Debug.locals.put("resizedImage", _resizedimage);
 BA.debugLineNum = 206;BA.debugLine="Dim imgView As ImageView";
Debug.ShouldStop(8192);
_imgview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("imgView", _imgview);
 BA.debugLineNum = 207;BA.debugLine="imgView.Initialize(\"\")";
Debug.ShouldStop(16384);
_imgview.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 208;BA.debugLine="imgView.Gravity = Gravity.FILL";
Debug.ShouldStop(32768);
_imgview.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 209;BA.debugLine="imgView.Bitmap = myImage";
Debug.ShouldStop(65536);
_imgview.runMethod(false,"setBitmap",(_myimage.getObject()));
 BA.debugLineNum = 210;BA.debugLine="PanelTitle.AddView(imgView, PanelTitle.Wid";
Debug.ShouldStop(131072);
_paneltitle.runVoidMethod ("AddView",(Object)((_imgview.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_paneltitle.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),main.mostCurrent.activityBA)}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),main.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_paneltitle.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1)));
 }else {
 BA.debugLineNum = 212;BA.debugLine="Log(\"Error loading image\")";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5327776",RemoteObject.createImmutable("Error loading image"),0);
 };
 BA.debugLineNum = 215;BA.debugLine="Dim panelWidth As Int = Panel.Width /3";
Debug.ShouldStop(4194304);
_panelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(3)}, "/",0, 0));Debug.locals.put("panelWidth", _panelwidth);Debug.locals.put("panelWidth", _panelwidth);
 BA.debugLineNum = 216;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(8388608);
_padding = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 217;BA.debugLine="Dim labelheight As Int = panelHeight - Panel";
Debug.ShouldStop(16777216);
_labelheight = RemoteObject.solve(new RemoteObject[] {_panelheight,_paneltitle.runMethod(true,"getHeight")}, "-",1, 1);Debug.locals.put("labelheight", _labelheight);Debug.locals.put("labelheight", _labelheight);
 BA.debugLineNum = 218;BA.debugLine="panelWidth = Panel.Width /2";
Debug.ShouldStop(33554432);
_panelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("panelWidth", _panelwidth);
 BA.debugLineNum = 220;BA.debugLine="Dim totalStore As Label";
Debug.ShouldStop(134217728);
_totalstore = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalStore", _totalstore);
 BA.debugLineNum = 221;BA.debugLine="totalStore.Initialize(\"\")";
Debug.ShouldStop(268435456);
_totalstore.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 222;BA.debugLine="totalStore.Text = total_count";
Debug.ShouldStop(536870912);
_totalstore.runMethod(true,"setText",BA.ObjectToCharSequence(_total_count));
 BA.debugLineNum = 223;BA.debugLine="totalStore.TextColor = Colors.Black";
Debug.ShouldStop(1073741824);
_totalstore.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 224;BA.debugLine="totalStore.TextSize = primaryFontSize";
Debug.ShouldStop(-2147483648);
_totalstore.runMethod(true,"setTextSize",BA.numberCast(float.class, main._primaryfontsize));
 BA.debugLineNum = 225;BA.debugLine="totalStore.Gravity = Gravity.CENTER";
Debug.ShouldStop(1);
_totalstore.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 226;BA.debugLine="totalStore.Typeface = Typeface.SERIF";
Debug.ShouldStop(2);
_totalstore.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 227;BA.debugLine="Panel.AddView(totalStore,0,PanelTitle.Height";
Debug.ShouldStop(4);
_panel.runVoidMethod ("AddView",(Object)((_totalstore.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_paneltitle.runMethod(true,"getHeight")),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_labelheight,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "-",1, 1)));
 BA.debugLineNum = 230;BA.debugLine="Dim totalStoreLabel As Label";
Debug.ShouldStop(32);
_totalstorelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalStoreLabel", _totalstorelabel);
 BA.debugLineNum = 231;BA.debugLine="totalStoreLabel.Initialize(\"\")";
Debug.ShouldStop(64);
_totalstorelabel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 232;BA.debugLine="totalStoreLabel.Text = \" Total Store\"";
Debug.ShouldStop(128);
_totalstorelabel.runMethod(true,"setText",BA.ObjectToCharSequence(" Total Store"));
 BA.debugLineNum = 233;BA.debugLine="totalStoreLabel.TextColor = Colors.Gray";
Debug.ShouldStop(256);
_totalstorelabel.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 234;BA.debugLine="totalStoreLabel.TextSize = secondaryFontSize";
Debug.ShouldStop(512);
_totalstorelabel.runMethod(true,"setTextSize",BA.numberCast(float.class, main._secondaryfontsize));
 BA.debugLineNum = 235;BA.debugLine="totalStoreLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(1024);
_totalstorelabel.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 236;BA.debugLine="totalStoreLabel.Typeface = Typeface.MONOSPAC";
Debug.ShouldStop(2048);
_totalstorelabel.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 237;BA.debugLine="totalStoreLabel.Text = totalStoreLabel.Text.";
Debug.ShouldStop(4096);
_totalstorelabel.runMethod(true,"setText",BA.ObjectToCharSequence(_totalstorelabel.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 238;BA.debugLine="Panel.AddView(totalStoreLabel,0,totalStore.t";
Debug.ShouldStop(8192);
_panel.runVoidMethod ("AddView",(Object)((_totalstorelabel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_totalstore.runMethod(true,"getTop"),_padding,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 240;BA.debugLine="Dim totalPos As Label";
Debug.ShouldStop(32768);
_totalpos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalPos", _totalpos);
 BA.debugLineNum = 241;BA.debugLine="totalPos.Initialize(\"\")";
Debug.ShouldStop(65536);
_totalpos.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 242;BA.debugLine="totalPos.Text = total_pos";
Debug.ShouldStop(131072);
_totalpos.runMethod(true,"setText",BA.ObjectToCharSequence(_total_pos));
 BA.debugLineNum = 243;BA.debugLine="totalPos.TextColor = Colors.Black";
Debug.ShouldStop(262144);
_totalpos.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 244;BA.debugLine="totalPos.TextSize = primaryFontSize";
Debug.ShouldStop(524288);
_totalpos.runMethod(true,"setTextSize",BA.numberCast(float.class, main._primaryfontsize));
 BA.debugLineNum = 245;BA.debugLine="totalPos.Gravity = Gravity.CENTER";
Debug.ShouldStop(1048576);
_totalpos.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 246;BA.debugLine="totalPos.Typeface = Typeface.SERIF";
Debug.ShouldStop(2097152);
_totalpos.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 247;BA.debugLine="Panel.AddView(totalPos,panelWidth,PanelTitle";
Debug.ShouldStop(4194304);
_panel.runVoidMethod ("AddView",(Object)((_totalpos.getObject())),(Object)(_panelwidth),(Object)(_paneltitle.runMethod(true,"getHeight")),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_labelheight,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "-",1, 1)));
 BA.debugLineNum = 250;BA.debugLine="Dim totalPosLabel As Label";
Debug.ShouldStop(33554432);
_totalposlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalPosLabel", _totalposlabel);
 BA.debugLineNum = 251;BA.debugLine="totalPosLabel.Initialize(\"\")";
Debug.ShouldStop(67108864);
_totalposlabel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 252;BA.debugLine="totalPosLabel.Text = \" Total Pos\"";
Debug.ShouldStop(134217728);
_totalposlabel.runMethod(true,"setText",BA.ObjectToCharSequence(" Total Pos"));
 BA.debugLineNum = 253;BA.debugLine="totalPosLabel.TextColor = Colors.Gray";
Debug.ShouldStop(268435456);
_totalposlabel.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 254;BA.debugLine="totalPosLabel.TextSize = secondaryFontSize";
Debug.ShouldStop(536870912);
_totalposlabel.runMethod(true,"setTextSize",BA.numberCast(float.class, main._secondaryfontsize));
 BA.debugLineNum = 255;BA.debugLine="totalPosLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(1073741824);
_totalposlabel.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 256;BA.debugLine="totalPosLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(-2147483648);
_totalposlabel.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 257;BA.debugLine="totalPosLabel.Text = totalPosLabel.Text.ToUp";
Debug.ShouldStop(1);
_totalposlabel.runMethod(true,"setText",BA.ObjectToCharSequence(_totalposlabel.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 258;BA.debugLine="Panel.AddView(totalPosLabel,panelWidth,total";
Debug.ShouldStop(2);
_panel.runVoidMethod ("AddView",(Object)((_totalposlabel.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_totalpos.runMethod(true,"getTop"),_padding,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 261;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(16);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 262;BA.debugLine="cd.Initialize2(Colors.White, 0dip, 0dip, Col";
Debug.ShouldStop(32);
_cd.runVoidMethod ("Initialize2",(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 263;BA.debugLine="Panel.Background = cd";
Debug.ShouldStop(64);
_panel.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 264;BA.debugLine="count = count + 1";
Debug.ShouldStop(128);
_count = RemoteObject.solve(new RemoteObject[] {_count,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("count", _count);
 }
}Debug.locals.put("record", _record);
;
 BA.debugLineNum = 267;BA.debugLine="totalGetDataHeight = Panel2.Height+companyPan";
Debug.ShouldStop(1024);
main._totalgetdataheight = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._panel2.runMethod(true,"getHeight"),main.mostCurrent._companypanel.runMethod(true,"getHeight")}, "+",1, 1);
 break; }
case 1: {
 BA.debugLineNum = 269;BA.debugLine="Dim salesArray As List = parser.NextArray";
Debug.ShouldStop(4096);
_salesarray = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_salesarray = _parser.runMethod(false,"NextArray");Debug.locals.put("salesArray", _salesarray);Debug.locals.put("salesArray", _salesarray);
 BA.debugLineNum = 273;BA.debugLine="If salesArray.Size = 0 Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_salesarray.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 274;BA.debugLine="ToastMessageShow(\"No data received\", True)";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No data received")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 275;BA.debugLine="Return";
Debug.ShouldStop(262144);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 278;BA.debugLine="Dim totalCompanies As Int = salesArray.Size";
Debug.ShouldStop(2097152);
_totalcompanies = _salesarray.runMethod(true,"getSize");Debug.locals.put("totalCompanies", _totalcompanies);Debug.locals.put("totalCompanies", _totalcompanies);
 BA.debugLineNum = 279;BA.debugLine="Dim sales(totalCompanies) As Int";
Debug.ShouldStop(4194304);
_sales = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("sales", _sales);
 BA.debugLineNum = 280;BA.debugLine="Dim comId(totalCompanies) As Int";
Debug.ShouldStop(8388608);
_comid = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("comId", _comid);
 BA.debugLineNum = 281;BA.debugLine="Dim sales1(totalCompanies) As Int";
Debug.ShouldStop(16777216);
_sales1 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("sales1", _sales1);
 BA.debugLineNum = 282;BA.debugLine="Dim sales2(totalCompanies) As Int";
Debug.ShouldStop(33554432);
_sales2 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("sales2", _sales2);
 BA.debugLineNum = 283;BA.debugLine="Dim purchase(totalCompanies) As Int";
Debug.ShouldStop(67108864);
_purchase = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("purchase", _purchase);
 BA.debugLineNum = 284;BA.debugLine="Dim purchase1(totalCompanies) As Int";
Debug.ShouldStop(134217728);
_purchase1 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("purchase1", _purchase1);
 BA.debugLineNum = 285;BA.debugLine="Dim purchase2(totalCompanies) As Int";
Debug.ShouldStop(268435456);
_purchase2 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("purchase2", _purchase2);
 BA.debugLineNum = 286;BA.debugLine="Dim companyName(totalCompanies) As String";
Debug.ShouldStop(536870912);
_companyname = RemoteObject.createNewArray ("String", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("companyName", _companyname);
 BA.debugLineNum = 287;BA.debugLine="Dim max_value(totalCompanies) As Int";
Debug.ShouldStop(1073741824);
_max_value = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("max_value", _max_value);
 BA.debugLineNum = 288;BA.debugLine="Dim maxSale As Int=0";
Debug.ShouldStop(-2147483648);
_maxsale = BA.numberCast(int.class, 0);Debug.locals.put("maxSale", _maxsale);Debug.locals.put("maxSale", _maxsale);
 BA.debugLineNum = 290;BA.debugLine="For i = 0 To totalCompanies - 1";
Debug.ShouldStop(2);
{
final int step142 = 1;
final int limit142 = RemoteObject.solve(new RemoteObject[] {_totalcompanies,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step142 > 0 && _i <= limit142) || (step142 < 0 && _i >= limit142) ;_i = ((int)(0 + _i + step142))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 291;BA.debugLine="Dim record As Map = salesArray.Get(i)";
Debug.ShouldStop(4);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _salesarray.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("record", _record);Debug.locals.put("record", _record);
 BA.debugLineNum = 292;BA.debugLine="companyName(i) = record.GetDefault(\"company_";
Debug.ShouldStop(8);
_companyname.setArrayElement (BA.ObjectToString(_record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("company_name"))),(Object)((RemoteObject.createImmutable("Unknown"))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 293;BA.debugLine="comId(i) = record.GetDefault(\"comId\", 0)";
Debug.ShouldStop(16);
_comid.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("comId"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 294;BA.debugLine="sales(i) = record.GetDefault(\"sales_1\", 0)";
Debug.ShouldStop(32);
_sales.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_1"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 295;BA.debugLine="sales1(i) = record.GetDefault(\"sales_2\", 0)";
Debug.ShouldStop(64);
_sales1.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_2"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 296;BA.debugLine="sales2(i) = record.GetDefault(\"sales_3\", 0)";
Debug.ShouldStop(128);
_sales2.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_3"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 297;BA.debugLine="purchase(i) = record.GetDefault(\"purchase_1\"";
Debug.ShouldStop(256);
_purchase.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("purchase_1"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 298;BA.debugLine="purchase1(i) = record.GetDefault(\"purchase_2";
Debug.ShouldStop(512);
_purchase1.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("purchase_2"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 299;BA.debugLine="purchase2(i) = record.GetDefault(\"purchase_3";
Debug.ShouldStop(1024);
_purchase2.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("purchase_3"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 300;BA.debugLine="max_value(i) = record.GetDefault(\"max_sales\"";
Debug.ShouldStop(2048);
_max_value.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("max_sales"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 301;BA.debugLine="maxSale = Max(maxSale, max_value(i))";
Debug.ShouldStop(4096);
_maxsale = BA.numberCast(int.class, main.mostCurrent.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, _maxsale)),(Object)(BA.numberCast(double.class, _max_value.getArrayElement(true,BA.numberCast(int.class, _i))))));Debug.locals.put("maxSale", _maxsale);
 BA.debugLineNum = 302;BA.debugLine="Log(companyName(i) & sales(i))";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5327866",RemoteObject.concat(_companyname.getArrayElement(true,BA.numberCast(int.class, _i)),_sales.getArrayElement(true,BA.numberCast(int.class, _i))),0);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 305;BA.debugLine="Activity.Initialize(\"\")";
Debug.ShouldStop(65536);
main.mostCurrent._activity.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 307;BA.debugLine="Dim legend() As String = Array As String(\"Sal";
Debug.ShouldStop(262144);
main.mostCurrent._legend = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Sales1"),BA.ObjectToString("Sales2"),RemoteObject.createImmutable("Sales3")});
 BA.debugLineNum = 309;BA.debugLine="If barGraphInitialized = False Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",main._bargraphinitialized,main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 310;BA.debugLine="saleNxtBtn.Initialize(\"nxtBtn\")";
Debug.ShouldStop(2097152);
main.mostCurrent._salenxtbtn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("nxtBtn")));
 BA.debugLineNum = 311;BA.debugLine="saleBackBtn.Initialize(\"backbtn\")";
Debug.ShouldStop(4194304);
main.mostCurrent._salebackbtn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("backbtn")));
 BA.debugLineNum = 312;BA.debugLine="sortBtn1.Initialize(\"sortBtn1\")";
Debug.ShouldStop(8388608);
main.mostCurrent._sortbtn1.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sortBtn1")));
 BA.debugLineNum = 313;BA.debugLine="sortBtn2.Initialize(\"sortBtn2\")";
Debug.ShouldStop(16777216);
main.mostCurrent._sortbtn2.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sortBtn2")));
 BA.debugLineNum = 314;BA.debugLine="defBtn.Initialize(\"defBtn\")";
Debug.ShouldStop(33554432);
main.mostCurrent._defbtn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("defBtn")));
 BA.debugLineNum = 315;BA.debugLine="sales1btn.Initialize(\"sales1btn\")";
Debug.ShouldStop(67108864);
main.mostCurrent._sales1btn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sales1btn")));
 BA.debugLineNum = 316;BA.debugLine="sales2btn.Initialize(\"sales2btn\")";
Debug.ShouldStop(134217728);
main.mostCurrent._sales2btn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sales2btn")));
 BA.debugLineNum = 317;BA.debugLine="sales3btn.Initialize(\"sales3btn\")";
Debug.ShouldStop(268435456);
main.mostCurrent._sales3btn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sales3btn")));
 BA.debugLineNum = 318;BA.debugLine="Dim totalSalePanel As Panel";
Debug.ShouldStop(536870912);
_totalsalepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("totalSalePanel", _totalsalepanel);
 BA.debugLineNum = 319;BA.debugLine="totalSalePanel.Initialize(\"\")";
Debug.ShouldStop(1073741824);
_totalsalepanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 320;BA.debugLine="ScrollView1.Panel.AddView(totalSalePanel,5di";
Debug.ShouldStop(-2147483648);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_totalsalepanel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._panel2.runMethod(true,"getHeight"),main.mostCurrent._companypanel.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 28)))}, "+-",2, 1)),(Object)(main.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 322;BA.debugLine="Dim myImage As Bitmap";
Debug.ShouldStop(2);
_myimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 323;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"stock.";
Debug.ShouldStop(4);
_myimage = main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("stock.png")));Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 325;BA.debugLine="Dim imgView As ImageView";
Debug.ShouldStop(16);
_imgview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("imgView", _imgview);
 BA.debugLineNum = 326;BA.debugLine="imgView.Initialize(\"\")";
Debug.ShouldStop(32);
_imgview.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 327;BA.debugLine="imgView.Gravity = Gravity.FILL";
Debug.ShouldStop(64);
_imgview.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 328;BA.debugLine="imgView.Bitmap = myImage";
Debug.ShouldStop(128);
_imgview.runMethod(false,"setBitmap",(_myimage.getObject()));
 BA.debugLineNum = 329;BA.debugLine="imgView.Bitmap = myImage";
Debug.ShouldStop(256);
_imgview.runMethod(false,"setBitmap",(_myimage.getObject()));
 BA.debugLineNum = 330;BA.debugLine="totalSalePanel.AddView(imgView, 0dip, 12.5di";
Debug.ShouldStop(512);
_totalsalepanel.runVoidMethod ("AddView",(Object)((_imgview.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12.5)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))),(Object)(RemoteObject.solve(new RemoteObject[] {_totalsalepanel.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))}, "-",1, 1)));
 BA.debugLineNum = 332;BA.debugLine="Dim totalSaleLabel As Label";
Debug.ShouldStop(2048);
_totalsalelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalSaleLabel", _totalsalelabel);
 BA.debugLineNum = 333;BA.debugLine="totalSaleLabel.Initialize(\"\")";
Debug.ShouldStop(4096);
_totalsalelabel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 334;BA.debugLine="totalSaleLabel.Text = \"Total Sales\"";
Debug.ShouldStop(8192);
_totalsalelabel.runMethod(true,"setText",BA.ObjectToCharSequence("Total Sales"));
 BA.debugLineNum = 335;BA.debugLine="totalSaleLabel.TextColor = Colors.Black";
Debug.ShouldStop(16384);
_totalsalelabel.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 336;BA.debugLine="totalSaleLabel.Gravity = Gravity.CENTER_VERT";
Debug.ShouldStop(32768);
_totalsalelabel.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 337;BA.debugLine="totalSaleLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(65536);
_totalsalelabel.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 338;BA.debugLine="totalSalePanel.AddView(totalSaleLabel,imgVie";
Debug.ShouldStop(131072);
_totalsalepanel.runVoidMethod ("AddView",(Object)((_totalsalelabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_imgview.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "+",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 339;BA.debugLine="AdjustFontSizeToHeight(totalSaleLabel,2)";
Debug.ShouldStop(262144);
_adjustfontsizetoheight(_totalsalelabel,BA.numberCast(float.class, 2));
 BA.debugLineNum = 341;BA.debugLine="ScrollView1.Panel.AddView(barPanel,25dip,tot";
Debug.ShouldStop(1048576);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((main.mostCurrent._barpanel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(RemoteObject.solve(new RemoteObject[] {_totalsalelabel.runMethod(true,"getHeight"),main.mostCurrent._panel2.runMethod(true,"getHeight"),main.mostCurrent._companypanel.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "++-",3, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 450)))));
 BA.debugLineNum = 342;BA.debugLine="barPanel.Color = Colors.White";
Debug.ShouldStop(2097152);
main.mostCurrent._barpanel.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 344;BA.debugLine="barPanel.RemoveAllViews";
Debug.ShouldStop(8388608);
main.mostCurrent._barpanel.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 345;BA.debugLine="barPanel.Invalidate ' Force a redraw";
Debug.ShouldStop(16777216);
main.mostCurrent._barpanel.runVoidMethod ("Invalidate");
 BA.debugLineNum = 348;BA.debugLine="barGraph.Initialize(Activity,barPanel,sales,";
Debug.ShouldStop(134217728);
main.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_initialize" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._activity),(Object)(main.mostCurrent._barpanel),(Object)(_sales),(Object)(_sales1),(Object)(_sales2),(Object)(_companyname),(Object)(main.mostCurrent._legend),(Object)(_maxsale),(Object)(BA.ObjectToString("Total Sale of the Company")),(Object)(_comid),(Object)(BA.ObjectToString("Branch")),(Object)(main.mostCurrent._salenxtbtn),(Object)(main.mostCurrent._salebackbtn),(Object)(main.mostCurrent._sortbtn1),(Object)(main.mostCurrent._sortbtn2),(Object)(main.mostCurrent._defbtn),(Object)(main.mostCurrent._sales1btn),(Object)(main.mostCurrent._sales2btn),(Object)(main.mostCurrent._sales3btn));
 BA.debugLineNum = 349;BA.debugLine="legend = Array As String(\"Purchase1\",\"Purcha";
Debug.ShouldStop(268435456);
main.mostCurrent._legend = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Purchase1"),BA.ObjectToString("Purchase2"),RemoteObject.createImmutable("Purchase3")});
 BA.debugLineNum = 350;BA.debugLine="barGraphInitialized = True";
Debug.ShouldStop(536870912);
main._bargraphinitialized = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 351;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 }else {
 BA.debugLineNum = 353;BA.debugLine="barGraph.sale_1 = sales";
Debug.ShouldStop(1);
main.mostCurrent._bargraph.setField ("_sale_1" /*RemoteObject*/ ,_sales);
 BA.debugLineNum = 354;BA.debugLine="barGraph.sale_2 = sales1";
Debug.ShouldStop(2);
main.mostCurrent._bargraph.setField ("_sale_2" /*RemoteObject*/ ,_sales1);
 BA.debugLineNum = 355;BA.debugLine="barGraph.sale_3 = sales2";
Debug.ShouldStop(4);
main.mostCurrent._bargraph.setField ("_sale_3" /*RemoteObject*/ ,_sales2);
 BA.debugLineNum = 356;BA.debugLine="barGraph.product1 = companyName";
Debug.ShouldStop(8);
main.mostCurrent._bargraph.setField ("_product1" /*RemoteObject*/ ,_companyname);
 BA.debugLineNum = 357;BA.debugLine="barGraph.comId1 = sales ' Assuming comId1 sh";
Debug.ShouldStop(16);
main.mostCurrent._bargraph.setField ("_comid1" /*RemoteObject*/ ,_sales);
 BA.debugLineNum = 358;BA.debugLine="barGraph.UpdateGraph";
Debug.ShouldStop(32);
main.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_updategraph" /*RemoteObject*/ );
 };
 BA.debugLineNum = 361;BA.debugLine="Dim totalPurchasePanel As Panel";
Debug.ShouldStop(256);
_totalpurchasepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("totalPurchasePanel", _totalpurchasepanel);
 BA.debugLineNum = 362;BA.debugLine="totalPurchasePanel.Initialize(\"\")";
Debug.ShouldStop(512);
_totalpurchasepanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 363;BA.debugLine="ScrollView1.Panel.AddView(totalPurchasePanel,";
Debug.ShouldStop(1024);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_totalpurchasepanel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._barpanel.runMethod(true,"getHeight"),main.mostCurrent._panel2.runMethod(true,"getHeight"),main.mostCurrent._companypanel.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))}, "+++",3, 1)),(Object)(main.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 365;BA.debugLine="Dim myImage As Bitmap";
Debug.ShouldStop(4096);
_myimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 366;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"stock.p";
Debug.ShouldStop(8192);
_myimage = main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("stock.png")));Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 368;BA.debugLine="Dim imgView As ImageView";
Debug.ShouldStop(32768);
_imgview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("imgView", _imgview);
 BA.debugLineNum = 369;BA.debugLine="imgView.Initialize(\"\")";
Debug.ShouldStop(65536);
_imgview.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 370;BA.debugLine="imgView.Gravity = Gravity.FILL";
Debug.ShouldStop(131072);
_imgview.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 371;BA.debugLine="imgView.Bitmap = myImage";
Debug.ShouldStop(262144);
_imgview.runMethod(false,"setBitmap",(_myimage.getObject()));
 BA.debugLineNum = 372;BA.debugLine="totalPurchasePanel.AddView(imgView, 0dip, 12.";
Debug.ShouldStop(524288);
_totalpurchasepanel.runVoidMethod ("AddView",(Object)((_imgview.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12.5)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))),(Object)(RemoteObject.solve(new RemoteObject[] {_totalpurchasepanel.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))}, "-",1, 1)));
 BA.debugLineNum = 374;BA.debugLine="Dim totalPurchaseLabel As Label";
Debug.ShouldStop(2097152);
_totalpurchaselabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalPurchaseLabel", _totalpurchaselabel);
 BA.debugLineNum = 375;BA.debugLine="totalPurchaseLabel.Initialize(\"\")";
Debug.ShouldStop(4194304);
_totalpurchaselabel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 376;BA.debugLine="totalPurchaseLabel.Text = \"Total Purchases\"";
Debug.ShouldStop(8388608);
_totalpurchaselabel.runMethod(true,"setText",BA.ObjectToCharSequence("Total Purchases"));
 BA.debugLineNum = 377;BA.debugLine="totalPurchaseLabel.TextColor =Colors.Black";
Debug.ShouldStop(16777216);
_totalpurchaselabel.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 378;BA.debugLine="totalPurchaseLabel.Gravity = Gravity.CENTER_V";
Debug.ShouldStop(33554432);
_totalpurchaselabel.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 379;BA.debugLine="totalPurchaseLabel.Typeface = Typeface.MONOSP";
Debug.ShouldStop(67108864);
_totalpurchaselabel.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 380;BA.debugLine="totalPurchasePanel.AddView(totalPurchaseLabel";
Debug.ShouldStop(134217728);
_totalpurchasepanel.runVoidMethod ("AddView",(Object)((_totalpurchaselabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_imgview.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "+",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(_totalpurchasepanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 383;BA.debugLine="Dim shadowPurchPanel As Panel";
Debug.ShouldStop(1073741824);
_shadowpurchpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("shadowPurchPanel", _shadowpurchpanel);
 BA.debugLineNum = 384;BA.debugLine="shadowPurchPanel.Initialize(\"\")";
Debug.ShouldStop(-2147483648);
_shadowpurchpanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 385;BA.debugLine="shadowPurchPanel.Color = Colors.ARGB(50, 138,";
Debug.ShouldStop(1);
_shadowpurchpanel.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 138)),(Object)(BA.numberCast(int.class, 138)),(Object)(BA.numberCast(int.class, 138))));
 BA.debugLineNum = 386;BA.debugLine="ScrollView1.Panel.AddView(shadowPurchPanel, 2";
Debug.ShouldStop(2);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_shadowpurchpanel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25))),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_totalsalelabel.runMethod(true,"getHeight"),main.mostCurrent._panel2.runMethod(true,"getHeight"),main.mostCurrent._companypanel.runMethod(true,"getHeight"),main.mostCurrent._barpanel.runMethod(true,"getHeight"),_totalpurchaselabel.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "++++-+",6, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 450)))));
 BA.debugLineNum = 388;BA.debugLine="purchasePanel.Initialize(\"\")";
Debug.ShouldStop(8);
main.mostCurrent._purchasepanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 389;BA.debugLine="purchasePanel.Color = Colors.White";
Debug.ShouldStop(16);
main.mostCurrent._purchasepanel.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 390;BA.debugLine="ScrollView1.Panel.AddView(purchasePanel,25dip";
Debug.ShouldStop(32);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((main.mostCurrent._purchasepanel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(RemoteObject.solve(new RemoteObject[] {_totalsalelabel.runMethod(true,"getHeight"),main.mostCurrent._panel2.runMethod(true,"getHeight"),main.mostCurrent._companypanel.runMethod(true,"getHeight"),main.mostCurrent._barpanel.runMethod(true,"getHeight"),_totalpurchaselabel.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "++++-",5, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 450)))));
 BA.debugLineNum = 391;BA.debugLine="purchNxtBtn.Initialize(\"\")";
Debug.ShouldStop(64);
main.mostCurrent._purchnxtbtn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 392;BA.debugLine="purchBackBtn.Initialize(\"\")";
Debug.ShouldStop(128);
main.mostCurrent._purchbackbtn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 393;BA.debugLine="sortBtn1.Initialize(\"sortBtn1\")";
Debug.ShouldStop(256);
main.mostCurrent._sortbtn1.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sortBtn1")));
 BA.debugLineNum = 394;BA.debugLine="sortBtn2.Initialize(\"sortBtn2\")";
Debug.ShouldStop(512);
main.mostCurrent._sortbtn2.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sortBtn2")));
 BA.debugLineNum = 395;BA.debugLine="defBtn.Initialize(\"defBtn\")";
Debug.ShouldStop(1024);
main.mostCurrent._defbtn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("defBtn")));
 BA.debugLineNum = 396;BA.debugLine="sales1btn.Initialize(\"sales1btn\")";
Debug.ShouldStop(2048);
main.mostCurrent._sales1btn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sales1btn")));
 BA.debugLineNum = 397;BA.debugLine="sales2btn.Initialize(\"sales2btn\")";
Debug.ShouldStop(4096);
main.mostCurrent._sales2btn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sales2btn")));
 BA.debugLineNum = 398;BA.debugLine="sales3btn.Initialize(\"sales3btn\")";
Debug.ShouldStop(8192);
main.mostCurrent._sales3btn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sales3btn")));
 BA.debugLineNum = 400;BA.debugLine="barGraph1.Initialize(Activity, purchasePanel,";
Debug.ShouldStop(32768);
main.mostCurrent._bargraph1.runClassMethod (b4a.example.bargraph.class, "_initialize" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._activity),(Object)(main.mostCurrent._purchasepanel),(Object)(_purchase),(Object)(_purchase1),(Object)(_purchase2),(Object)(_companyname),(Object)(main.mostCurrent._legend),(Object)(_maxsale),(Object)(BA.ObjectToString("Total Purchase Per Company")),(Object)(_comid),(Object)(BA.ObjectToString("Branch")),(Object)(main.mostCurrent._purchnxtbtn),(Object)(main.mostCurrent._purchbackbtn),(Object)(main.mostCurrent._sortbtn1),(Object)(main.mostCurrent._sortbtn2),(Object)(main.mostCurrent._defbtn),(Object)(main.mostCurrent._sales1btn),(Object)(main.mostCurrent._sales2btn),(Object)(main.mostCurrent._sales3btn));
 BA.debugLineNum = 401;BA.debugLine="totalGraphDataHeight = totalSaleLabel.Height+";
Debug.ShouldStop(65536);
main._totalgraphdataheight = RemoteObject.solve(new RemoteObject[] {_totalsalelabel.runMethod(true,"getHeight"),main.mostCurrent._barpanel.runMethod(true,"getHeight"),_totalpurchaselabel.runMethod(true,"getHeight"),main.mostCurrent._purchasepanel.runMethod(true,"getHeight")}, "+++",3, 1);
 BA.debugLineNum = 402;BA.debugLine="Log($\"maxSale:${maxSale}\"$)";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5327966",(RemoteObject.concat(RemoteObject.createImmutable("maxSale:"),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_maxsale))),RemoteObject.createImmutable(""))),0);
 break; }
case 2: {
 BA.debugLineNum = 404;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Data updated successfully")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 405;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(1048576);
_loadcompanydata();
 break; }
default: {
 BA.debugLineNum = 407;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5327971",RemoteObject.concat(RemoteObject.createImmutable("Unknown job: "),_job.getField(true,"_jobname" /*RemoteObject*/ )),0);
 break; }
}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e244) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e244.toString()); BA.debugLineNum = 412;BA.debugLine="ToastMessageShow(\"Error parsing sales data\", Tr";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Error parsing sales data")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 414;BA.debugLine="ScrollView1.Panel.Height = totalGraphDataHeight";
Debug.ShouldStop(536870912);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {main._totalgraphdataheight,main._totalgetdataheight}, "+",1, 1));
 }else {
 BA.debugLineNum = 417;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 419;BA.debugLine="job.Release";
Debug.ShouldStop(4);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 420;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _label17_click() throws Exception{
try {
		Debug.PushSubsStack("Label17_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,438);
if (RapidSub.canDelegate("label17_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","label17_click");}
RemoteObject _clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _selectedcompany = RemoteObject.createImmutable("");
 BA.debugLineNum = 438;BA.debugLine="Private Sub Label17_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 439;BA.debugLine="Dim clickedLabel As Label = Sender ' Get the clic";
Debug.ShouldStop(4194304);
_clickedlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("clickedLabel", _clickedlabel);Debug.locals.put("clickedLabel", _clickedlabel);
 BA.debugLineNum = 440;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
Debug.ShouldStop(8388608);
_selectedcompany = BA.ObjectToString(_clickedlabel.runMethod(false,"getTag"));Debug.locals.put("selectedCompany", _selectedcompany);Debug.locals.put("selectedCompany", _selectedcompany);
 BA.debugLineNum = 442;BA.debugLine="Starter.company_selected = selectedCompany";
Debug.ShouldStop(33554432);
main.mostCurrent._starter._company_selected /*RemoteObject*/  = _selectedcompany;
 BA.debugLineNum = 445;BA.debugLine="StartActivity(\"Branch\")";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("Branch"))));
 BA.debugLineNum = 446;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadcompanydata() throws Exception{
try {
		Debug.PushSubsStack("LoadCompanyData (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,87);
if (RapidSub.canDelegate("loadcompanydata")) { return b4a.example.main.remoteMe.runUserSub(false, "main","loadcompanydata");}
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 87;BA.debugLine="Sub LoadCompanyData";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 88;BA.debugLine="Try";
Debug.ShouldStop(8388608);
try { BA.debugLineNum = 89;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(16777216);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 90;BA.debugLine="Job1.Initialize(\"GetData\", Me)";
Debug.ShouldStop(33554432);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("GetData")),(Object)(main.getObject()));
 BA.debugLineNum = 91;BA.debugLine="Job1.Download(PHPURL)";
Debug.ShouldStop(67108864);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(main.mostCurrent._phpurl));
 BA.debugLineNum = 92;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",main.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Data..."))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e7) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e7.toString()); BA.debugLineNum = 94;BA.debugLine="Log(LastException.Message)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5196615",main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"),0);
 };
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadgraphdata() throws Exception{
try {
		Debug.PushSubsStack("LoadGraphData (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,99);
if (RapidSub.canDelegate("loadgraphdata")) { return b4a.example.main.remoteMe.runUserSub(false, "main","loadgraphdata");}
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 99;BA.debugLine="Sub LoadGraphData";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="Try";
Debug.ShouldStop(8);
try { BA.debugLineNum = 102;BA.debugLine="PHPURLCompany = $\"https://192.168.8.117/Company/";
Debug.ShouldStop(32);
main.mostCurrent._phpurlcompany = (RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._currentpage))),RemoteObject.createImmutable("&company_sales="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._salesdata1))),RemoteObject.createImmutable("&sort_type="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable("")));
 BA.debugLineNum = 105;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(256);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 106;BA.debugLine="Job1.Initialize(\"GetCompany\", Me)";
Debug.ShouldStop(512);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("GetCompany")),(Object)(main.getObject()));
 BA.debugLineNum = 107;BA.debugLine="Job1.Download(PHPURLCompany)";
Debug.ShouldStop(1024);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(main.mostCurrent._phpurlcompany));
 BA.debugLineNum = 108;BA.debugLine="ProgressDialogShow(\"Loading Graph Data...\")";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",main.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Graph Data..."))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 110;BA.debugLine="Log(\"LoadGraphData Error: \" & LastException.Mess";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5262155",RemoteObject.concat(RemoteObject.createImmutable("LoadGraphData Error: "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 BA.debugLineNum = 111;BA.debugLine="ToastMessageShow(\"Error initiating graph load: \"";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error initiating graph load: "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _nxtbtn_click() throws Exception{
try {
		Debug.PushSubsStack("nxtBtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,448);
if (RapidSub.canDelegate("nxtbtn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","nxtbtn_click");}
 BA.debugLineNum = 448;BA.debugLine="Sub nxtBtn_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 449;BA.debugLine="Log(\"sad\")";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5655361",RemoteObject.createImmutable("sad"),0);
 BA.debugLineNum = 450;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
branch_subs_0._process_globals();
device_subs_0._process_globals();
starter_subs_0._process_globals();
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
bargraph.myClass = BA.getDeviceClass ("b4a.example.bargraph");
branch.myClass = BA.getDeviceClass ("b4a.example.branch");
checkbargraph.myClass = BA.getDeviceClass ("b4a.example.checkbargraph");
device.myClass = BA.getDeviceClass ("b4a.example.device");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
httputils2service.myClass = BA.getDeviceClass ("b4a.example.httputils2service");
httpjob.myClass = BA.getDeviceClass ("b4a.example.httpjob");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="Public company As String";
main._company = RemoteObject.createImmutable("");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _sales1btn_click() throws Exception{
try {
		Debug.PushSubsStack("sales1btn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,474);
if (RapidSub.canDelegate("sales1btn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","sales1btn_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 474;BA.debugLine="Sub sales1btn_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 475;BA.debugLine="Dim btn As Button = Sender";
Debug.ShouldStop(67108864);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 476;BA.debugLine="Dim index As String = btn.Tag";
Debug.ShouldStop(134217728);
_index = BA.ObjectToString(_btn.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 477;BA.debugLine="salesData1 = index.ToLowerCase";
Debug.ShouldStop(268435456);
main._salesdata1 = BA.numberCast(int.class, _index.runMethod(true,"toLowerCase"));
 BA.debugLineNum = 478;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",main.mostCurrent._sortdefaultvalue,BA.ObjectToString("asc")) || RemoteObject.solveBoolean("=",main.mostCurrent._sortdefaultvalue,BA.ObjectToString("desc"))) { 
 BA.debugLineNum = 480;BA.debugLine="LoadGraphData";
Debug.ShouldStop(-2147483648);
_loadgraphdata();
 };
 BA.debugLineNum = 482;BA.debugLine="Log(sortDefaultValue)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5917512",main.mostCurrent._sortdefaultvalue,0);
 BA.debugLineNum = 483;BA.debugLine="Log(\" sales 1 Button clicked: \" & index)";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5917513",RemoteObject.concat(RemoteObject.createImmutable(" sales 1 Button clicked: "),_index),0);
 BA.debugLineNum = 484;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sales2btn_click() throws Exception{
try {
		Debug.PushSubsStack("sales2btn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,486);
if (RapidSub.canDelegate("sales2btn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","sales2btn_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 486;BA.debugLine="Sub sales2btn_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 487;BA.debugLine="Dim btn As Button = Sender";
Debug.ShouldStop(64);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 488;BA.debugLine="Dim index As String = btn.Tag";
Debug.ShouldStop(128);
_index = BA.ObjectToString(_btn.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 489;BA.debugLine="salesData1 = index.ToLowerCase";
Debug.ShouldStop(256);
main._salesdata1 = BA.numberCast(int.class, _index.runMethod(true,"toLowerCase"));
 BA.debugLineNum = 490;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",main.mostCurrent._sortdefaultvalue,BA.ObjectToString("asc")) || RemoteObject.solveBoolean("=",main.mostCurrent._sortdefaultvalue,BA.ObjectToString("desc"))) { 
 BA.debugLineNum = 491;BA.debugLine="LoadGraphData";
Debug.ShouldStop(1024);
_loadgraphdata();
 };
 BA.debugLineNum = 493;BA.debugLine="Log(sortDefaultValue)";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5983047",main.mostCurrent._sortdefaultvalue,0);
 BA.debugLineNum = 494;BA.debugLine="Log(\" sales 2 Button clicked: \" & index)";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5983048",RemoteObject.concat(RemoteObject.createImmutable(" sales 2 Button clicked: "),_index),0);
 BA.debugLineNum = 495;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sales3btn_click() throws Exception{
try {
		Debug.PushSubsStack("sales3btn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,496);
if (RapidSub.canDelegate("sales3btn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","sales3btn_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 496;BA.debugLine="Sub sales3btn_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 497;BA.debugLine="Dim btn As Button = Sender";
Debug.ShouldStop(65536);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 498;BA.debugLine="Dim index As String = btn.Tag";
Debug.ShouldStop(131072);
_index = BA.ObjectToString(_btn.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 499;BA.debugLine="salesData1 = index.ToLowerCase";
Debug.ShouldStop(262144);
main._salesdata1 = BA.numberCast(int.class, _index.runMethod(true,"toLowerCase"));
 BA.debugLineNum = 500;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",main.mostCurrent._sortdefaultvalue,BA.ObjectToString("asc")) || RemoteObject.solveBoolean("=",main.mostCurrent._sortdefaultvalue,BA.ObjectToString("desc"))) { 
 BA.debugLineNum = 501;BA.debugLine="LoadGraphData";
Debug.ShouldStop(1048576);
_loadgraphdata();
 };
 BA.debugLineNum = 503;BA.debugLine="Log(sortDefaultValue)";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("LogImpl","51048583",main.mostCurrent._sortdefaultvalue,0);
 BA.debugLineNum = 504;BA.debugLine="Log(\" sales 3 Button clicked: \" & index)";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("LogImpl","51048584",RemoteObject.concat(RemoteObject.createImmutable(" sales 3 Button clicked: "),_index),0);
 BA.debugLineNum = 505;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sortbtn1_click() throws Exception{
try {
		Debug.PushSubsStack("sortBtn1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,465);
if (RapidSub.canDelegate("sortbtn1_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","sortbtn1_click");}
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 465;BA.debugLine="Sub sortBtn1_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 466;BA.debugLine="Dim chk As RadioButton = Sender";
Debug.ShouldStop(131072);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
_chk = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("chk", _chk);Debug.locals.put("chk", _chk);
 BA.debugLineNum = 467;BA.debugLine="Dim index As String = chk.Tag";
Debug.ShouldStop(262144);
_index = BA.ObjectToString(_chk.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 469;BA.debugLine="sortDefaultValue = index.ToLowerCase";
Debug.ShouldStop(1048576);
main.mostCurrent._sortdefaultvalue = _index.runMethod(true,"toLowerCase");
 BA.debugLineNum = 470;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5851973",(RemoteObject.concat(RemoteObject.createImmutable("sort value: "),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 471;BA.debugLine="LoadGraphData";
Debug.ShouldStop(4194304);
_loadgraphdata();
 BA.debugLineNum = 472;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sortbtn2_click() throws Exception{
try {
		Debug.PushSubsStack("sortBtn2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,452);
if (RapidSub.canDelegate("sortbtn2_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","sortbtn2_click");}
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 452;BA.debugLine="Sub sortBtn2_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 453;BA.debugLine="Dim chk As RadioButton = Sender";
Debug.ShouldStop(16);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
_chk = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("chk", _chk);Debug.locals.put("chk", _chk);
 BA.debugLineNum = 454;BA.debugLine="Dim index As String = chk.Tag";
Debug.ShouldStop(32);
_index = BA.ObjectToString(_chk.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 456;BA.debugLine="sortDefaultValue = index.ToLowerCase";
Debug.ShouldStop(128);
main.mostCurrent._sortdefaultvalue = _index.runMethod(true,"toLowerCase");
 BA.debugLineNum = 457;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5720901",(RemoteObject.concat(RemoteObject.createImmutable("sort value: "),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 458;BA.debugLine="LoadGraphData";
Debug.ShouldStop(512);
_loadgraphdata();
 BA.debugLineNum = 459;BA.debugLine="Log(\"descending\")";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("LogImpl","5720903",RemoteObject.createImmutable("descending"),0);
 BA.debugLineNum = 460;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}