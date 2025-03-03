package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,47);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _gradient = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.GradientDrawable");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 47;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(32768);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 49;BA.debugLine="Label1.Text = Label1.Text.ToUpperCase";
Debug.ShouldStop(65536);
main.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._label1.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 50;BA.debugLine="Label1.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(131072);
main.mostCurrent._label1.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 51;BA.debugLine="ScrollView1.Panel.Color = Colors.ARGB(255, 251, 2";
Debug.ShouldStop(262144);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 251)),(Object)(BA.numberCast(int.class, 251)),(Object)(BA.numberCast(int.class, 251))));
 BA.debugLineNum = 52;BA.debugLine="Dim gradient As GradientDrawable";
Debug.ShouldStop(524288);
_gradient = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("gradient", _gradient);
 BA.debugLineNum = 53;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
Debug.ShouldStop(1048576);
_gradient.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"RIGHT_LEFT")),(Object)(RemoteObject.createNewArray("int",new int[] {2},new Object[] {main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 225)),(Object)(BA.numberCast(int.class, 218)),(Object)(BA.numberCast(int.class, 218))),main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 189)),(Object)(BA.numberCast(int.class, 202)),(Object)(BA.numberCast(int.class, 217)))})));
 BA.debugLineNum = 55;BA.debugLine="ScrollView1.Background = gradient";
Debug.ShouldStop(4194304);
main.mostCurrent._scrollview1.runMethod(false,"setBackground",(_gradient.getObject()));
 BA.debugLineNum = 56;BA.debugLine="ScrollView1.Panel.Height = Activity.Height";
Debug.ShouldStop(8388608);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",main.mostCurrent._activity.runMethod(true,"getHeight"));
 BA.debugLineNum = 57;BA.debugLine="Dim gradient As GradientDrawable";
Debug.ShouldStop(16777216);
_gradient = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("gradient", _gradient);
 BA.debugLineNum = 58;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
Debug.ShouldStop(33554432);
_gradient.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"RIGHT_LEFT")),(Object)(RemoteObject.createNewArray("int",new int[] {2},new Object[] {main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 185)),(Object)(BA.numberCast(int.class, 46)),(Object)(BA.numberCast(int.class, 52))),main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 61)),(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 2)))})));
 BA.debugLineNum = 60;BA.debugLine="Panel2.Background = gradient";
Debug.ShouldStop(134217728);
main.mostCurrent._panel2.runMethod(false,"setBackground",(_gradient.getObject()));
 BA.debugLineNum = 61;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(268435456);
_loadcompanydata();
 BA.debugLineNum = 63;BA.debugLine="barPanel.Initialize(\"\")";
Debug.ShouldStop(1073741824);
main.mostCurrent._barpanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 64;BA.debugLine="Panel1.AddView(barPanel,25dip,Panel2.Height+20dip";
Debug.ShouldStop(-2147483648);
main.mostCurrent._panel1.runVoidMethod ("AddView",(Object)((main.mostCurrent._barpanel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._panel2.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 450)))));
 BA.debugLineNum = 66;BA.debugLine="purchasePanel.Initialize(\"\")";
Debug.ShouldStop(2);
main.mostCurrent._purchasepanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 67;BA.debugLine="Panel1.AddView(purchasePanel,25dip,barPanel.top+b";
Debug.ShouldStop(4);
main.mostCurrent._panel1.runVoidMethod ("AddView",(Object)((main.mostCurrent._purchasepanel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._barpanel.runMethod(true,"getTop"),main.mostCurrent._barpanel.runMethod(true,"getHeight"),main.mostCurrent._panel2.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20))),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))}, "+++-",4, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,330);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 330;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(512);
 BA.debugLineNum = 332;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,326);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 326;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(32);
 BA.debugLineNum = 328;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getmapvalueordefault(RemoteObject _m,RemoteObject _key,RemoteObject _defaultvalue) throws Exception{
try {
		Debug.PushSubsStack("GetMapValueOrDefault (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,318);
if (RapidSub.canDelegate("getmapvalueordefault")) { return b4a.example.main.remoteMe.runUserSub(false, "main","getmapvalueordefault", _m, _key, _defaultvalue);}
Debug.locals.put("m", _m);
Debug.locals.put("Key", _key);
Debug.locals.put("DefaultValue", _defaultvalue);
 BA.debugLineNum = 318;BA.debugLine="Sub GetMapValueOrDefault(m As Map, Key As String,";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 319;BA.debugLine="If m.ContainsKey(Key) Then";
Debug.ShouldStop(1073741824);
if (_m.runMethod(true,"ContainsKey",(Object)((_key))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 320;BA.debugLine="Return m.Get(Key)";
Debug.ShouldStop(-2147483648);
if (true) return _m.runMethod(false,"Get",(Object)((_key)));
 }else {
 BA.debugLineNum = 322;BA.debugLine="Return DefaultValue";
Debug.ShouldStop(2);
if (true) return _defaultvalue;
 };
 BA.debugLineNum = 324;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
 //BA.debugLineNum = 26;BA.debugLine="Dim PHPURL As String = \"https:192.168.8.117/Compa";
main.mostCurrent._phpurl = BA.ObjectToString("https:192.168.8.117/Company/fetch.php?action=get_company_list&page=1");
 //BA.debugLineNum = 27;BA.debugLine="Dim TableDetails As List";
main.mostCurrent._tabledetails = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 29;BA.debugLine="Private Button1 As Button";
main.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private navigate As Label";
main.mostCurrent._navigate = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Dim titleFontSize As Int = 4.5%y";
main._titlefontsize = main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 4.5)),main.mostCurrent.activityBA);
 //BA.debugLineNum = 32;BA.debugLine="Dim primaryFontSize As Int = 1.6%y";
main._primaryfontsize = main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1.6)),main.mostCurrent.activityBA);
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
 //BA.debugLineNum = 39;BA.debugLine="Dim barPanel As Panel";
main.mostCurrent._barpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Dim activityPanel As Panel";
main.mostCurrent._activitypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Public legend() As String = Array As String(\"Sale";
main.mostCurrent._legend = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Sales1"),BA.ObjectToString("Sales2"),RemoteObject.createImmutable("Sales3")});
 //BA.debugLineNum = 43;BA.debugLine="Dim purchasePanel As Panel";
main.mostCurrent._purchasepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,79);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.main.remoteMe.runUserSub(false, "main","jobdone", _job);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _scrollheight = RemoteObject.createImmutable(0);
RemoteObject _salesarray = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _numcolumns = RemoteObject.createImmutable(0);
RemoteObject _pnlwidth = RemoteObject.createImmutable(0);
RemoteObject _pnlheight = RemoteObject.createImmutable(0);
RemoteObject _padding = RemoteObject.createImmutable(0);
RemoteObject _leftposition = RemoteObject.createImmutable(0);
RemoteObject _topposition = RemoteObject.createImmutable(0);
RemoteObject _count = RemoteObject.createImmutable(0);
RemoteObject _record = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _name = RemoteObject.createImmutable("");
RemoteObject _company_id = RemoteObject.createImmutable(0);
RemoteObject _total_count = RemoteObject.createImmutable(0);
RemoteObject _total_pos = RemoteObject.createImmutable(0);
RemoteObject _panel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _label17 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _myimage = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _resizedimage = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _imgview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _panelwidth = RemoteObject.createImmutable(0);
RemoteObject _labelheight = RemoteObject.createImmutable(0);
RemoteObject _totalstore = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalstorelabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalpos = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalposlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
int _i = 0;
RemoteObject _currentcomid = RemoteObject.createImmutable("");
RemoteObject _branches = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _totalbranches = RemoteObject.createImmutable(0);
RemoteObject _branchnames = null;
RemoteObject _branchsales1 = null;
RemoteObject _branchsales2 = null;
RemoteObject _branchsales3 = null;
int _j = 0;
RemoteObject _branchmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _totalcompanies = RemoteObject.createImmutable(0);
RemoteObject _sales = null;
RemoteObject _sales1 = null;
RemoteObject _sales2 = null;
RemoteObject _purchase = null;
RemoteObject _purchase1 = null;
RemoteObject _purchase2 = null;
RemoteObject _companyname = null;
RemoteObject _max_value = null;
RemoteObject _maxsale = RemoteObject.createImmutable(0);
RemoteObject _comname = null;
RemoteObject _nxtbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _backbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
Debug.locals.put("job", _job);
 BA.debugLineNum = 79;BA.debugLine="Sub JobDone(job As HttpJob)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 80;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 81;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 82;BA.debugLine="Try";
Debug.ShouldStop(131072);
try { BA.debugLineNum = 83;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(262144);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 84;BA.debugLine="parser.Initialize(job.GetString)";
Debug.ShouldStop(524288);
_parser.runVoidMethod ("Initialize",(Object)(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ )));
 BA.debugLineNum = 85;BA.debugLine="Select Case job.JobName";
Debug.ShouldStop(1048576);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("GetData"),BA.ObjectToString("UpdateData"))) {
case 0: {
 BA.debugLineNum = 88;BA.debugLine="Dim scrollHeight As Int = 0";
Debug.ShouldStop(8388608);
_scrollheight = BA.numberCast(int.class, 0);Debug.locals.put("scrollHeight", _scrollheight);Debug.locals.put("scrollHeight", _scrollheight);
 BA.debugLineNum = 89;BA.debugLine="Dim salesArray As List = parser.NextArray";
Debug.ShouldStop(16777216);
_salesarray = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_salesarray = _parser.runMethod(false,"NextArray");Debug.locals.put("salesArray", _salesarray);Debug.locals.put("salesArray", _salesarray);
 BA.debugLineNum = 93;BA.debugLine="If salesArray.Size = 0 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",_salesarray.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 94;BA.debugLine="ToastMessageShow(\"No data received\", True)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No data received")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 95;BA.debugLine="Return";
Debug.ShouldStop(1073741824);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 99;BA.debugLine="Dim numColumns As Int = 2 ' Adjust based on p";
Debug.ShouldStop(4);
_numcolumns = BA.numberCast(int.class, 2);Debug.locals.put("numColumns", _numcolumns);Debug.locals.put("numColumns", _numcolumns);
 BA.debugLineNum = 100;BA.debugLine="Dim pnlWidth As Int = Activity.Width - 100dip";
Debug.ShouldStop(8);
_pnlwidth = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))}, "-",1, 1);Debug.locals.put("pnlWidth", _pnlwidth);Debug.locals.put("pnlWidth", _pnlwidth);
 BA.debugLineNum = 101;BA.debugLine="Dim pnlHeight As Int = 280dip";
Debug.ShouldStop(16);
_pnlheight = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 280)));Debug.locals.put("pnlHeight", _pnlheight);Debug.locals.put("pnlHeight", _pnlheight);
 BA.debugLineNum = 102;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(32);
_padding = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 103;BA.debugLine="Dim leftPosition As Int = 50dip";
Debug.ShouldStop(64);
_leftposition = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)));Debug.locals.put("leftPosition", _leftposition);Debug.locals.put("leftPosition", _leftposition);
 BA.debugLineNum = 104;BA.debugLine="Dim topPosition As Int = 77dip";
Debug.ShouldStop(128);
_topposition = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 77)));Debug.locals.put("topPosition", _topposition);Debug.locals.put("topPosition", _topposition);
 BA.debugLineNum = 105;BA.debugLine="Dim count As Int = 0 ' Track panel count";
Debug.ShouldStop(256);
_count = BA.numberCast(int.class, 0);Debug.locals.put("count", _count);Debug.locals.put("count", _count);
 BA.debugLineNum = 106;BA.debugLine="If Activity.Width >= 1340 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("g",main.mostCurrent._activity.runMethod(true,"getWidth"),BA.numberCast(double.class, 1340))) { 
 BA.debugLineNum = 107;BA.debugLine="pnlWidth = 490dip";
Debug.ShouldStop(1024);
_pnlwidth = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 490)));Debug.locals.put("pnlWidth", _pnlwidth);
 BA.debugLineNum = 108;BA.debugLine="pnlHeight = 300dip";
Debug.ShouldStop(2048);
_pnlheight = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)));Debug.locals.put("pnlHeight", _pnlheight);
 BA.debugLineNum = 109;BA.debugLine="padding = 10dip";
Debug.ShouldStop(4096);
_padding = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);
 BA.debugLineNum = 110;BA.debugLine="leftPosition = 10dip";
Debug.ShouldStop(8192);
_leftposition = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("leftPosition", _leftposition);
 };
 BA.debugLineNum = 113;BA.debugLine="For Each record As Map In salesArray";
Debug.ShouldStop(65536);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group27 = _salesarray;
final int groupLen27 = group27.runMethod(true,"getSize").<Integer>get()
;int index27 = 0;
;
for (; index27 < groupLen27;index27++){
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group27.runMethod(false,"Get",index27));Debug.locals.put("record", _record);
Debug.locals.put("record", _record);
 BA.debugLineNum = 114;BA.debugLine="Dim name As String = record.Get(\"company_nam";
Debug.ShouldStop(131072);
_name = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("company_name")))));Debug.locals.put("name", _name);Debug.locals.put("name", _name);
 BA.debugLineNum = 115;BA.debugLine="Dim company_id As Int = record.Get(\"comId\")";
Debug.ShouldStop(262144);
_company_id = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("comId")))));Debug.locals.put("company_id", _company_id);Debug.locals.put("company_id", _company_id);
 BA.debugLineNum = 116;BA.debugLine="Dim total_count As Int = record.Get(\"total_c";
Debug.ShouldStop(524288);
_total_count = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("total_count")))));Debug.locals.put("total_count", _total_count);Debug.locals.put("total_count", _total_count);
 BA.debugLineNum = 117;BA.debugLine="Dim total_pos As Int = record.Get(\"totalDevi";
Debug.ShouldStop(1048576);
_total_pos = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("totalDevices")))));Debug.locals.put("total_pos", _total_pos);Debug.locals.put("total_pos", _total_pos);
 BA.debugLineNum = 120;BA.debugLine="Dim Panel As Panel";
Debug.ShouldStop(8388608);
_panel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("Panel", _panel);
 BA.debugLineNum = 121;BA.debugLine="Panel.Initialize(\"Panel\")";
Debug.ShouldStop(16777216);
_panel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel")));
 BA.debugLineNum = 123;BA.debugLine="Panel.Color = Colors.Black";
Debug.ShouldStop(67108864);
_panel.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 126;BA.debugLine="Dim Panel2 As Panel";
Debug.ShouldStop(536870912);
main.mostCurrent._panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 127;BA.debugLine="Panel2.Initialize(\"Panel2\")";
Debug.ShouldStop(1073741824);
main.mostCurrent._panel2.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel2")));
 BA.debugLineNum = 128;BA.debugLine="Panel2.Color = Colors.Black";
Debug.ShouldStop(-2147483648);
main.mostCurrent._panel2.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 129;BA.debugLine="Panel2.Tag = name";
Debug.ShouldStop(1);
main.mostCurrent._panel2.runMethod(false,"setTag",(_name));
 BA.debugLineNum = 130;BA.debugLine="Panel2.SendToBack";
Debug.ShouldStop(2);
main.mostCurrent._panel2.runVoidMethod ("SendToBack");
 BA.debugLineNum = 134;BA.debugLine="Dim Label17 As Label";
Debug.ShouldStop(32);
_label17 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Label17", _label17);
 BA.debugLineNum = 135;BA.debugLine="Label17.Initialize(\"Label17\")";
Debug.ShouldStop(64);
_label17.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Label17")));
 BA.debugLineNum = 136;BA.debugLine="Label17.Text = name";
Debug.ShouldStop(128);
_label17.runMethod(true,"setText",BA.ObjectToCharSequence(_name));
 BA.debugLineNum = 137;BA.debugLine="Label17.Tag = company_id";
Debug.ShouldStop(256);
_label17.runMethod(false,"setTag",(_company_id));
 BA.debugLineNum = 138;BA.debugLine="Label17.TextSize = 18";
Debug.ShouldStop(512);
_label17.runMethod(true,"setTextSize",BA.numberCast(float.class, 18));
 BA.debugLineNum = 139;BA.debugLine="Label17.TextColor = Colors.White";
Debug.ShouldStop(1024);
_label17.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 140;BA.debugLine="Label17.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(2048);
_label17.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 141;BA.debugLine="Label17.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(4096);
_label17.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 144;BA.debugLine="Dim myImage As Bitmap";
Debug.ShouldStop(32768);
_myimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 145;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"arrows";
Debug.ShouldStop(65536);
_myimage = main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("arrows-removebg-preview.png")));Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 146;BA.debugLine="If myImage.IsInitialized Then";
Debug.ShouldStop(131072);
if (_myimage.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 147;BA.debugLine="Dim resizedImage As Bitmap = myImage.Resize";
Debug.ShouldStop(262144);
_resizedimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_resizedimage = _myimage.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 4.5)),main.mostCurrent.activityBA))))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_myimage.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 2)),main.mostCurrent.activityBA))),_myimage.runMethod(true,"getWidth")}, "*/",0, 0))),(Object)(main.mostCurrent.__c.getField(true,"True")));Debug.locals.put("resizedImage", _resizedimage);Debug.locals.put("resizedImage", _resizedimage);
 BA.debugLineNum = 148;BA.debugLine="Dim imgView As ImageView";
Debug.ShouldStop(524288);
_imgview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("imgView", _imgview);
 BA.debugLineNum = 149;BA.debugLine="imgView.Initialize(\"\")";
Debug.ShouldStop(1048576);
_imgview.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 150;BA.debugLine="imgView.Bitmap = resizedImage";
Debug.ShouldStop(2097152);
_imgview.runMethod(false,"setBitmap",(_resizedimage.getObject()));
 }else {
 BA.debugLineNum = 153;BA.debugLine="Log(\"Error loading image\")";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("LogImpl","03735626",RemoteObject.createImmutable("Error loading image"),0);
 };
 BA.debugLineNum = 156;BA.debugLine="Dim panelWidth As Int = Panel.Width /3";
Debug.ShouldStop(134217728);
_panelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(3)}, "/",0, 0));Debug.locals.put("panelWidth", _panelwidth);Debug.locals.put("panelWidth", _panelwidth);
 BA.debugLineNum = 157;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(268435456);
_padding = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 158;BA.debugLine="Dim labelheight As Int = 35dip";
Debug.ShouldStop(536870912);
_labelheight = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)));Debug.locals.put("labelheight", _labelheight);Debug.locals.put("labelheight", _labelheight);
 BA.debugLineNum = 161;BA.debugLine="panelWidth = Panel.Width /2";
Debug.ShouldStop(1);
_panelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("panelWidth", _panelwidth);
 BA.debugLineNum = 163;BA.debugLine="Dim totalStore As Label";
Debug.ShouldStop(4);
_totalstore = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalStore", _totalstore);
 BA.debugLineNum = 164;BA.debugLine="totalStore.Initialize(\"\")";
Debug.ShouldStop(8);
_totalstore.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 165;BA.debugLine="totalStore.Text = total_count";
Debug.ShouldStop(16);
_totalstore.runMethod(true,"setText",BA.ObjectToCharSequence(_total_count));
 BA.debugLineNum = 166;BA.debugLine="totalStore.TextColor = Colors.Black";
Debug.ShouldStop(32);
_totalstore.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 167;BA.debugLine="totalStore.TextSize = primaryFontSize";
Debug.ShouldStop(64);
_totalstore.runMethod(true,"setTextSize",BA.numberCast(float.class, main._primaryfontsize));
 BA.debugLineNum = 168;BA.debugLine="totalStore.Gravity = Gravity.CENTER";
Debug.ShouldStop(128);
_totalstore.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 169;BA.debugLine="totalStore.Typeface = Typeface.SERIF";
Debug.ShouldStop(256);
_totalstore.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 172;BA.debugLine="Dim totalStoreLabel As Label";
Debug.ShouldStop(2048);
_totalstorelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalStoreLabel", _totalstorelabel);
 BA.debugLineNum = 173;BA.debugLine="totalStoreLabel.Initialize(\"\")";
Debug.ShouldStop(4096);
_totalstorelabel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 174;BA.debugLine="totalStoreLabel.Text = \" Total Store\"";
Debug.ShouldStop(8192);
_totalstorelabel.runMethod(true,"setText",BA.ObjectToCharSequence(" Total Store"));
 BA.debugLineNum = 175;BA.debugLine="totalStoreLabel.TextColor = Colors.Gray";
Debug.ShouldStop(16384);
_totalstorelabel.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 176;BA.debugLine="totalStoreLabel.TextSize = secondaryFontSize";
Debug.ShouldStop(32768);
_totalstorelabel.runMethod(true,"setTextSize",BA.numberCast(float.class, main._secondaryfontsize));
 BA.debugLineNum = 177;BA.debugLine="totalStoreLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(65536);
_totalstorelabel.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 178;BA.debugLine="totalStoreLabel.Typeface = Typeface.MONOSPAC";
Debug.ShouldStop(131072);
_totalstorelabel.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 179;BA.debugLine="totalStoreLabel.Text = totalStoreLabel.Text.";
Debug.ShouldStop(262144);
_totalstorelabel.runMethod(true,"setText",BA.ObjectToCharSequence(_totalstorelabel.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 182;BA.debugLine="Dim totalPos As Label";
Debug.ShouldStop(2097152);
_totalpos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalPos", _totalpos);
 BA.debugLineNum = 183;BA.debugLine="totalPos.Initialize(\"\")";
Debug.ShouldStop(4194304);
_totalpos.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 184;BA.debugLine="totalPos.Text = total_pos";
Debug.ShouldStop(8388608);
_totalpos.runMethod(true,"setText",BA.ObjectToCharSequence(_total_pos));
 BA.debugLineNum = 185;BA.debugLine="totalPos.TextColor = Colors.Black";
Debug.ShouldStop(16777216);
_totalpos.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 186;BA.debugLine="totalPos.TextSize = primaryFontSize";
Debug.ShouldStop(33554432);
_totalpos.runMethod(true,"setTextSize",BA.numberCast(float.class, main._primaryfontsize));
 BA.debugLineNum = 187;BA.debugLine="totalPos.Gravity = Gravity.CENTER";
Debug.ShouldStop(67108864);
_totalpos.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 188;BA.debugLine="totalPos.Typeface = Typeface.SERIF";
Debug.ShouldStop(134217728);
_totalpos.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 191;BA.debugLine="Dim totalPosLabel As Label";
Debug.ShouldStop(1073741824);
_totalposlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalPosLabel", _totalposlabel);
 BA.debugLineNum = 192;BA.debugLine="totalPosLabel.Initialize(\"\")";
Debug.ShouldStop(-2147483648);
_totalposlabel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 193;BA.debugLine="totalPosLabel.Text = \" Total Pos\"";
Debug.ShouldStop(1);
_totalposlabel.runMethod(true,"setText",BA.ObjectToCharSequence(" Total Pos"));
 BA.debugLineNum = 194;BA.debugLine="totalPosLabel.TextColor = Colors.Gray";
Debug.ShouldStop(2);
_totalposlabel.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 195;BA.debugLine="totalPosLabel.TextSize = secondaryFontSize";
Debug.ShouldStop(4);
_totalposlabel.runMethod(true,"setTextSize",BA.numberCast(float.class, main._secondaryfontsize));
 BA.debugLineNum = 196;BA.debugLine="totalPosLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(8);
_totalposlabel.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 197;BA.debugLine="totalPosLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(16);
_totalposlabel.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 198;BA.debugLine="totalPosLabel.Text = totalPosLabel.Text.ToUp";
Debug.ShouldStop(32);
_totalposlabel.runMethod(true,"setText",BA.ObjectToCharSequence(_totalposlabel.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 200;BA.debugLine="For i = 0 To salesArray.Size - 1";
Debug.ShouldStop(128);
{
final int step92 = 1;
final int limit92 = RemoteObject.solve(new RemoteObject[] {_salesarray.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step92 > 0 && _i <= limit92) || (step92 < 0 && _i >= limit92) ;_i = ((int)(0 + _i + step92))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 202;BA.debugLine="Dim record As Map = salesArray.Get(i)";
Debug.ShouldStop(512);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _salesarray.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("record", _record);Debug.locals.put("record", _record);
 BA.debugLineNum = 203;BA.debugLine="Dim currentComId As String = record.Get(\"comI";
Debug.ShouldStop(1024);
_currentcomid = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("comId")))));Debug.locals.put("currentComId", _currentcomid);Debug.locals.put("currentComId", _currentcomid);
 BA.debugLineNum = 206;BA.debugLine="If currentComId = 1 Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_currentcomid,BA.NumberToString(1))) { 
 BA.debugLineNum = 209;BA.debugLine="If record.ContainsKey(\"branches\") Then";
Debug.ShouldStop(65536);
if (_record.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("branches")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 210;BA.debugLine="Dim branches As List = record.Get(\"branches\"";
Debug.ShouldStop(131072);
_branches = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_branches = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("branches")))));Debug.locals.put("branches", _branches);Debug.locals.put("branches", _branches);
 BA.debugLineNum = 211;BA.debugLine="Dim totalBranches As Int = branches.Size";
Debug.ShouldStop(262144);
_totalbranches = _branches.runMethod(true,"getSize");Debug.locals.put("totalBranches", _totalbranches);Debug.locals.put("totalBranches", _totalbranches);
 BA.debugLineNum = 214;BA.debugLine="Dim branchNames(totalBranches) As String";
Debug.ShouldStop(2097152);
_branchnames = RemoteObject.createNewArray ("String", new int[] {_totalbranches.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("branchNames", _branchnames);
 BA.debugLineNum = 215;BA.debugLine="Dim branchSales1(totalBranches) As Int";
Debug.ShouldStop(4194304);
_branchsales1 = RemoteObject.createNewArray ("int", new int[] {_totalbranches.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("branchSales1", _branchsales1);
 BA.debugLineNum = 216;BA.debugLine="Dim branchSales2(totalBranches) As Int";
Debug.ShouldStop(8388608);
_branchsales2 = RemoteObject.createNewArray ("int", new int[] {_totalbranches.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("branchSales2", _branchsales2);
 BA.debugLineNum = 217;BA.debugLine="Dim branchSales3(totalBranches) As Int";
Debug.ShouldStop(16777216);
_branchsales3 = RemoteObject.createNewArray ("int", new int[] {_totalbranches.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("branchSales3", _branchsales3);
 BA.debugLineNum = 220;BA.debugLine="For j = 0 To totalBranches - 1";
Debug.ShouldStop(134217728);
{
final int step103 = 1;
final int limit103 = RemoteObject.solve(new RemoteObject[] {_totalbranches,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_j = 0 ;
for (;(step103 > 0 && _j <= limit103) || (step103 < 0 && _j >= limit103) ;_j = ((int)(0 + _j + step103))  ) {
Debug.locals.put("j", _j);
 BA.debugLineNum = 221;BA.debugLine="Dim branchMap As Map = branches.Get(j)";
Debug.ShouldStop(268435456);
_branchmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_branchmap = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _branches.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _j))));Debug.locals.put("branchMap", _branchmap);Debug.locals.put("branchMap", _branchmap);
 BA.debugLineNum = 222;BA.debugLine="branchNames(j) = branchMap.GetDefault(\"b";
Debug.ShouldStop(536870912);
_branchnames.setArrayElement ((BA.ObjectToString(_branchmap.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("branch_name"))),(Object)((RemoteObject.createImmutable("")))))),BA.numberCast(int.class, _j));
 BA.debugLineNum = 223;BA.debugLine="branchSales1(j) = branchMap.GetDefault(\"";
Debug.ShouldStop(1073741824);
_branchsales1.setArrayElement (BA.numberCast(int.class, _branchmap.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales1"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _j));
 BA.debugLineNum = 224;BA.debugLine="branchSales2(j) = branchMap.GetDefault(\"";
Debug.ShouldStop(-2147483648);
_branchsales2.setArrayElement (BA.numberCast(int.class, _branchmap.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales2"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _j));
 BA.debugLineNum = 225;BA.debugLine="branchSales3(j) = branchMap.GetDefault(\"";
Debug.ShouldStop(1);
_branchsales3.setArrayElement (BA.numberCast(int.class, _branchmap.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales3"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _j));
 }
}Debug.locals.put("j", _j);
;
 BA.debugLineNum = 236;BA.debugLine="Dim legend() As String = Array As String(";
Debug.ShouldStop(2048);
main.mostCurrent._legend = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Sales1"),BA.ObjectToString("Sales2"),RemoteObject.createImmutable("Sales3")});
 }else {
 BA.debugLineNum = 239;BA.debugLine="Log($\"Company: ${name} has no branches inform";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("LogImpl","03735712",(RemoteObject.concat(RemoteObject.createImmutable("Company: "),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_name))),RemoteObject.createImmutable(" has no branches information."))),0);
 };
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 248;BA.debugLine="If Activity.Width >= 1340 Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("g",main.mostCurrent._activity.runMethod(true,"getWidth"),BA.numberCast(double.class, 1340))) { 
 BA.debugLineNum = 249;BA.debugLine="count = count + 1";
Debug.ShouldStop(16777216);
_count = RemoteObject.solve(new RemoteObject[] {_count,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("count", _count);
 BA.debugLineNum = 250;BA.debugLine="If count Mod numColumns = 0 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {_count,_numcolumns}, "%",0, 1),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 252;BA.debugLine="leftPosition = 10dip";
Debug.ShouldStop(134217728);
_leftposition = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("leftPosition", _leftposition);
 BA.debugLineNum = 253;BA.debugLine="topPosition = topPosition + pnlHeight + pa";
Debug.ShouldStop(268435456);
_topposition = RemoteObject.solve(new RemoteObject[] {_topposition,_pnlheight,_padding}, "++",2, 1);Debug.locals.put("topPosition", _topposition);
 }else {
 BA.debugLineNum = 256;BA.debugLine="leftPosition = leftPosition + pnlWidth + p";
Debug.ShouldStop(-2147483648);
_leftposition = RemoteObject.solve(new RemoteObject[] {_leftposition,_pnlwidth,_padding}, "++",2, 1);Debug.locals.put("leftPosition", _leftposition);
 };
 BA.debugLineNum = 258;BA.debugLine="scrollHeight = scrollHeight + 175dip";
Debug.ShouldStop(2);
_scrollheight = RemoteObject.solve(new RemoteObject[] {_scrollheight,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 175)))}, "+",1, 1);Debug.locals.put("scrollHeight", _scrollheight);
 }else {
 BA.debugLineNum = 260;BA.debugLine="topPosition = topPosition + pnlHeight + pad";
Debug.ShouldStop(8);
_topposition = RemoteObject.solve(new RemoteObject[] {_topposition,_pnlheight,_padding}, "++",2, 1);Debug.locals.put("topPosition", _topposition);
 BA.debugLineNum = 261;BA.debugLine="scrollHeight = scrollHeight + 300dip + padd";
Debug.ShouldStop(16);
_scrollheight = RemoteObject.solve(new RemoteObject[] {_scrollheight,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300))),_padding}, "++",2, 1);Debug.locals.put("scrollHeight", _scrollheight);
 };
 BA.debugLineNum = 265;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(256);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 266;BA.debugLine="cd.Initialize2(Colors.White, 0dip, 1dip, Col";
Debug.ShouldStop(512);
_cd.runVoidMethod ("Initialize2",(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))),(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 267;BA.debugLine="Panel.Background = cd";
Debug.ShouldStop(1024);
_panel.runMethod(false,"setBackground",(_cd.getObject()));
 }
}Debug.locals.put("record", _record);
;
 BA.debugLineNum = 270;BA.debugLine="Dim totalCompanies As Int = salesArray.Size";
Debug.ShouldStop(8192);
_totalcompanies = _salesarray.runMethod(true,"getSize");Debug.locals.put("totalCompanies", _totalcompanies);Debug.locals.put("totalCompanies", _totalcompanies);
 BA.debugLineNum = 271;BA.debugLine="Dim sales(totalCompanies) As Int";
Debug.ShouldStop(16384);
_sales = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("sales", _sales);
 BA.debugLineNum = 272;BA.debugLine="Dim sales1(totalCompanies) As Int";
Debug.ShouldStop(32768);
_sales1 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("sales1", _sales1);
 BA.debugLineNum = 273;BA.debugLine="Dim sales2(totalCompanies) As Int";
Debug.ShouldStop(65536);
_sales2 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("sales2", _sales2);
 BA.debugLineNum = 274;BA.debugLine="Dim purchase(totalCompanies) As Int";
Debug.ShouldStop(131072);
_purchase = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("purchase", _purchase);
 BA.debugLineNum = 275;BA.debugLine="Dim purchase1(totalCompanies) As Int";
Debug.ShouldStop(262144);
_purchase1 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("purchase1", _purchase1);
 BA.debugLineNum = 276;BA.debugLine="Dim purchase2(totalCompanies) As Int";
Debug.ShouldStop(524288);
_purchase2 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("purchase2", _purchase2);
 BA.debugLineNum = 277;BA.debugLine="Dim companyName(totalCompanies) As String";
Debug.ShouldStop(1048576);
_companyname = RemoteObject.createNewArray ("String", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("companyName", _companyname);
 BA.debugLineNum = 278;BA.debugLine="Dim max_value(totalCompanies) As Int";
Debug.ShouldStop(2097152);
_max_value = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("max_value", _max_value);
 BA.debugLineNum = 279;BA.debugLine="Dim maxSale As Int=0";
Debug.ShouldStop(4194304);
_maxsale = BA.numberCast(int.class, 0);Debug.locals.put("maxSale", _maxsale);Debug.locals.put("maxSale", _maxsale);
 BA.debugLineNum = 281;BA.debugLine="For i = 0 To totalCompanies - 1";
Debug.ShouldStop(16777216);
{
final int step143 = 1;
final int limit143 = RemoteObject.solve(new RemoteObject[] {_totalcompanies,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step143 > 0 && _i <= limit143) || (step143 < 0 && _i >= limit143) ;_i = ((int)(0 + _i + step143))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 282;BA.debugLine="Dim record As Map = salesArray.Get(i)";
Debug.ShouldStop(33554432);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _salesarray.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("record", _record);Debug.locals.put("record", _record);
 BA.debugLineNum = 283;BA.debugLine="companyName(i) = record.GetDefault(\"company_";
Debug.ShouldStop(67108864);
_companyname.setArrayElement (BA.ObjectToString(_record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("company_name"))),(Object)((RemoteObject.createImmutable("Unknown"))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 284;BA.debugLine="sales(i) = record.GetDefault(\"sales_1\", 0)";
Debug.ShouldStop(134217728);
_sales.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_1"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 285;BA.debugLine="sales1(i) = record.GetDefault(\"sales_2\", 0)";
Debug.ShouldStop(268435456);
_sales1.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_2"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 286;BA.debugLine="sales2(i) = record.GetDefault(\"sales_3\", 0)";
Debug.ShouldStop(536870912);
_sales2.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_3"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 287;BA.debugLine="purchase(i) = record.GetDefault(\"purchase_1\"";
Debug.ShouldStop(1073741824);
_purchase.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("purchase_1"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 288;BA.debugLine="purchase1(i) = record.GetDefault(\"purchase_2";
Debug.ShouldStop(-2147483648);
_purchase1.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("purchase_2"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 289;BA.debugLine="purchase2(i) = record.GetDefault(\"purchase_\"";
Debug.ShouldStop(1);
_purchase2.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("purchase_"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 290;BA.debugLine="max_value(i) = record.GetDefault(\"max_value\"";
Debug.ShouldStop(2);
_max_value.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("max_value"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 291;BA.debugLine="maxSale = Max(maxSale, max_value(i))";
Debug.ShouldStop(4);
_maxsale = BA.numberCast(int.class, main.mostCurrent.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, _maxsale)),(Object)(BA.numberCast(double.class, _max_value.getArrayElement(true,BA.numberCast(int.class, _i))))));Debug.locals.put("maxSale", _maxsale);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 294;BA.debugLine="barPanel.RemoveAllViews";
Debug.ShouldStop(32);
main.mostCurrent._barpanel.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 295;BA.debugLine="barPanel.Invalidate ' Force redraw";
Debug.ShouldStop(64);
main.mostCurrent._barpanel.runVoidMethod ("Invalidate");
 BA.debugLineNum = 297;BA.debugLine="Dim comName() As String = Array As String(\"EZ";
Debug.ShouldStop(256);
_comname = RemoteObject.createNewArray("String",new int[] {4},new Object[] {BA.ObjectToString("EZWARE"),BA.ObjectToString("EZWARE1"),BA.ObjectToString("EZWARE2"),RemoteObject.createImmutable("EZWARE3")});Debug.locals.put("comName", _comname);Debug.locals.put("comName", _comname);
 BA.debugLineNum = 298;BA.debugLine="Dim nxtBtn As Button";
Debug.ShouldStop(512);
_nxtbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("nxtBtn", _nxtbtn);
 BA.debugLineNum = 299;BA.debugLine="Dim backBtn As Button";
Debug.ShouldStop(1024);
_backbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("backBtn", _backbtn);
 BA.debugLineNum = 300;BA.debugLine="Dim legend() As String = Array As String(\"Sal";
Debug.ShouldStop(2048);
main.mostCurrent._legend = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Sales1"),BA.ObjectToString("Sales2"),RemoteObject.createImmutable("Sales3")});
 BA.debugLineNum = 302;BA.debugLine="legend = Array As String(\"Purchase1\",\"Purchas";
Debug.ShouldStop(8192);
main.mostCurrent._legend = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Purchase1"),BA.ObjectToString("Purchase2"),RemoteObject.createImmutable("Purchase3")});
 BA.debugLineNum = 303;BA.debugLine="barGraph1.Initialize(Activity, purchasePanel,";
Debug.ShouldStop(16384);
main.mostCurrent._bargraph1.runClassMethod (b4a.example.bargraph.class, "_initialize" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._activity),(Object)(main.mostCurrent._purchasepanel),(Object)(_purchase),(Object)(_purchase1),(Object)(_purchase2),(Object)(_companyname),(Object)(main.mostCurrent._legend),(Object)(_maxsale),(Object)(RemoteObject.createImmutable("Total Purchase of the Company")));
 break; }
case 1: {
 BA.debugLineNum = 305;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Data updated successfully")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 306;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(131072);
_loadcompanydata();
 break; }
default: {
 BA.debugLineNum = 308;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("LogImpl","03735781",RemoteObject.concat(RemoteObject.createImmutable("Unknown job: "),_job.getField(true,"_jobname" /*RemoteObject*/ )),0);
 break; }
}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e170) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e170.toString()); BA.debugLineNum = 311;BA.debugLine="ToastMessageShow(\"Error parsing sales data\", Tr";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Error parsing sales data")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 }else {
 BA.debugLineNum = 314;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 316;BA.debugLine="job.Release";
Debug.ShouldStop(134217728);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 317;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Label17_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,335);
if (RapidSub.canDelegate("label17_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","label17_click");}
RemoteObject _clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _selectedcompany = RemoteObject.createImmutable("");
 BA.debugLineNum = 335;BA.debugLine="Private Sub Label17_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 336;BA.debugLine="Dim clickedLabel As Label = Sender ' Get the clic";
Debug.ShouldStop(32768);
_clickedlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("clickedLabel", _clickedlabel);Debug.locals.put("clickedLabel", _clickedlabel);
 BA.debugLineNum = 337;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
Debug.ShouldStop(65536);
_selectedcompany = BA.ObjectToString(_clickedlabel.runMethod(false,"getTag"));Debug.locals.put("selectedCompany", _selectedcompany);Debug.locals.put("selectedCompany", _selectedcompany);
 BA.debugLineNum = 339;BA.debugLine="Starter.company_selected = selectedCompany";
Debug.ShouldStop(262144);
main.mostCurrent._starter._company_selected /*RemoteObject*/  = _selectedcompany;
 BA.debugLineNum = 342;BA.debugLine="StartActivity(\"Branch\")";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("Branch"))));
 BA.debugLineNum = 343;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("LoadCompanyData (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,69);
if (RapidSub.canDelegate("loadcompanydata")) { return b4a.example.main.remoteMe.runUserSub(false, "main","loadcompanydata");}
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 69;BA.debugLine="Sub LoadCompanyData";
Debug.ShouldStop(16);
 BA.debugLineNum = 70;BA.debugLine="Try";
Debug.ShouldStop(32);
try { BA.debugLineNum = 71;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(64);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 72;BA.debugLine="Job1.Initialize(\"GetData\", Me)";
Debug.ShouldStop(128);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("GetData")),(Object)(main.getObject()));
 BA.debugLineNum = 73;BA.debugLine="Job1.Download(PHPURL)";
Debug.ShouldStop(256);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(main.mostCurrent._phpurl));
 BA.debugLineNum = 74;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",main.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Data..."))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e7) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e7.toString()); BA.debugLineNum = 76;BA.debugLine="Log(LastException.Message)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("LogImpl","03670023",main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"),0);
 };
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
checkbargraph.myClass = BA.getDeviceClass ("b4a.example.checkbargraph");
bargraph.myClass = BA.getDeviceClass ("b4a.example.bargraph");
branch.myClass = BA.getDeviceClass ("b4a.example.branch");
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
}