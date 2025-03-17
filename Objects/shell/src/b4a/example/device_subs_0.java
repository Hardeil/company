package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class device_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (device) ","device",4,device.mostCurrent.activityBA,device.mostCurrent,34);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.device.remoteMe.runUserSub(false, "device","activity_create", _firsttime);}
RemoteObject _tablelabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _idlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _devicelabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _seriallabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sale1label = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sale2label = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sale3label = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _gradient = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.GradientDrawable");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 35;BA.debugLine="Activity.LoadLayout(\"Device\")";
Debug.ShouldStop(4);
device.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Device")),device.mostCurrent.activityBA);
 BA.debugLineNum = 36;BA.debugLine="ScrollView1.Width = 100%x";
Debug.ShouldStop(8);
device.mostCurrent._scrollview1.runMethod(true,"setWidth",device.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),device.mostCurrent.activityBA));
 BA.debugLineNum = 37;BA.debugLine="ScrollViewPanel.Initialize(\"\")";
Debug.ShouldStop(16);
device.mostCurrent._scrollviewpanel.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 38;BA.debugLine="ScrollView1.Panel.AddView(ScrollViewPanel, 0, 0,";
Debug.ShouldStop(32);
device.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((device.mostCurrent._scrollviewpanel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(device.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),device.mostCurrent.activityBA)),(Object)(device.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),device.mostCurrent.activityBA)));
 BA.debugLineNum = 39;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
Debug.ShouldStop(64);
device.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",device.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Data..."))));
 BA.debugLineNum = 40;BA.debugLine="TableDetails.Initialize";
Debug.ShouldStop(128);
device.mostCurrent._tabledetails.runVoidMethod ("Initialize");
 BA.debugLineNum = 53;BA.debugLine="Dim tableLabel As Panel";
Debug.ShouldStop(1048576);
_tablelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("tableLabel", _tablelabel);
 BA.debugLineNum = 54;BA.debugLine="tableLabel.Initialize(\"deviceTitle\")";
Debug.ShouldStop(2097152);
_tablelabel.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("deviceTitle")));
 BA.debugLineNum = 55;BA.debugLine="tableLabel.Color = Colors.Black";
Debug.ShouldStop(4194304);
_tablelabel.runVoidMethod ("setColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 56;BA.debugLine="Panel1.AddView(tableLabel, 0, Panel2.Height+Panel";
Debug.ShouldStop(8388608);
device.mostCurrent._panel1.runVoidMethod ("AddView",(Object)((_tablelabel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {device.mostCurrent._panel2.runMethod(true,"getHeight"),device.mostCurrent._panel4.runMethod(true,"getHeight"),device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "+-",2, 1)),(Object)(device.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(device.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 6)),device.mostCurrent.activityBA)));
 BA.debugLineNum = 58;BA.debugLine="ScrollView1.Top = tableLabel.Height + Panel2.Heig";
Debug.ShouldStop(33554432);
device.mostCurrent._scrollview1.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_tablelabel.runMethod(true,"getHeight"),device.mostCurrent._panel2.runMethod(true,"getHeight"),device.mostCurrent._panel4.runMethod(true,"getHeight"),device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "++-",3, 1));
 BA.debugLineNum = 60;BA.debugLine="panelWidth = tableLabel.Width /6";
Debug.ShouldStop(134217728);
device._panelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_tablelabel.runMethod(true,"getWidth"),RemoteObject.createImmutable(6)}, "/",0, 0));
 BA.debugLineNum = 62;BA.debugLine="Dim idLabel As Label";
Debug.ShouldStop(536870912);
_idlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("idLabel", _idlabel);
 BA.debugLineNum = 63;BA.debugLine="idLabel.Initialize(\"\")";
Debug.ShouldStop(1073741824);
_idlabel.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 64;BA.debugLine="idLabel.Text = \"ID\"";
Debug.ShouldStop(-2147483648);
_idlabel.runMethod(true,"setText",BA.ObjectToCharSequence("ID"));
 BA.debugLineNum = 65;BA.debugLine="idLabel.TextColor= Colors.White";
Debug.ShouldStop(1);
_idlabel.runMethod(true,"setTextColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 66;BA.debugLine="idLabel.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(2);
_idlabel.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 67;BA.debugLine="idLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(4);
_idlabel.runMethod(false,"setTypeface",device.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 68;BA.debugLine="tableLabel.AddView(idLabel,tdleftPos,0dip,panelWi";
Debug.ShouldStop(8);
_tablelabel.runVoidMethod ("AddView",(Object)((_idlabel.getObject())),(Object)(device._tdleftpos),(Object)(device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(device._panelwidth),(Object)(_tablelabel.runMethod(true,"getHeight")));
 BA.debugLineNum = 70;BA.debugLine="Dim deviceLabel As Label";
Debug.ShouldStop(32);
_devicelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("deviceLabel", _devicelabel);
 BA.debugLineNum = 71;BA.debugLine="deviceLabel.Initialize(\"\")";
Debug.ShouldStop(64);
_devicelabel.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 72;BA.debugLine="deviceLabel.Text = \"NAME\"";
Debug.ShouldStop(128);
_devicelabel.runMethod(true,"setText",BA.ObjectToCharSequence("NAME"));
 BA.debugLineNum = 73;BA.debugLine="deviceLabel.TextColor= Colors.White";
Debug.ShouldStop(256);
_devicelabel.runMethod(true,"setTextColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 74;BA.debugLine="deviceLabel.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(512);
_devicelabel.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 75;BA.debugLine="deviceLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(1024);
_devicelabel.runMethod(false,"setTypeface",device.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 76;BA.debugLine="tableLabel.AddView(deviceLabel,panelWidth,0,panel";
Debug.ShouldStop(2048);
_tablelabel.runVoidMethod ("AddView",(Object)((_devicelabel.getObject())),(Object)(device._panelwidth),(Object)(BA.numberCast(int.class, 0)),(Object)(device._panelwidth),(Object)(_tablelabel.runMethod(true,"getHeight")));
 BA.debugLineNum = 78;BA.debugLine="Dim serialLabel As Label";
Debug.ShouldStop(8192);
_seriallabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("serialLabel", _seriallabel);
 BA.debugLineNum = 79;BA.debugLine="serialLabel.Initialize(\"\")";
Debug.ShouldStop(16384);
_seriallabel.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 80;BA.debugLine="serialLabel.Text = \"SERIAL NUMBER\"";
Debug.ShouldStop(32768);
_seriallabel.runMethod(true,"setText",BA.ObjectToCharSequence("SERIAL NUMBER"));
 BA.debugLineNum = 81;BA.debugLine="serialLabel.TextSize = 11";
Debug.ShouldStop(65536);
_seriallabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 11));
 BA.debugLineNum = 82;BA.debugLine="serialLabel.TextColor= Colors.White";
Debug.ShouldStop(131072);
_seriallabel.runMethod(true,"setTextColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 83;BA.debugLine="serialLabel.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(262144);
_seriallabel.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 84;BA.debugLine="serialLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(524288);
_seriallabel.runMethod(false,"setTypeface",device.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 85;BA.debugLine="tableLabel.AddView(serialLabel,panelWidth*2,0,pan";
Debug.ShouldStop(1048576);
_tablelabel.runVoidMethod ("AddView",(Object)((_seriallabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {device._panelwidth,RemoteObject.createImmutable(2)}, "*",0, 1)),(Object)(BA.numberCast(int.class, 0)),(Object)(device._panelwidth),(Object)(_tablelabel.runMethod(true,"getHeight")));
 BA.debugLineNum = 87;BA.debugLine="Dim sale1Label As Label";
Debug.ShouldStop(4194304);
_sale1label = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale1Label", _sale1label);
 BA.debugLineNum = 88;BA.debugLine="sale1Label.Initialize(\"\")";
Debug.ShouldStop(8388608);
_sale1label.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 89;BA.debugLine="sale1Label.Text = \"FIRST SALE\"";
Debug.ShouldStop(16777216);
_sale1label.runMethod(true,"setText",BA.ObjectToCharSequence("FIRST SALE"));
 BA.debugLineNum = 90;BA.debugLine="sale1Label.TextColor= Colors.White";
Debug.ShouldStop(33554432);
_sale1label.runMethod(true,"setTextColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 91;BA.debugLine="sale1Label.TextSize = 11";
Debug.ShouldStop(67108864);
_sale1label.runMethod(true,"setTextSize",BA.numberCast(float.class, 11));
 BA.debugLineNum = 92;BA.debugLine="sale1Label.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(134217728);
_sale1label.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 93;BA.debugLine="sale1Label.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(268435456);
_sale1label.runMethod(false,"setTypeface",device.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 94;BA.debugLine="tableLabel.AddView(sale1Label,panelWidth*3,0,pane";
Debug.ShouldStop(536870912);
_tablelabel.runVoidMethod ("AddView",(Object)((_sale1label.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {device._panelwidth,RemoteObject.createImmutable(3)}, "*",0, 1)),(Object)(BA.numberCast(int.class, 0)),(Object)(device._panelwidth),(Object)(_tablelabel.runMethod(true,"getHeight")));
 BA.debugLineNum = 96;BA.debugLine="Dim sale2Label As Label";
Debug.ShouldStop(-2147483648);
_sale2label = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale2Label", _sale2label);
 BA.debugLineNum = 97;BA.debugLine="sale2Label.Initialize(\"\")";
Debug.ShouldStop(1);
_sale2label.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 98;BA.debugLine="sale2Label.Text = \"SECOND SALE\"";
Debug.ShouldStop(2);
_sale2label.runMethod(true,"setText",BA.ObjectToCharSequence("SECOND SALE"));
 BA.debugLineNum = 99;BA.debugLine="sale2Label.TextColor= Colors.White";
Debug.ShouldStop(4);
_sale2label.runMethod(true,"setTextColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 100;BA.debugLine="sale2Label.TextSize = 11";
Debug.ShouldStop(8);
_sale2label.runMethod(true,"setTextSize",BA.numberCast(float.class, 11));
 BA.debugLineNum = 101;BA.debugLine="sale2Label.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(16);
_sale2label.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 102;BA.debugLine="sale2Label.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(32);
_sale2label.runMethod(false,"setTypeface",device.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 103;BA.debugLine="tableLabel.AddView(sale2Label,panelWidth*4,0,pane";
Debug.ShouldStop(64);
_tablelabel.runVoidMethod ("AddView",(Object)((_sale2label.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {device._panelwidth,RemoteObject.createImmutable(4)}, "*",0, 1)),(Object)(BA.numberCast(int.class, 0)),(Object)(device._panelwidth),(Object)(_tablelabel.runMethod(true,"getHeight")));
 BA.debugLineNum = 105;BA.debugLine="Dim sale3Label As Label";
Debug.ShouldStop(256);
_sale3label = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale3Label", _sale3label);
 BA.debugLineNum = 106;BA.debugLine="sale3Label.Initialize(\"\")";
Debug.ShouldStop(512);
_sale3label.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 107;BA.debugLine="sale3Label.Text = \"THIRD SALE\"";
Debug.ShouldStop(1024);
_sale3label.runMethod(true,"setText",BA.ObjectToCharSequence("THIRD SALE"));
 BA.debugLineNum = 108;BA.debugLine="sale3Label.TextSize = 11";
Debug.ShouldStop(2048);
_sale3label.runMethod(true,"setTextSize",BA.numberCast(float.class, 11));
 BA.debugLineNum = 109;BA.debugLine="sale3Label.TextColor= Colors.White";
Debug.ShouldStop(4096);
_sale3label.runMethod(true,"setTextColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 110;BA.debugLine="sale3Label.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(8192);
_sale3label.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 111;BA.debugLine="sale3Label.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(16384);
_sale3label.runMethod(false,"setTypeface",device.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 112;BA.debugLine="tableLabel.AddView(sale3Label,panelWidth*5,0,pane";
Debug.ShouldStop(32768);
_tablelabel.runVoidMethod ("AddView",(Object)((_sale3label.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {device._panelwidth,RemoteObject.createImmutable(5)}, "*",0, 1)),(Object)(BA.numberCast(int.class, 0)),(Object)(device._panelwidth),(Object)(_tablelabel.runMethod(true,"getHeight")));
 BA.debugLineNum = 115;BA.debugLine="home.Initialize(\"home\")";
Debug.ShouldStop(262144);
device.mostCurrent._home.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("home")));
 BA.debugLineNum = 116;BA.debugLine="home.Text = \"HOME |\"";
Debug.ShouldStop(524288);
device.mostCurrent._home.runMethod(true,"setText",BA.ObjectToCharSequence("HOME |"));
 BA.debugLineNum = 117;BA.debugLine="home.TextColor = Colors.Black";
Debug.ShouldStop(1048576);
device.mostCurrent._home.runMethod(true,"setTextColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 118;BA.debugLine="home.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(2097152);
device.mostCurrent._home.runMethod(false,"setTypeface",device.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 119;BA.debugLine="home.Gravity = Gravity.CENTER";
Debug.ShouldStop(4194304);
device.mostCurrent._home.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 120;BA.debugLine="home.TextSize = 16 '";
Debug.ShouldStop(8388608);
device.mostCurrent._home.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 121;BA.debugLine="Panel4.AddView(home, 0, 0, responsiveLabel(home),";
Debug.ShouldStop(16777216);
device.mostCurrent._panel4.runVoidMethod ("AddView",(Object)((device.mostCurrent._home.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_responsivelabel(device.mostCurrent._home)),(Object)(device.mostCurrent._panel4.runMethod(true,"getHeight")));
 BA.debugLineNum = 122;BA.debugLine="Panel4.Color = Colors.Transparent";
Debug.ShouldStop(33554432);
device.mostCurrent._panel4.runVoidMethod ("setColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 124;BA.debugLine="branches.Initialize(\"branch\")";
Debug.ShouldStop(134217728);
device.mostCurrent._branches.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("branch")));
 BA.debugLineNum = 125;BA.debugLine="branches.Text = \"Branches\"";
Debug.ShouldStop(268435456);
device.mostCurrent._branches.runMethod(true,"setText",BA.ObjectToCharSequence("Branches"));
 BA.debugLineNum = 126;BA.debugLine="branches.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(536870912);
device.mostCurrent._branches.runMethod(false,"setTypeface",device.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 127;BA.debugLine="branches.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(1073741824);
device.mostCurrent._branches.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 128;BA.debugLine="branches.TextSize = 16";
Debug.ShouldStop(-2147483648);
device.mostCurrent._branches.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 129;BA.debugLine="branches.TextColor = Colors.Black";
Debug.ShouldStop(1);
device.mostCurrent._branches.runMethod(true,"setTextColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 130;BA.debugLine="Panel4.AddView(branches, responsiveLabel(home), 0";
Debug.ShouldStop(2);
device.mostCurrent._panel4.runVoidMethod ("AddView",(Object)((device.mostCurrent._branches.getObject())),(Object)(_responsivelabel(device.mostCurrent._home)),(Object)(BA.numberCast(int.class, 0)),(Object)(device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 210)))),(Object)(device.mostCurrent._panel4.runMethod(true,"getHeight")));
 BA.debugLineNum = 133;BA.debugLine="devices.Initialize(\"device\")";
Debug.ShouldStop(16);
device.mostCurrent._devices.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("device")));
 BA.debugLineNum = 134;BA.debugLine="devices.Text = \"Devices\"";
Debug.ShouldStop(32);
device.mostCurrent._devices.runMethod(true,"setText",BA.ObjectToCharSequence("Devices"));
 BA.debugLineNum = 135;BA.debugLine="devices.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(64);
device.mostCurrent._devices.runMethod(false,"setTypeface",device.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 136;BA.debugLine="devices.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(128);
device.mostCurrent._devices.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 137;BA.debugLine="devices.TextSize = 16";
Debug.ShouldStop(256);
device.mostCurrent._devices.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 138;BA.debugLine="Panel4.AddView(devices, branches.Left + branches.";
Debug.ShouldStop(512);
device.mostCurrent._panel4.runVoidMethod ("AddView",(Object)((device.mostCurrent._devices.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {device.mostCurrent._branches.runMethod(true,"getLeft"),device.mostCurrent._branches.runMethod(true,"getWidth")}, "+",1, 1)),(Object)(BA.numberCast(int.class, 0)),(Object)(device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))),(Object)(device.mostCurrent._panel4.runMethod(true,"getHeight")));
 BA.debugLineNum = 139;BA.debugLine="Panel4.Color = Colors.Transparent";
Debug.ShouldStop(1024);
device.mostCurrent._panel4.runVoidMethod ("setColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 141;BA.debugLine="Dim gradient As GradientDrawable";
Debug.ShouldStop(4096);
_gradient = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("gradient", _gradient);
 BA.debugLineNum = 142;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
Debug.ShouldStop(8192);
_gradient.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"RIGHT_LEFT")),(Object)(RemoteObject.createNewArray("int",new int[] {2},new Object[] {device.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 185)),(Object)(BA.numberCast(int.class, 46)),(Object)(BA.numberCast(int.class, 52))),device.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 61)),(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 2)))})));
 BA.debugLineNum = 143;BA.debugLine="Panel2.Background = gradient";
Debug.ShouldStop(16384);
device.mostCurrent._panel2.runMethod(false,"setBackground",(_gradient.getObject()));
 BA.debugLineNum = 145;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(65536);
_loadcompanydata();
 BA.debugLineNum = 146;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("Activity_Pause (device) ","device",4,device.mostCurrent.activityBA,device.mostCurrent,357);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.device.remoteMe.runUserSub(false, "device","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 357;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16);
 BA.debugLineNum = 358;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("Activity_Resume (device) ","device",4,device.mostCurrent.activityBA,device.mostCurrent,354);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.device.remoteMe.runUserSub(false, "device","activity_resume");}
 BA.debugLineNum = 354;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2);
 BA.debugLineNum = 355;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _backbtn_click() throws Exception{
try {
		Debug.PushSubsStack("backBtn_Click (device) ","device",4,device.mostCurrent.activityBA,device.mostCurrent,163);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.example.device.remoteMe.runUserSub(false, "device","backbtn_click");}
 BA.debugLineNum = 163;BA.debugLine="Private Sub backBtn_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 164;BA.debugLine="If pageNo > 1 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean(">",device._pageno,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 165;BA.debugLine="pageNo = pageNo - 1";
Debug.ShouldStop(16);
device._pageno = RemoteObject.solve(new RemoteObject[] {device._pageno,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 166;BA.debugLine="num = 1";
Debug.ShouldStop(32);
device._num = BA.numberCast(int.class, 1);
 BA.debugLineNum = 167;BA.debugLine="pageLabel.Text = pageNo";
Debug.ShouldStop(64);
device.mostCurrent._pagelabel.runMethod(true,"setText",BA.ObjectToCharSequence(device._pageno));
 BA.debugLineNum = 168;BA.debugLine="ScrollView1.Panel.RemoveAllViews";
Debug.ShouldStop(128);
device.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 169;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(256);
_loadcompanydata();
 };
 BA.debugLineNum = 171;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _branch_click() throws Exception{
try {
		Debug.PushSubsStack("branch_Click (device) ","device",4,device.mostCurrent.activityBA,device.mostCurrent,363);
if (RapidSub.canDelegate("branch_click")) { return b4a.example.device.remoteMe.runUserSub(false, "device","branch_click");}
 BA.debugLineNum = 363;BA.debugLine="Private Sub branch_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 364;BA.debugLine="StartActivity(\"Branch\")";
Debug.ShouldStop(2048);
device.mostCurrent.__c.runVoidMethod ("StartActivity",device.processBA,(Object)((RemoteObject.createImmutable("Branch"))));
 BA.debugLineNum = 365;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4096);
device.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 366;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 11;BA.debugLine="Dim limit As Int = 13";
device._limit = BA.numberCast(int.class, 13);
 //BA.debugLineNum = 12;BA.debugLine="Private ScrollView1 As ScrollView";
device.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 13;BA.debugLine="Private ScrollViewPanel As Panel";
device.mostCurrent._scrollviewpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 14;BA.debugLine="Dim TableDetails As List";
device.mostCurrent._tabledetails = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 15;BA.debugLine="Private LabelTitle As Label";
device.mostCurrent._labeltitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private Label1 As Label";
device.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Dim num As Int = 0";
device._num = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 18;BA.debugLine="Private Panel3 As Panel";
device.mostCurrent._panel3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Dim pageNo As Int = 1";
device._pageno = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 20;BA.debugLine="Dim pageLabel As Label";
device.mostCurrent._pagelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Dim PHPURL As String = \"https://192.168.8.117/Com";
device.mostCurrent._phpurl = BA.ObjectToString("https://192.168.8.117/Company/controller/device.php?action=get_device&id=27");
 //BA.debugLineNum = 22;BA.debugLine="Dim PHPURL As String";
device.mostCurrent._phpurl = RemoteObject.createImmutable("");
 //BA.debugLineNum = 23;BA.debugLine="Dim panelWidth As Int = 0";
device._panelwidth = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 24;BA.debugLine="Private Panel2 As Panel";
device.mostCurrent._panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private Panel1 As Panel";
device.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private Panel4 As Panel";
device.mostCurrent._panel4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim branches As Label";
device.mostCurrent._branches = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Dim devices As Label";
device.mostCurrent._devices = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Dim home As Label";
device.mostCurrent._home = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Dim tdleftPos As Int = 5dip";
device._tdleftpos = device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));
 //BA.debugLineNum = 31;BA.debugLine="Dim TotalLabel As Label";
device.mostCurrent._totallabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _home_click() throws Exception{
try {
		Debug.PushSubsStack("home_Click (device) ","device",4,device.mostCurrent.activityBA,device.mostCurrent,359);
if (RapidSub.canDelegate("home_click")) { return b4a.example.device.remoteMe.runUserSub(false, "device","home_click");}
 BA.debugLineNum = 359;BA.debugLine="Private Sub home_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 360;BA.debugLine="StartActivity(\"Main\")";
Debug.ShouldStop(128);
device.mostCurrent.__c.runVoidMethod ("StartActivity",device.processBA,(Object)((RemoteObject.createImmutable("Main"))));
 BA.debugLineNum = 361;BA.debugLine="Activity.Finish";
Debug.ShouldStop(256);
device.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 362;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (device) ","device",4,device.mostCurrent.activityBA,device.mostCurrent,183);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.device.remoteMe.runUserSub(false, "device","jobdone", _job);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _ypos = RemoteObject.createImmutable(0);
RemoteObject _margin = RemoteObject.createImmutable(0);
RemoteObject _totalheight = RemoteObject.createImmutable(0);
RemoteObject _totaldevices = RemoteObject.createImmutable(0);
RemoteObject _tdfontsize = RemoteObject.createImmutable(0);
RemoteObject _record = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _serial_num = RemoteObject.createImmutable("");
RemoteObject _sales1 = RemoteObject.createImmutable("");
RemoteObject _sales2 = RemoteObject.createImmutable("");
RemoteObject _sales3 = RemoteObject.createImmutable("");
RemoteObject _id = RemoteObject.createImmutable(0);
RemoteObject _comname = RemoteObject.createImmutable("");
RemoteObject _itempanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _number = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _devicelabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _seriallabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sale = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sale1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sale2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _backbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _nxtlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("job", _job);
 BA.debugLineNum = 183;BA.debugLine="Sub JobDone(job As HttpJob)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 184;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(8388608);
device.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 185;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),device.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 186;BA.debugLine="Try";
Debug.ShouldStop(33554432);
try { BA.debugLineNum = 187;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(67108864);
device.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 188;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(134217728);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 189;BA.debugLine="parser.Initialize(job.GetString)";
Debug.ShouldStop(268435456);
_parser.runVoidMethod ("Initialize",(Object)(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ )));
 BA.debugLineNum = 190;BA.debugLine="TableDetails = parser.NextArray";
Debug.ShouldStop(536870912);
device.mostCurrent._tabledetails = _parser.runMethod(false,"NextArray");
 BA.debugLineNum = 191;BA.debugLine="ScrollViewPanel.RemoveAllViews";
Debug.ShouldStop(1073741824);
device.mostCurrent._scrollviewpanel.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 192;BA.debugLine="Dim YPos As Int = 0";
Debug.ShouldStop(-2147483648);
_ypos = BA.numberCast(int.class, 0);Debug.locals.put("YPos", _ypos);Debug.locals.put("YPos", _ypos);
 BA.debugLineNum = 193;BA.debugLine="Dim Margin As Int = 0dip";
Debug.ShouldStop(1);
_margin = device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("Margin", _margin);Debug.locals.put("Margin", _margin);
 BA.debugLineNum = 194;BA.debugLine="Dim TotalHeight As Int = 0";
Debug.ShouldStop(2);
_totalheight = BA.numberCast(int.class, 0);Debug.locals.put("TotalHeight", _totalheight);Debug.locals.put("TotalHeight", _totalheight);
 BA.debugLineNum = 195;BA.debugLine="Dim totalDevices As Int = 0";
Debug.ShouldStop(4);
_totaldevices = BA.numberCast(int.class, 0);Debug.locals.put("totalDevices", _totaldevices);Debug.locals.put("totalDevices", _totaldevices);
 BA.debugLineNum = 196;BA.debugLine="YPos = YPos + 0%y + Margin";
Debug.ShouldStop(8);
_ypos = RemoteObject.solve(new RemoteObject[] {_ypos,device.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 0)),device.mostCurrent.activityBA),_margin}, "++",2, 1);Debug.locals.put("YPos", _ypos);
 BA.debugLineNum = 197;BA.debugLine="Dim tdFontSize As Int = 13";
Debug.ShouldStop(16);
_tdfontsize = BA.numberCast(int.class, 13);Debug.locals.put("tdFontSize", _tdfontsize);Debug.locals.put("tdFontSize", _tdfontsize);
 BA.debugLineNum = 199;BA.debugLine="TotalLabel.Initialize(\"TotalLabel\")";
Debug.ShouldStop(64);
device.mostCurrent._totallabel.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("TotalLabel")));
 BA.debugLineNum = 200;BA.debugLine="For Each record As Map In TableDetails";
Debug.ShouldStop(128);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group16 = device.mostCurrent._tabledetails;
final int groupLen16 = group16.runMethod(true,"getSize").<Integer>get()
;int index16 = 0;
;
for (; index16 < groupLen16;index16++){
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group16.runMethod(false,"Get",index16));Debug.locals.put("record", _record);
Debug.locals.put("record", _record);
 BA.debugLineNum = 202;BA.debugLine="Dim serial_num As String = record.Get(\"serial\"";
Debug.ShouldStop(512);
_serial_num = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("serial")))));Debug.locals.put("serial_num", _serial_num);Debug.locals.put("serial_num", _serial_num);
 BA.debugLineNum = 203;BA.debugLine="Dim sales1 As String = record.Get(\"sales1\")";
Debug.ShouldStop(1024);
_sales1 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("sales1")))));Debug.locals.put("sales1", _sales1);Debug.locals.put("sales1", _sales1);
 BA.debugLineNum = 204;BA.debugLine="Dim sales2 As String = record.Get(\"sales2\")";
Debug.ShouldStop(2048);
_sales2 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("sales2")))));Debug.locals.put("sales2", _sales2);Debug.locals.put("sales2", _sales2);
 BA.debugLineNum = 205;BA.debugLine="Dim sales3 As String = record.Get(\"sales3\")";
Debug.ShouldStop(4096);
_sales3 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("sales3")))));Debug.locals.put("sales3", _sales3);Debug.locals.put("sales3", _sales3);
 BA.debugLineNum = 207;BA.debugLine="Dim id As Int = 0";
Debug.ShouldStop(16384);
_id = BA.numberCast(int.class, 0);Debug.locals.put("id", _id);Debug.locals.put("id", _id);
 BA.debugLineNum = 208;BA.debugLine="totalDevices = record.Get(\"totalDevices\")";
Debug.ShouldStop(32768);
_totaldevices = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("totalDevices")))));Debug.locals.put("totalDevices", _totaldevices);
 BA.debugLineNum = 209;BA.debugLine="Dim comName As String = record.Get(\"comName\")";
Debug.ShouldStop(65536);
_comname = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("comName")))));Debug.locals.put("comName", _comname);Debug.locals.put("comName", _comname);
 BA.debugLineNum = 210;BA.debugLine="LabelTitle.Text = record.Get(\"branchName\")";
Debug.ShouldStop(131072);
device.mostCurrent._labeltitle.runMethod(true,"setText",BA.ObjectToCharSequence(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("branchName"))))));
 BA.debugLineNum = 211;BA.debugLine="LabelTitle.Text = LabelTitle.Text.ToUpperCase";
Debug.ShouldStop(262144);
device.mostCurrent._labeltitle.runMethod(true,"setText",BA.ObjectToCharSequence(device.mostCurrent._labeltitle.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 213;BA.debugLine="Label1.Text = comName";
Debug.ShouldStop(1048576);
device.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(_comname));
 BA.debugLineNum = 214;BA.debugLine="Label1.Text = Label1.Text.ToUpperCase";
Debug.ShouldStop(2097152);
device.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(device.mostCurrent._label1.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 216;BA.debugLine="branches.Text = \"Branches - \"&comName&\" |\"";
Debug.ShouldStop(8388608);
device.mostCurrent._branches.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Branches - "),_comname,RemoteObject.createImmutable(" |"))));
 BA.debugLineNum = 217;BA.debugLine="branches.Text = branches.Text.ToUpperCase";
Debug.ShouldStop(16777216);
device.mostCurrent._branches.runMethod(true,"setText",BA.ObjectToCharSequence(device.mostCurrent._branches.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 219;BA.debugLine="devices.Text = \"Devices - \"&record.Get(\"branch";
Debug.ShouldStop(67108864);
device.mostCurrent._devices.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Devices - "),_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("branchName")))))));
 BA.debugLineNum = 220;BA.debugLine="devices.Text = devices.Text.ToUpperCase";
Debug.ShouldStop(134217728);
device.mostCurrent._devices.runMethod(true,"setText",BA.ObjectToCharSequence(device.mostCurrent._devices.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 222;BA.debugLine="Dim ItemPanel As Panel";
Debug.ShouldStop(536870912);
_itempanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("ItemPanel", _itempanel);
 BA.debugLineNum = 223;BA.debugLine="ItemPanel.Initialize(\"\")";
Debug.ShouldStop(1073741824);
_itempanel.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 224;BA.debugLine="ItemPanel.SetLayout(0, YPos, ScrollView1.Width";
Debug.ShouldStop(-2147483648);
_itempanel.runVoidMethod ("SetLayout",(Object)(BA.numberCast(int.class, 0)),(Object)(_ypos),(Object)(device.mostCurrent._scrollview1.runMethod(true,"getWidth")),(Object)(device.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 18)),device.mostCurrent.activityBA)));
 BA.debugLineNum = 225;BA.debugLine="ScrollView1.Panel.AddView(ItemPanel, 0, YPos,";
Debug.ShouldStop(1);
device.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_itempanel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_ypos),(Object)(device.mostCurrent._scrollview1.runMethod(true,"getWidth")),(Object)(device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))));
 BA.debugLineNum = 226;BA.debugLine="panelWidth = ItemPanel.Width /6";
Debug.ShouldStop(2);
device._panelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_itempanel.runMethod(true,"getWidth"),RemoteObject.createImmutable(6)}, "/",0, 0));
 BA.debugLineNum = 227;BA.debugLine="If num Mod 2 = 0 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {device._num,RemoteObject.createImmutable(2)}, "%",0, 1),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 228;BA.debugLine="ItemPanel.Color = Colors.LightGray";
Debug.ShouldStop(8);
_itempanel.runVoidMethod ("setColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"LightGray"));
 }else {
 BA.debugLineNum = 230;BA.debugLine="ItemPanel.Color = Colors.ARGB(255, 251, 251,";
Debug.ShouldStop(32);
_itempanel.runVoidMethod ("setColor",device.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 251)),(Object)(BA.numberCast(int.class, 251)),(Object)(BA.numberCast(int.class, 251))));
 };
 BA.debugLineNum = 233;BA.debugLine="Dim number As Label";
Debug.ShouldStop(256);
_number = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("number", _number);
 BA.debugLineNum = 234;BA.debugLine="number.Initialize(\"\")";
Debug.ShouldStop(512);
_number.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 235;BA.debugLine="number.Text = id";
Debug.ShouldStop(1024);
_number.runMethod(true,"setText",BA.ObjectToCharSequence(_id));
 BA.debugLineNum = 236;BA.debugLine="number.TextSize = tdFontSize";
Debug.ShouldStop(2048);
_number.runMethod(true,"setTextSize",BA.numberCast(float.class, _tdfontsize));
 BA.debugLineNum = 237;BA.debugLine="number.TextColor = Colors.Black";
Debug.ShouldStop(4096);
_number.runMethod(true,"setTextColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 238;BA.debugLine="number.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(8192);
_number.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 239;BA.debugLine="number.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(16384);
_number.runMethod(false,"setTypeface",device.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 240;BA.debugLine="ItemPanel.AddView(number, tdleftPos, 0, panelW";
Debug.ShouldStop(32768);
_itempanel.runVoidMethod ("AddView",(Object)((_number.getObject())),(Object)(device._tdleftpos),(Object)(BA.numberCast(int.class, 0)),(Object)(device._panelwidth),(Object)(_itempanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 242;BA.debugLine="Dim deviceLabel As Label";
Debug.ShouldStop(131072);
_devicelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("deviceLabel", _devicelabel);
 BA.debugLineNum = 243;BA.debugLine="deviceLabel.Initialize(\"\")";
Debug.ShouldStop(262144);
_devicelabel.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 244;BA.debugLine="deviceLabel.Text = \"Pos0\"&id";
Debug.ShouldStop(524288);
_devicelabel.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Pos0"),_id)));
 BA.debugLineNum = 245;BA.debugLine="deviceLabel.TextSize = tdFontSize";
Debug.ShouldStop(1048576);
_devicelabel.runMethod(true,"setTextSize",BA.numberCast(float.class, _tdfontsize));
 BA.debugLineNum = 246;BA.debugLine="deviceLabel.TextColor = Colors.Black";
Debug.ShouldStop(2097152);
_devicelabel.runMethod(true,"setTextColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 247;BA.debugLine="deviceLabel.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(4194304);
_devicelabel.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 248;BA.debugLine="ItemPanel.AddView(deviceLabel, panelWidth, 0,";
Debug.ShouldStop(8388608);
_itempanel.runVoidMethod ("AddView",(Object)((_devicelabel.getObject())),(Object)(device._panelwidth),(Object)(BA.numberCast(int.class, 0)),(Object)(device._panelwidth),(Object)(_itempanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 250;BA.debugLine="Dim serialLabel As Label";
Debug.ShouldStop(33554432);
_seriallabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("serialLabel", _seriallabel);
 BA.debugLineNum = 251;BA.debugLine="serialLabel.Initialize(\"\")";
Debug.ShouldStop(67108864);
_seriallabel.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 252;BA.debugLine="serialLabel.Text = serial_num";
Debug.ShouldStop(134217728);
_seriallabel.runMethod(true,"setText",BA.ObjectToCharSequence(_serial_num));
 BA.debugLineNum = 253;BA.debugLine="serialLabel.TextSize = tdFontSize";
Debug.ShouldStop(268435456);
_seriallabel.runMethod(true,"setTextSize",BA.numberCast(float.class, _tdfontsize));
 BA.debugLineNum = 254;BA.debugLine="serialLabel.TextColor = Colors.Black";
Debug.ShouldStop(536870912);
_seriallabel.runMethod(true,"setTextColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 255;BA.debugLine="serialLabel.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(1073741824);
_seriallabel.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 256;BA.debugLine="ItemPanel.AddView(serialLabel, panelWidth*2, 0";
Debug.ShouldStop(-2147483648);
_itempanel.runVoidMethod ("AddView",(Object)((_seriallabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {device._panelwidth,RemoteObject.createImmutable(2)}, "*",0, 1)),(Object)(BA.numberCast(int.class, 0)),(Object)(device._panelwidth),(Object)(_itempanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 258;BA.debugLine="Dim sale As Label";
Debug.ShouldStop(2);
_sale = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale", _sale);
 BA.debugLineNum = 259;BA.debugLine="sale.Initialize(\"\")";
Debug.ShouldStop(4);
_sale.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 260;BA.debugLine="sale.Text = sales1";
Debug.ShouldStop(8);
_sale.runMethod(true,"setText",BA.ObjectToCharSequence(_sales1));
 BA.debugLineNum = 261;BA.debugLine="sale.TextSize = tdFontSize";
Debug.ShouldStop(16);
_sale.runMethod(true,"setTextSize",BA.numberCast(float.class, _tdfontsize));
 BA.debugLineNum = 262;BA.debugLine="sale.TextColor = Colors.Black";
Debug.ShouldStop(32);
_sale.runMethod(true,"setTextColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 263;BA.debugLine="sale.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(64);
_sale.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 264;BA.debugLine="ItemPanel.AddView(sale, panelWidth*3, 0, panel";
Debug.ShouldStop(128);
_itempanel.runVoidMethod ("AddView",(Object)((_sale.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {device._panelwidth,RemoteObject.createImmutable(3)}, "*",0, 1)),(Object)(BA.numberCast(int.class, 0)),(Object)(device._panelwidth),(Object)(_itempanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 266;BA.debugLine="Dim sale1 As Label";
Debug.ShouldStop(512);
_sale1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale1", _sale1);
 BA.debugLineNum = 267;BA.debugLine="sale1.Initialize(\"\")";
Debug.ShouldStop(1024);
_sale1.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 268;BA.debugLine="sale1.Text = sales2";
Debug.ShouldStop(2048);
_sale1.runMethod(true,"setText",BA.ObjectToCharSequence(_sales2));
 BA.debugLineNum = 269;BA.debugLine="sale1.TextSize = tdFontSize";
Debug.ShouldStop(4096);
_sale1.runMethod(true,"setTextSize",BA.numberCast(float.class, _tdfontsize));
 BA.debugLineNum = 270;BA.debugLine="sale1.TextColor = Colors.Black";
Debug.ShouldStop(8192);
_sale1.runMethod(true,"setTextColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 271;BA.debugLine="sale1.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(16384);
_sale1.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 272;BA.debugLine="ItemPanel.AddView(sale1, panelWidth*4, 0, pane";
Debug.ShouldStop(32768);
_itempanel.runVoidMethod ("AddView",(Object)((_sale1.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {device._panelwidth,RemoteObject.createImmutable(4)}, "*",0, 1)),(Object)(BA.numberCast(int.class, 0)),(Object)(device._panelwidth),(Object)(_itempanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 274;BA.debugLine="Dim sale2 As Label";
Debug.ShouldStop(131072);
_sale2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale2", _sale2);
 BA.debugLineNum = 275;BA.debugLine="sale2.Initialize(\"\")";
Debug.ShouldStop(262144);
_sale2.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 276;BA.debugLine="sale2.Text = sales3";
Debug.ShouldStop(524288);
_sale2.runMethod(true,"setText",BA.ObjectToCharSequence(_sales3));
 BA.debugLineNum = 277;BA.debugLine="sale2.TextSize = tdFontSize";
Debug.ShouldStop(1048576);
_sale2.runMethod(true,"setTextSize",BA.numberCast(float.class, _tdfontsize));
 BA.debugLineNum = 278;BA.debugLine="sale2.TextColor = Colors.Black";
Debug.ShouldStop(2097152);
_sale2.runMethod(true,"setTextColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 279;BA.debugLine="sale2.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(4194304);
_sale2.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 280;BA.debugLine="ItemPanel.AddView(sale2, panelWidth*5, 0, pane";
Debug.ShouldStop(8388608);
_itempanel.runVoidMethod ("AddView",(Object)((_sale2.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {device._panelwidth,RemoteObject.createImmutable(5)}, "*",0, 1)),(Object)(BA.numberCast(int.class, 0)),(Object)(device._panelwidth),(Object)(_itempanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 282;BA.debugLine="Dim backBtn As Label";
Debug.ShouldStop(33554432);
_backbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("backBtn", _backbtn);
 BA.debugLineNum = 283;BA.debugLine="backBtn.Initialize(\"backBtn\")";
Debug.ShouldStop(67108864);
_backbtn.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("backBtn")));
 BA.debugLineNum = 284;BA.debugLine="backBtn.TextColor =Colors.White";
Debug.ShouldStop(134217728);
_backbtn.runMethod(true,"setTextColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 285;BA.debugLine="backBtn.Text = \"<\"";
Debug.ShouldStop(268435456);
_backbtn.runMethod(true,"setText",BA.ObjectToCharSequence("<"));
 BA.debugLineNum = 286;BA.debugLine="backBtn.Gravity = Gravity.CENTER";
Debug.ShouldStop(536870912);
_backbtn.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 287;BA.debugLine="backBtn.Typeface = Typeface.SERIF";
Debug.ShouldStop(1073741824);
_backbtn.runMethod(false,"setTypeface",device.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 288;BA.debugLine="backBtn.Color = Colors.Black";
Debug.ShouldStop(-2147483648);
_backbtn.runVoidMethod ("setColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 289;BA.debugLine="backBtn.TextSize = 25";
Debug.ShouldStop(1);
_backbtn.runMethod(true,"setTextSize",BA.numberCast(float.class, 25));
 BA.debugLineNum = 290;BA.debugLine="Panel3.AddView(backBtn,3dip,5dip,50dip,Panel3.";
Debug.ShouldStop(2);
device.mostCurrent._panel3.runVoidMethod ("AddView",(Object)((_backbtn.getObject())),(Object)(device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 3)))),(Object)(device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))),(Object)(RemoteObject.solve(new RemoteObject[] {device.mostCurrent._panel3.runMethod(true,"getHeight"),device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1)));
 BA.debugLineNum = 292;BA.debugLine="pageLabel.Initialize(\"pageLabel\")";
Debug.ShouldStop(8);
device.mostCurrent._pagelabel.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("pageLabel")));
 BA.debugLineNum = 293;BA.debugLine="pageLabel.TextColor =Colors.Black";
Debug.ShouldStop(16);
device.mostCurrent._pagelabel.runMethod(true,"setTextColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 294;BA.debugLine="pageLabel.Text = pageNo";
Debug.ShouldStop(32);
device.mostCurrent._pagelabel.runMethod(true,"setText",BA.ObjectToCharSequence(device._pageno));
 BA.debugLineNum = 295;BA.debugLine="pageLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(64);
device.mostCurrent._pagelabel.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 296;BA.debugLine="pageLabel.Typeface = Typeface.DEFAULT_BOLD";
Debug.ShouldStop(128);
device.mostCurrent._pagelabel.runMethod(false,"setTypeface",device.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 297;BA.debugLine="pageLabel.Color = Colors.white";
Debug.ShouldStop(256);
device.mostCurrent._pagelabel.runVoidMethod ("setColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 298;BA.debugLine="pageLabel.TextSize = 15";
Debug.ShouldStop(512);
device.mostCurrent._pagelabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 299;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(1024);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 300;BA.debugLine="cd.Initialize2(Colors.White, 5dip, 2dip, Color";
Debug.ShouldStop(2048);
_cd.runVoidMethod ("Initialize2",(Object)(device.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(device.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 301;BA.debugLine="Panel3.AddView(pageLabel,backBtn.Width+backBtn";
Debug.ShouldStop(4096);
device.mostCurrent._panel3.runVoidMethod ("AddView",(Object)((device.mostCurrent._pagelabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_backbtn.runMethod(true,"getWidth"),_backbtn.runMethod(true,"getLeft"),device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "++",2, 1)),(Object)(device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))),(Object)(RemoteObject.solve(new RemoteObject[] {device.mostCurrent._panel3.runMethod(true,"getHeight"),device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)));
 BA.debugLineNum = 303;BA.debugLine="Dim nxtLabel As Label";
Debug.ShouldStop(16384);
_nxtlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("nxtLabel", _nxtlabel);
 BA.debugLineNum = 304;BA.debugLine="nxtLabel.Initialize(\"nxtLabel\")";
Debug.ShouldStop(32768);
_nxtlabel.runVoidMethod ("Initialize",device.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("nxtLabel")));
 BA.debugLineNum = 305;BA.debugLine="nxtLabel.TextColor =Colors.White";
Debug.ShouldStop(65536);
_nxtlabel.runMethod(true,"setTextColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 306;BA.debugLine="nxtLabel.Text = \">\"";
Debug.ShouldStop(131072);
_nxtlabel.runMethod(true,"setText",BA.ObjectToCharSequence(">"));
 BA.debugLineNum = 307;BA.debugLine="nxtLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(262144);
_nxtlabel.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 308;BA.debugLine="nxtLabel.Typeface = Typeface.SERIF";
Debug.ShouldStop(524288);
_nxtlabel.runMethod(false,"setTypeface",device.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 309;BA.debugLine="nxtLabel.Color = Colors.black";
Debug.ShouldStop(1048576);
_nxtlabel.runVoidMethod ("setColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 310;BA.debugLine="nxtLabel.TextSize = 25";
Debug.ShouldStop(2097152);
_nxtlabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 25));
 BA.debugLineNum = 311;BA.debugLine="Panel3.AddView(nxtLabel,pageLabel.Width+pageLa";
Debug.ShouldStop(4194304);
device.mostCurrent._panel3.runVoidMethod ("AddView",(Object)((_nxtlabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {device.mostCurrent._pagelabel.runMethod(true,"getWidth"),device.mostCurrent._pagelabel.runMethod(true,"getLeft"),device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "++",2, 1)),(Object)(device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))),(Object)(RemoteObject.solve(new RemoteObject[] {device.mostCurrent._panel3.runMethod(true,"getHeight"),device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1)));
 BA.debugLineNum = 313;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(16777216);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 314;BA.debugLine="cd.Initialize2(Colors.Black, 5dip, 2dip, Color";
Debug.ShouldStop(33554432);
_cd.runVoidMethod ("Initialize2",(Object)(device.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")),(Object)(device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(device.mostCurrent.__c.getField(false,"Colors").getField(true,"White")));
 BA.debugLineNum = 315;BA.debugLine="backBtn.Background = cd";
Debug.ShouldStop(67108864);
_backbtn.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 316;BA.debugLine="nxtLabel.Background = cd";
Debug.ShouldStop(134217728);
_nxtlabel.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 320;BA.debugLine="YPos = YPos + ItemPanel.Height + Margin ' Upda";
Debug.ShouldStop(-2147483648);
_ypos = RemoteObject.solve(new RemoteObject[] {_ypos,_itempanel.runMethod(true,"getHeight"),_margin}, "++",2, 1);Debug.locals.put("YPos", _ypos);
 BA.debugLineNum = 321;BA.debugLine="nxtLabel.Enabled = False";
Debug.ShouldStop(1);
_nxtlabel.runMethod(true,"setEnabled",device.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 322;BA.debugLine="If limit * pageNo < totalDevices Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("<",RemoteObject.solve(new RemoteObject[] {device._limit,device._pageno}, "*",0, 1),BA.numberCast(double.class, _totaldevices))) { 
 BA.debugLineNum = 323;BA.debugLine="nxtLabel.Enabled = True";
Debug.ShouldStop(4);
_nxtlabel.runMethod(true,"setEnabled",device.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 327;BA.debugLine="TotalHeight = TotalHeight + 65dip";
Debug.ShouldStop(64);
_totalheight = RemoteObject.solve(new RemoteObject[] {_totalheight,device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 65)))}, "+",1, 1);Debug.locals.put("TotalHeight", _totalheight);
 BA.debugLineNum = 328;BA.debugLine="ScrollView1.Panel.Height =TotalHeight";
Debug.ShouldStop(128);
device.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",_totalheight);
 BA.debugLineNum = 329;BA.debugLine="num = num +1";
Debug.ShouldStop(256);
device._num = RemoteObject.solve(new RemoteObject[] {device._num,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 330;BA.debugLine="TotalLabel.Text = \"\"";
Debug.ShouldStop(512);
device.mostCurrent._totallabel.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 }
}Debug.locals.put("record", _record);
;
 BA.debugLineNum = 334;BA.debugLine="TotalLabel.RemoveView";
Debug.ShouldStop(8192);
device.mostCurrent._totallabel.runVoidMethod ("RemoveView");
 BA.debugLineNum = 335;BA.debugLine="TotalLabel.TextColor =Colors.White";
Debug.ShouldStop(16384);
device.mostCurrent._totallabel.runMethod(true,"setTextColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 336;BA.debugLine="TotalLabel.Text = num&\" out of \"&totalDevices&\"";
Debug.ShouldStop(32768);
device.mostCurrent._totallabel.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(device._num,RemoteObject.createImmutable(" out of "),_totaldevices,RemoteObject.createImmutable(" devices"))));
 BA.debugLineNum = 337;BA.debugLine="TotalLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(65536);
device.mostCurrent._totallabel.runMethod(true,"setGravity",device.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 338;BA.debugLine="TotalLabel.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(131072);
device.mostCurrent._totallabel.runMethod(false,"setTypeface",device.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 339;BA.debugLine="TotalLabel.Color = Colors.Transparent";
Debug.ShouldStop(262144);
device.mostCurrent._totallabel.runVoidMethod ("setColor",device.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 340;BA.debugLine="TotalLabel.TextSize = 15";
Debug.ShouldStop(524288);
device.mostCurrent._totallabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 342;BA.debugLine="Panel3.AddView(TotalLabel,Panel3.Width-240dip,5";
Debug.ShouldStop(2097152);
device.mostCurrent._panel3.runVoidMethod ("AddView",(Object)((device.mostCurrent._totallabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {device.mostCurrent._panel3.runMethod(true,"getWidth"),device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 240)))}, "-",1, 1)),(Object)(device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 230)))),(Object)(RemoteObject.solve(new RemoteObject[] {device.mostCurrent._panel3.runMethod(true,"getHeight"),device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e136) {
			BA.rdebugUtils.runVoidMethod("setLastException",device.processBA, e136.toString()); };
 }else {
 BA.debugLineNum = 348;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
Debug.ShouldStop(134217728);
device.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(device.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 351;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("LoadCompanyData (device) ","device",4,device.mostCurrent.activityBA,device.mostCurrent,155);
if (RapidSub.canDelegate("loadcompanydata")) { return b4a.example.device.remoteMe.runUserSub(false, "device","loadcompanydata");}
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 155;BA.debugLine="Sub LoadCompanyData";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 157;BA.debugLine="Log(PHPURL)";
Debug.ShouldStop(268435456);
device.mostCurrent.__c.runVoidMethod ("LogImpl","24390914",device.mostCurrent._phpurl,0);
 BA.debugLineNum = 158;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(536870912);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 159;BA.debugLine="Job1.Initialize(\"\", Me)";
Debug.ShouldStop(1073741824);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,device.processBA,(Object)(BA.ObjectToString("")),(Object)(device.getObject()));
 BA.debugLineNum = 160;BA.debugLine="Job1.Download(PHPURL)";
Debug.ShouldStop(-2147483648);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(device.mostCurrent._phpurl));
 BA.debugLineNum = 161;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _nxtlabel_click() throws Exception{
try {
		Debug.PushSubsStack("nxtLabel_Click (device) ","device",4,device.mostCurrent.activityBA,device.mostCurrent,174);
if (RapidSub.canDelegate("nxtlabel_click")) { return b4a.example.device.remoteMe.runUserSub(false, "device","nxtlabel_click");}
 BA.debugLineNum = 174;BA.debugLine="Private Sub nxtLabel_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 175;BA.debugLine="pageNo = pageNo + 1";
Debug.ShouldStop(16384);
device._pageno = RemoteObject.solve(new RemoteObject[] {device._pageno,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 176;BA.debugLine="pageLabel.Text = pageNo";
Debug.ShouldStop(32768);
device.mostCurrent._pagelabel.runMethod(true,"setText",BA.ObjectToCharSequence(device._pageno));
 BA.debugLineNum = 177;BA.debugLine="ScrollView1.Panel.RemoveAllViews";
Debug.ShouldStop(65536);
device.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 178;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
Debug.ShouldStop(131072);
device.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",device.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Data..."))));
 BA.debugLineNum = 179;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(262144);
_loadcompanydata();
 BA.debugLineNum = 180;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private xui As XUI";
device._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _responsivelabel(RemoteObject _label) throws Exception{
try {
		Debug.PushSubsStack("responsiveLabel (device) ","device",4,device.mostCurrent.activityBA,device.mostCurrent,148);
if (RapidSub.canDelegate("responsivelabel")) { return b4a.example.device.remoteMe.runUserSub(false, "device","responsivelabel", _label);}
RemoteObject _charwidth = RemoteObject.createImmutable(0);
RemoteObject _padding = RemoteObject.createImmutable(0);
RemoteObject _homewidth = RemoteObject.createImmutable(0);
Debug.locals.put("label", _label);
 BA.debugLineNum = 148;BA.debugLine="Sub responsiveLabel(label As Label) As Int";
Debug.ShouldStop(524288);
 BA.debugLineNum = 149;BA.debugLine="Dim charWidth As Int = 10dip";
Debug.ShouldStop(1048576);
_charwidth = device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("charWidth", _charwidth);Debug.locals.put("charWidth", _charwidth);
 BA.debugLineNum = 150;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(2097152);
_padding = device.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 151;BA.debugLine="Dim homeWidth As Int = (label.Text.Length * charW";
Debug.ShouldStop(4194304);
_homewidth = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_label.runMethod(true,"getText").runMethod(true,"length"),_charwidth}, "*",0, 1)),_padding}, "+",1, 1);Debug.locals.put("homeWidth", _homewidth);Debug.locals.put("homeWidth", _homewidth);
 BA.debugLineNum = 152;BA.debugLine="Return homeWidth";
Debug.ShouldStop(8388608);
Debug.CheckDeviceExceptions();if (true) return _homewidth;
 BA.debugLineNum = 153;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}