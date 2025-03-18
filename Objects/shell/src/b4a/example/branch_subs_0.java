package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class branch_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,53);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","activity_create", _firsttime);}
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _leftposition = RemoteObject.createImmutable(0);
RemoteObject _closebutton = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _myimage = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _imgview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _popuptext = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _popupdirectiontext = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _edit_button = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _cdback = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 53;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="Activity.LoadLayout(\"Branch\")";
Debug.ShouldStop(2097152);
branch.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Branch")),branch.mostCurrent.activityBA);
 BA.debugLineNum = 55;BA.debugLine="home.Initialize(\"home\")";
Debug.ShouldStop(4194304);
branch.mostCurrent._home.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("home")));
 BA.debugLineNum = 56;BA.debugLine="home.Text = \"HOME |\"";
Debug.ShouldStop(8388608);
branch.mostCurrent._home.runMethod(true,"setText",BA.ObjectToCharSequence("HOME |"));
 BA.debugLineNum = 57;BA.debugLine="home.TextColor = Colors.Black";
Debug.ShouldStop(16777216);
branch.mostCurrent._home.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 58;BA.debugLine="home.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(33554432);
branch.mostCurrent._home.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 59;BA.debugLine="home.Gravity = Gravity.CENTER";
Debug.ShouldStop(67108864);
branch.mostCurrent._home.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 60;BA.debugLine="home.TextSize = 16";
Debug.ShouldStop(134217728);
branch.mostCurrent._home.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 61;BA.debugLine="Panel3.AddView(home, 0, 0, responsiveLabel(home),";
Debug.ShouldStop(268435456);
branch.mostCurrent._panel3.runVoidMethod ("AddView",(Object)((branch.mostCurrent._home.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_responsivelabel(branch.mostCurrent._home)),(Object)(branch.mostCurrent._panel3.runMethod(true,"getHeight")));
 BA.debugLineNum = 62;BA.debugLine="Panel3.Color = Colors.Transparent";
Debug.ShouldStop(536870912);
branch.mostCurrent._panel3.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 64;BA.debugLine="branches.Initialize(\"\")";
Debug.ShouldStop(-2147483648);
branch.mostCurrent._branches.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 65;BA.debugLine="branches.Text = \"Branches\"";
Debug.ShouldStop(1);
branch.mostCurrent._branches.runMethod(true,"setText",BA.ObjectToCharSequence("Branches"));
 BA.debugLineNum = 66;BA.debugLine="branches.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(2);
branch.mostCurrent._branches.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 67;BA.debugLine="branches.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(4);
branch.mostCurrent._branches.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 68;BA.debugLine="branches.TextSize = 16";
Debug.ShouldStop(8);
branch.mostCurrent._branches.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 69;BA.debugLine="Panel3.AddView(branches, responsiveLabel(home), 0";
Debug.ShouldStop(16);
branch.mostCurrent._panel3.runVoidMethod ("AddView",(Object)((branch.mostCurrent._branches.getObject())),(Object)(_responsivelabel(branch.mostCurrent._home)),(Object)(BA.numberCast(int.class, 0)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))),(Object)(branch.mostCurrent._panel3.runMethod(true,"getHeight")));
 BA.debugLineNum = 71;BA.debugLine="popupPanel.Initialize(\"\")";
Debug.ShouldStop(64);
branch.mostCurrent._popuppanel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 72;BA.debugLine="popupPanel.Color = Colors.ARGB(200, 0, 0, 0)";
Debug.ShouldStop(128);
branch.mostCurrent._popuppanel.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 200)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 73;BA.debugLine="popupPanel.Visible = False";
Debug.ShouldStop(256);
branch.mostCurrent._popuppanel.runMethod(true,"setVisible",branch.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 74;BA.debugLine="Activity.AddView(popupPanel, 0, 0, Activity.Width";
Debug.ShouldStop(512);
branch.mostCurrent._activity.runVoidMethod ("AddView",(Object)((branch.mostCurrent._popuppanel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(branch.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(branch.mostCurrent._activity.runMethod(true,"getHeight")));
 BA.debugLineNum = 76;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(2048);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 77;BA.debugLine="cd.Initialize2(Colors.White, 5dip, 1dip, Colors.B";
Debug.ShouldStop(4096);
_cd.runVoidMethod ("Initialize2",(Object)(branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))),(Object)(branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 80;BA.debugLine="popupPanelBackground.Initialize(\"\")";
Debug.ShouldStop(32768);
branch.mostCurrent._popuppanelbackground.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 81;BA.debugLine="popupPanelBackground.Color = Colors.White";
Debug.ShouldStop(65536);
branch.mostCurrent._popuppanelbackground.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 82;BA.debugLine="popupPanel.AddView(popupPanelBackground, 70dip, 5";
Debug.ShouldStop(131072);
branch.mostCurrent._popuppanel.runVoidMethod ("AddView",(Object)((branch.mostCurrent._popuppanelbackground.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 550)))),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._activity.runMethod(true,"getHeight"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 500)))}, "-",1, 1)));
 BA.debugLineNum = 85;BA.debugLine="Dim leftPosition As Int = (popupPanel.Width - pop";
Debug.ShouldStop(1048576);
_leftposition = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._popuppanel.runMethod(true,"getWidth"),branch.mostCurrent._popuppanelbackground.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("leftPosition", _leftposition);Debug.locals.put("leftPosition", _leftposition);
 BA.debugLineNum = 86;BA.debugLine="popupPanelBackground.Left = leftPosition";
Debug.ShouldStop(2097152);
branch.mostCurrent._popuppanelbackground.runMethod(true,"setLeft",_leftposition);
 BA.debugLineNum = 90;BA.debugLine="Dim closeButton As Label";
Debug.ShouldStop(33554432);
_closebutton = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("closeButton", _closebutton);
 BA.debugLineNum = 91;BA.debugLine="closeButton.Initialize(\"closeButton\")";
Debug.ShouldStop(67108864);
_closebutton.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("closeButton")));
 BA.debugLineNum = 92;BA.debugLine="closeButton.Text = \"X\"";
Debug.ShouldStop(134217728);
_closebutton.runMethod(true,"setText",BA.ObjectToCharSequence("X"));
 BA.debugLineNum = 93;BA.debugLine="closeButton.TextSize = 15";
Debug.ShouldStop(268435456);
_closebutton.runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 94;BA.debugLine="closeButton.TextColor = Colors.Red";
Debug.ShouldStop(536870912);
_closebutton.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 95;BA.debugLine="closeButton.Typeface = Typeface.DEFAULT_BOLD";
Debug.ShouldStop(1073741824);
_closebutton.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 96;BA.debugLine="closeButton.Gravity = Gravity.CENTER";
Debug.ShouldStop(-2147483648);
_closebutton.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 97;BA.debugLine="popupPanelBackground.AddView(closeButton, popupPa";
Debug.ShouldStop(1);
branch.mostCurrent._popuppanelbackground.runVoidMethod ("AddView",(Object)((_closebutton.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._popuppanelbackground.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)))}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 98;BA.debugLine="closeButton.Background = cd";
Debug.ShouldStop(2);
_closebutton.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 100;BA.debugLine="target_id_display.Initialize(\"target_id_display\")";
Debug.ShouldStop(8);
branch.mostCurrent._target_id_display.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("target_id_display")));
 BA.debugLineNum = 101;BA.debugLine="target_id_display.TextSize = 20";
Debug.ShouldStop(16);
branch.mostCurrent._target_id_display.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 102;BA.debugLine="target_id_display.TextColor = Colors.Red";
Debug.ShouldStop(32);
branch.mostCurrent._target_id_display.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 103;BA.debugLine="target_id_display.Typeface = Typeface.DEFAULT_BOL";
Debug.ShouldStop(64);
branch.mostCurrent._target_id_display.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 106;BA.debugLine="Dim myImage As Bitmap = LoadBitmap(File.DirAssets";
Debug.ShouldStop(512);
_myimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_myimage = branch.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(branch.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("store.PNG")));Debug.locals.put("myImage", _myimage);Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 107;BA.debugLine="Dim imgView As ImageView";
Debug.ShouldStop(1024);
_imgview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("imgView", _imgview);
 BA.debugLineNum = 108;BA.debugLine="imgView.Initialize(\"\")";
Debug.ShouldStop(2048);
_imgview.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 109;BA.debugLine="imgView.Gravity = Gravity.FILL";
Debug.ShouldStop(4096);
_imgview.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 110;BA.debugLine="imgView.Bitmap = myImage";
Debug.ShouldStop(8192);
_imgview.runMethod(false,"setBitmap",(_myimage.getObject()));
 BA.debugLineNum = 111;BA.debugLine="popupPanelBackground.AddView(imgView, 25%x, 12.5d";
Debug.ShouldStop(16384);
branch.mostCurrent._popuppanelbackground.runVoidMethod ("AddView",(Object)((_imgview.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 25)),branch.mostCurrent.activityBA)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12.5)))),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._popuppanelbackground.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),branch.mostCurrent.activityBA)}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))));
 BA.debugLineNum = 114;BA.debugLine="Dim popupText As Label";
Debug.ShouldStop(131072);
_popuptext = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("popupText", _popuptext);
 BA.debugLineNum = 115;BA.debugLine="popupText.Initialize(\"\")";
Debug.ShouldStop(262144);
_popuptext.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 116;BA.debugLine="popupText.Text = \"Modify Target Sales\"";
Debug.ShouldStop(524288);
_popuptext.runMethod(true,"setText",BA.ObjectToCharSequence("Modify Target Sales"));
 BA.debugLineNum = 117;BA.debugLine="popupText.TextColor = Colors.Black";
Debug.ShouldStop(1048576);
_popuptext.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 118;BA.debugLine="popupText.TextSize = 50";
Debug.ShouldStop(2097152);
_popuptext.runMethod(true,"setTextSize",BA.numberCast(float.class, 50));
 BA.debugLineNum = 119;BA.debugLine="popupText.Typeface = Typeface.DEFAULT_BOLD";
Debug.ShouldStop(4194304);
_popuptext.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 120;BA.debugLine="popupText.Gravity = Gravity.CENTER";
Debug.ShouldStop(8388608);
_popuptext.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 121;BA.debugLine="popupPanelBackground.AddView(popupText, 25dip, im";
Debug.ShouldStop(16777216);
branch.mostCurrent._popuppanelbackground.runVoidMethod ("AddView",(Object)((_popuptext.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(RemoteObject.solve(new RemoteObject[] {_imgview.runMethod(true,"getTop"),_imgview.runMethod(true,"getHeight")}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._popuppanelbackground.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 65)))));
 BA.debugLineNum = 123;BA.debugLine="Dim popupDirectionText As Label";
Debug.ShouldStop(67108864);
_popupdirectiontext = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("popupDirectionText", _popupdirectiontext);
 BA.debugLineNum = 124;BA.debugLine="popupDirectionText.Initialize(\"\")";
Debug.ShouldStop(134217728);
_popupdirectiontext.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 125;BA.debugLine="popupDirectionText.Text = \"Modify the sales targe";
Debug.ShouldStop(268435456);
_popupdirectiontext.runMethod(true,"setText",BA.ObjectToCharSequence("Modify the sales target and set a new goal for total company sales."));
 BA.debugLineNum = 126;BA.debugLine="popupDirectionText.TextColor = Colors.ARGB(150,0,";
Debug.ShouldStop(536870912);
_popupdirectiontext.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 150)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 127;BA.debugLine="popupDirectionText.TextSize = 15";
Debug.ShouldStop(1073741824);
_popupdirectiontext.runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 128;BA.debugLine="popupDirectionText.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(-2147483648);
_popupdirectiontext.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 129;BA.debugLine="popupDirectionText.Gravity = Gravity.CENTER";
Debug.ShouldStop(1);
_popupdirectiontext.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 130;BA.debugLine="popupPanelBackground.AddView(popupDirectionText,";
Debug.ShouldStop(2);
branch.mostCurrent._popuppanelbackground.runVoidMethod ("AddView",(Object)((_popupdirectiontext.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))),(Object)(RemoteObject.solve(new RemoteObject[] {_popuptext.runMethod(true,"getTop"),_popuptext.runMethod(true,"getHeight")}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._popuppanelbackground.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 132;BA.debugLine="target_countLabel.Initialize(\"\")";
Debug.ShouldStop(8);
branch.mostCurrent._target_countlabel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 134;BA.debugLine="target_countLabel.TextColor = Colors.Black";
Debug.ShouldStop(32);
branch.mostCurrent._target_countlabel.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 135;BA.debugLine="target_countLabel.TextSize = 25";
Debug.ShouldStop(64);
branch.mostCurrent._target_countlabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 25));
 BA.debugLineNum = 136;BA.debugLine="target_countLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(128);
branch.mostCurrent._target_countlabel.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 138;BA.debugLine="popupPanelBackground.AddView(target_countLabel, 5";
Debug.ShouldStop(512);
branch.mostCurrent._popuppanelbackground.runVoidMethod ("AddView",(Object)((branch.mostCurrent._target_countlabel.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))),(Object)(RemoteObject.solve(new RemoteObject[] {_popupdirectiontext.runMethod(true,"getTop"),_popupdirectiontext.runMethod(true,"getHeight")}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._popuppanelbackground.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 139;BA.debugLine="ScrollView1.Panel.Color = Colors.ARGB(255, 251, 2";
Debug.ShouldStop(1024);
branch.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 251)),(Object)(BA.numberCast(int.class, 251)),(Object)(BA.numberCast(int.class, 251))));
 BA.debugLineNum = 141;BA.debugLine="AddBottomBorderToLabel(target_countLabel)";
Debug.ShouldStop(4096);
_addbottombordertolabel(branch.mostCurrent._target_countlabel);
 BA.debugLineNum = 143;BA.debugLine="Dim edit_button As Button";
Debug.ShouldStop(16384);
_edit_button = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("edit_button", _edit_button);
 BA.debugLineNum = 144;BA.debugLine="edit_button.Initialize(\"edit_button\")";
Debug.ShouldStop(32768);
_edit_button.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("edit_button")));
 BA.debugLineNum = 145;BA.debugLine="edit_button.Text = \"Update\"";
Debug.ShouldStop(65536);
_edit_button.runMethod(true,"setText",BA.ObjectToCharSequence("Update"));
 BA.debugLineNum = 146;BA.debugLine="edit_button.TextColor = Colors.White";
Debug.ShouldStop(131072);
_edit_button.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 147;BA.debugLine="edit_button.TextSize = 25";
Debug.ShouldStop(262144);
_edit_button.runMethod(true,"setTextSize",BA.numberCast(float.class, 25));
 BA.debugLineNum = 148;BA.debugLine="edit_button.Gravity = Gravity.CENTER";
Debug.ShouldStop(524288);
_edit_button.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 149;BA.debugLine="popupPanelBackground.AddView(edit_button, 30%x, t";
Debug.ShouldStop(1048576);
branch.mostCurrent._popuppanelbackground.runVoidMethod ("AddView",(Object)((_edit_button.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 30)),branch.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._target_countlabel.runMethod(true,"getTop"),branch.mostCurrent._target_countlabel.runMethod(true,"getHeight"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))}, "++",2, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._popuppanelbackground.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),branch.mostCurrent.activityBA)}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 151;BA.debugLine="Dim cdBack As ColorDrawable";
Debug.ShouldStop(4194304);
_cdback = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cdBack", _cdback);
 BA.debugLineNum = 152;BA.debugLine="cdBack.Initialize2(Colors.RGB(61, 12, 2), 10dip,";
Debug.ShouldStop(8388608);
_cdback.runVoidMethod ("Initialize2",(Object)(branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 61)),(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 2)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")));
 BA.debugLineNum = 153;BA.debugLine="edit_button.Background = cdBack";
Debug.ShouldStop(16777216);
_edit_button.runMethod(false,"setBackground",(_cdback.getObject()));
 BA.debugLineNum = 159;BA.debugLine="purchasePanel.Initialize(\"\")";
Debug.ShouldStop(1073741824);
branch.mostCurrent._purchasepanel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 160;BA.debugLine="Panel4.AddView(purchasePanel, 0, 0dip, Activity.W";
Debug.ShouldStop(-2147483648);
branch.mostCurrent._panel4.runVoidMethod ("AddView",(Object)((branch.mostCurrent._purchasepanel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(branch.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 530)))));
 BA.debugLineNum = 161;BA.debugLine="purchasePanel.Color = Colors.White ' Set a visibl";
Debug.ShouldStop(1);
branch.mostCurrent._purchasepanel.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 163;BA.debugLine="scrollViewPanel4.Initialize(Panel4.Height - purch";
Debug.ShouldStop(4);
branch.mostCurrent._scrollviewpanel4.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._panel4.runMethod(true,"getHeight"),branch.mostCurrent._purchasepanel.runMethod(true,"getHeight")}, "-",1, 1)));
 BA.debugLineNum = 164;BA.debugLine="Panel4.AddView(scrollViewPanel4, 0, purchasePanel";
Debug.ShouldStop(8);
branch.mostCurrent._panel4.runVoidMethod ("AddView",(Object)((branch.mostCurrent._scrollviewpanel4.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(branch.mostCurrent._purchasepanel.runMethod(true,"getHeight")),(Object)(branch.mostCurrent._panel4.runMethod(true,"getWidth")),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._panel4.runMethod(true,"getHeight"),branch.mostCurrent._purchasepanel.runMethod(true,"getHeight")}, "-",1, 1)));
 BA.debugLineNum = 168;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(128);
_loadcompanydata();
 BA.debugLineNum = 169;BA.debugLine="LoadCompanyDataBranchGraph";
Debug.ShouldStop(256);
_loadcompanydatabranchgraph();
 BA.debugLineNum = 170;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("Activity_Pause (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,175);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 175;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 176;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("Activity_Resume (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,171);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","activity_resume");}
 BA.debugLineNum = 171;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1024);
 BA.debugLineNum = 173;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addbottombordertolabel(RemoteObject _lbl) throws Exception{
try {
		Debug.PushSubsStack("AddBottomBorderToLabel (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,728);
if (RapidSub.canDelegate("addbottombordertolabel")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","addbottombordertolabel", _lbl);}
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _cvs = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _bd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 728;BA.debugLine="Sub AddBottomBorderToLabel(lbl As EditText)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 730;BA.debugLine="Dim bmp As Bitmap";
Debug.ShouldStop(33554432);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 731;BA.debugLine="bmp.InitializeMutable(lbl.Width, lbl.Height)";
Debug.ShouldStop(67108864);
_bmp.runVoidMethod ("InitializeMutable",(Object)(_lbl.runMethod(true,"getWidth")),(Object)(_lbl.runMethod(true,"getHeight")));
 BA.debugLineNum = 734;BA.debugLine="Dim cvs As Canvas";
Debug.ShouldStop(536870912);
_cvs = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cvs", _cvs);
 BA.debugLineNum = 735;BA.debugLine="cvs.Initialize2(bmp)";
Debug.ShouldStop(1073741824);
_cvs.runVoidMethod ("Initialize2",(Object)((_bmp.getObject())));
 BA.debugLineNum = 736;BA.debugLine="cvs.DrawLine(0, lbl.Height - 2dip, lbl.Width, lbl";
Debug.ShouldStop(-2147483648);
_cvs.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_lbl.runMethod(true,"getHeight"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "-",1, 1))),(Object)(BA.numberCast(float.class, _lbl.runMethod(true,"getWidth"))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_lbl.runMethod(true,"getHeight"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "-",1, 1))),(Object)(branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.numberCast(float.class, branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 739;BA.debugLine="Dim bd As BitmapDrawable";
Debug.ShouldStop(4);
_bd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");Debug.locals.put("bd", _bd);
 BA.debugLineNum = 740;BA.debugLine="bd.Initialize(bmp)";
Debug.ShouldStop(8);
_bd.runVoidMethod ("Initialize",(Object)((_bmp.getObject())));
 BA.debugLineNum = 741;BA.debugLine="lbl.Background = bd";
Debug.ShouldStop(16);
_lbl.runMethod(false,"setBackground",(_bd.getObject()));
 BA.debugLineNum = 742;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("backbtn_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,639);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","backbtn_click");}
 BA.debugLineNum = 639;BA.debugLine="Sub backbtn_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 640;BA.debugLine="If currentPage > 1 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean(">",branch._currentpage,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 641;BA.debugLine="currentPage = currentPage - 1";
Debug.ShouldStop(1);
branch._currentpage = RemoteObject.solve(new RemoteObject[] {branch._currentpage,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 642;BA.debugLine="Log($\"Previous page: ${currentPage}\"$)";
Debug.ShouldStop(2);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22818051",(RemoteObject.concat(RemoteObject.createImmutable("Previous page: "),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._currentpage))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 643;BA.debugLine="LoadCompanyDataBranchGraph ' Updates graph";
Debug.ShouldStop(4);
_loadcompanydatabranchgraph();
 BA.debugLineNum = 644;BA.debugLine="LoadCompanyData ' Updates panels";
Debug.ShouldStop(8);
_loadcompanydata();
 };
 BA.debugLineNum = 646;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _closebutton_click() throws Exception{
try {
		Debug.PushSubsStack("closeButton_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,607);
if (RapidSub.canDelegate("closebutton_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","closebutton_click");}
 BA.debugLineNum = 607;BA.debugLine="Sub closeButton_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 608;BA.debugLine="popupPanel.Visible = False";
Debug.ShouldStop(-2147483648);
branch.mostCurrent._popuppanel.runMethod(true,"setVisible",branch.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 609;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _defbtn_click() throws Exception{
try {
		Debug.PushSubsStack("defBtn_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,649);
if (RapidSub.canDelegate("defbtn_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","defbtn_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 649;BA.debugLine="Sub defBtn_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 650;BA.debugLine="Dim btn As Button = Sender ' Get the button that";
Debug.ShouldStop(512);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 651;BA.debugLine="Dim index As String = btn.Tag";
Debug.ShouldStop(1024);
_index = BA.ObjectToString(_btn.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 652;BA.debugLine="sortDefaultValue = \"\"";
Debug.ShouldStop(2048);
branch.mostCurrent._sortdefaultvalue = BA.ObjectToString("");
 BA.debugLineNum = 653;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(4096);
_loadcompanydata();
 BA.debugLineNum = 654;BA.debugLine="Log(index)";
Debug.ShouldStop(8192);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22883589",_index,0);
 BA.debugLineNum = 655;BA.debugLine="Log(\"(default)\")";
Debug.ShouldStop(16384);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22883590",RemoteObject.createImmutable("(default)"),0);
 BA.debugLineNum = 660;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edit_button_click() throws Exception{
try {
		Debug.PushSubsStack("edit_button_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,579);
if (RapidSub.canDelegate("edit_button_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","edit_button_click");}
RemoteObject _target_id = RemoteObject.createImmutable(0);
RemoteObject _new_value = RemoteObject.createImmutable(0);
 BA.debugLineNum = 579;BA.debugLine="Sub edit_button_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 580;BA.debugLine="Dim target_id As Int = target_id_display.Text";
Debug.ShouldStop(8);
_target_id = BA.numberCast(int.class, branch.mostCurrent._target_id_display.runMethod(true,"getText"));Debug.locals.put("target_id", _target_id);Debug.locals.put("target_id", _target_id);
 BA.debugLineNum = 581;BA.debugLine="Dim new_value As Int = target_countLabel.Text";
Debug.ShouldStop(16);
_new_value = BA.numberCast(int.class, branch.mostCurrent._target_countlabel.runMethod(true,"getText"));Debug.locals.put("new_value", _new_value);Debug.locals.put("new_value", _new_value);
 BA.debugLineNum = 583;BA.debugLine="If IsNumber(target_id) And IsNumber(new_value) Th";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean(".",branch.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(BA.NumberToString(_target_id)))) && RemoteObject.solveBoolean(".",branch.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(BA.NumberToString(_new_value))))) { 
 BA.debugLineNum = 584;BA.debugLine="UpdateData_Remote(target_id, new_value)";
Debug.ShouldStop(128);
_updatedata_remote(_target_id,_new_value);
 BA.debugLineNum = 585;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(256);
_loadcompanydata();
 BA.debugLineNum = 586;BA.debugLine="popupPanel.Visible = False";
Debug.ShouldStop(512);
branch.mostCurrent._popuppanel.runMethod(true,"setVisible",branch.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 588;BA.debugLine="Log(\"Invalid input values\")";
Debug.ShouldStop(2048);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22293769",RemoteObject.createImmutable("Invalid input values"),0);
 };
 BA.debugLineNum = 590;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fetchnewpagedata() throws Exception{
try {
		Debug.PushSubsStack("FetchNewPageData (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,575);
if (RapidSub.canDelegate("fetchnewpagedata")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","fetchnewpagedata");}
 BA.debugLineNum = 575;BA.debugLine="Sub FetchNewPageData";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 576;BA.debugLine="LoadCompanyDataBranchGraph ' Fetch new data for t";
Debug.ShouldStop(-2147483648);
_loadcompanydatabranchgraph();
 BA.debugLineNum = 577;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 13;BA.debugLine="Private ScrollView1 As ScrollView";
branch.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 14;BA.debugLine="Dim PHPURL As String = \"https://192.168.8.117/Com";
branch.mostCurrent._phpurl = RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.117/Company/controller/branch.php?action=get_branch&company_id="),branch.mostCurrent._starter._company_selected /*RemoteObject*/ );
 //BA.debugLineNum = 15;BA.debugLine="Dim PHPURL1 As String = \"https://192.168.8.117/Co";
branch.mostCurrent._phpurl1 = BA.ObjectToString("https://192.168.8.117/Company/controller/company.php?action=get_company_list&page=1");
 //BA.debugLineNum = 16;BA.debugLine="Dim TableDetails As List";
branch.mostCurrent._tabledetails = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 17;BA.debugLine="Private LabelTitle As Label";
branch.mostCurrent._labeltitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Dim titleFontSize As Int = 4.5%y";
branch._titlefontsize = branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 4.5)),branch.mostCurrent.activityBA);
 //BA.debugLineNum = 19;BA.debugLine="Dim primaryFontSize As Int = 1.6%y";
branch._primaryfontsize = branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1.6)),branch.mostCurrent.activityBA);
 //BA.debugLineNum = 20;BA.debugLine="Dim secondaryFontSize As Int = 1%y";
branch._secondaryfontsize = branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1)),branch.mostCurrent.activityBA);
 //BA.debugLineNum = 21;BA.debugLine="Dim num As Int = 1";
branch._num = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 22;BA.debugLine="Private Panel3 As Panel";
branch.mostCurrent._panel3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim home As Label";
branch.mostCurrent._home = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Dim branches As Label";
branch.mostCurrent._branches = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Dim popupPanel As Panel";
branch.mostCurrent._popuppanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Dim target_countLabel As EditText";
branch.mostCurrent._target_countlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim target_id_display As Label";
branch.mostCurrent._target_id_display = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Dim totalTarget As Label";
branch.mostCurrent._totaltarget = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Dim Panel As Panel";
branch.mostCurrent._panel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Dim barGraph As barGraph";
branch.mostCurrent._bargraph = RemoteObject.createNew ("b4a.example.bargraph");
 //BA.debugLineNum = 31;BA.debugLine="Dim nxtBtn As Button";
branch.mostCurrent._nxtbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Dim backbtn As Button";
branch.mostCurrent._backbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Dim purchasePanel As Panel";
branch.mostCurrent._purchasepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Dim currentPage As Int = 1";
branch._currentpage = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 35;BA.debugLine="Dim totalSales As Int = 0";
branch._totalsales = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 36;BA.debugLine="Dim barGraphInitialized As Boolean = False";
branch._bargraphinitialized = branch.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 37;BA.debugLine="Private Panel4 As Panel";
branch.mostCurrent._panel4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Dim scrollViewPanel4 As ScrollView";
branch.mostCurrent._scrollviewpanel4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Dim sortBtn1 As RadioButton";
branch.mostCurrent._sortbtn1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Public defBtn As RadioButton";
branch.mostCurrent._defbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Public sortBtn2 As RadioButton";
branch.mostCurrent._sortbtn2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Public salesBtn1 As RadioButton";
branch.mostCurrent._salesbtn1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Public salesBtn2 As RadioButton";
branch.mostCurrent._salesbtn2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Public salesBtn3 As RadioButton";
branch.mostCurrent._salesbtn3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Dim salesData1 As Int";
branch._salesdata1 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 46;BA.debugLine="Dim salesDataDefault As Int = 1";
branch._salesdatadefault = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 47;BA.debugLine="Dim sortDefaultValue As String";
branch.mostCurrent._sortdefaultvalue = RemoteObject.createImmutable("");
 //BA.debugLineNum = 48;BA.debugLine="Dim showHideBtn As Button";
branch.mostCurrent._showhidebtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Dim showHide As Boolean = True";
branch._showhide = branch.mostCurrent.__c.getField(true,"True");
 //BA.debugLineNum = 50;BA.debugLine="Dim popupPanelBackground As Panel";
branch.mostCurrent._popuppanelbackground = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _home_click() throws Exception{
try {
		Debug.PushSubsStack("home_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,620);
if (RapidSub.canDelegate("home_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","home_click");}
 BA.debugLineNum = 620;BA.debugLine="Private Sub home_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 621;BA.debugLine="StartActivity(\"Main\")";
Debug.ShouldStop(4096);
branch.mostCurrent.__c.runVoidMethod ("StartActivity",branch.processBA,(Object)((RemoteObject.createImmutable("Main"))));
 BA.debugLineNum = 622;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8192);
branch.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 623;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("JobDone (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,211);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","jobdone", _job);}
RemoteObject _scrollheight = RemoteObject.createImmutable(0);
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _numcolumns = RemoteObject.createImmutable(0);
RemoteObject _pnlwidth = RemoteObject.createImmutable(0);
RemoteObject _pnlheight = RemoteObject.createImmutable(0);
RemoteObject _padding = RemoteObject.createImmutable(0);
RemoteObject _leftposition = RemoteObject.createImmutable(0);
RemoteObject _topposition = RemoteObject.createImmutable(0);
RemoteObject _count = RemoteObject.createImmutable(0);
RemoteObject _record = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _companyname = RemoteObject.createImmutable("");
RemoteObject _id = RemoteObject.createImmutable("");
RemoteObject _name = RemoteObject.createImmutable("");
RemoteObject _total_count = RemoteObject.createImmutable(0);
RemoteObject _total_pos = RemoteObject.createImmutable(0);
RemoteObject _totalpur1 = RemoteObject.createImmutable("");
RemoteObject _totalpur2 = RemoteObject.createImmutable("");
RemoteObject _totalpur3 = RemoteObject.createImmutable("");
RemoteObject _totalsales1 = RemoteObject.createImmutable("");
RemoteObject _totalsales2 = RemoteObject.createImmutable("");
RemoteObject _totalsales3 = RemoteObject.createImmutable("");
RemoteObject _target_id = RemoteObject.createImmutable("");
RemoteObject _panel2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _gradient = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.GradientDrawable");
RemoteObject _branchnamelabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _myimage = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _resizedimage = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _imgview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _panelwidth = RemoteObject.createImmutable(0);
RemoteObject _labelheight = RemoteObject.createImmutable(0);
RemoteObject _purchase1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _purchase1title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _purchase2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _purchase2title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _purchase3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _purchase3title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sale1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sale1title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sale2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sale2title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sale3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sale3title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totaltargettitle = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalpos = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _totalpostitle = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _salesarray = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _totalbranches = RemoteObject.createImmutable(0);
RemoteObject _branchnames = null;
RemoteObject _branchsales1 = null;
RemoteObject _branchsales2 = null;
RemoteObject _branchsales3 = null;
RemoteObject _branchcount = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _legend = null;
Debug.locals.put("job", _job);
 BA.debugLineNum = 211;BA.debugLine="Sub JobDone(job As HttpJob)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 213;BA.debugLine="Dim scrollHeight As Int = 0";
Debug.ShouldStop(1048576);
_scrollheight = BA.numberCast(int.class, 0);Debug.locals.put("scrollHeight", _scrollheight);Debug.locals.put("scrollHeight", _scrollheight);
 BA.debugLineNum = 215;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),branch.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 216;BA.debugLine="Try";
Debug.ShouldStop(8388608);
try { BA.debugLineNum = 217;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(16777216);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 218;BA.debugLine="parser.Initialize(job.GetString)";
Debug.ShouldStop(33554432);
_parser.runVoidMethod ("Initialize",(Object)(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ )));
 BA.debugLineNum = 220;BA.debugLine="Select Case job.JobName";
Debug.ShouldStop(134217728);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("GetData"),BA.ObjectToString("UpdateData"),BA.ObjectToString("GetBranches"),BA.ObjectToString("UpdateData"))) {
case 0: {
 BA.debugLineNum = 222;BA.debugLine="TableDetails = parser.NextArray";
Debug.ShouldStop(536870912);
branch.mostCurrent._tabledetails = _parser.runMethod(false,"NextArray");
 BA.debugLineNum = 223;BA.debugLine="totalTarget.RemoveView";
Debug.ShouldStop(1073741824);
branch.mostCurrent._totaltarget.runVoidMethod ("RemoveView");
 BA.debugLineNum = 224;BA.debugLine="Dim numColumns As Int = 2 ' Adjust based on p";
Debug.ShouldStop(-2147483648);
_numcolumns = BA.numberCast(int.class, 2);Debug.locals.put("numColumns", _numcolumns);Debug.locals.put("numColumns", _numcolumns);
 BA.debugLineNum = 225;BA.debugLine="Dim pnlWidth As Int = Activity.Width - 100dip";
Debug.ShouldStop(1);
_pnlwidth = RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._activity.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))}, "-",1, 1);Debug.locals.put("pnlWidth", _pnlwidth);Debug.locals.put("pnlWidth", _pnlwidth);
 BA.debugLineNum = 226;BA.debugLine="Dim pnlHeight As Int = 280dip";
Debug.ShouldStop(2);
_pnlheight = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 280)));Debug.locals.put("pnlHeight", _pnlheight);Debug.locals.put("pnlHeight", _pnlheight);
 BA.debugLineNum = 227;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(4);
_padding = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 228;BA.debugLine="Dim leftPosition As Int = 50dip";
Debug.ShouldStop(8);
_leftposition = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)));Debug.locals.put("leftPosition", _leftposition);Debug.locals.put("leftPosition", _leftposition);
 BA.debugLineNum = 229;BA.debugLine="Dim topPosition As Int = 0";
Debug.ShouldStop(16);
_topposition = BA.numberCast(int.class, 0);Debug.locals.put("topPosition", _topposition);Debug.locals.put("topPosition", _topposition);
 BA.debugLineNum = 230;BA.debugLine="Dim count As Int = 0 ' Track panel count";
Debug.ShouldStop(32);
_count = BA.numberCast(int.class, 0);Debug.locals.put("count", _count);Debug.locals.put("count", _count);
 BA.debugLineNum = 231;BA.debugLine="If Activity.Width >= 1340 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("g",branch.mostCurrent._activity.runMethod(true,"getWidth"),BA.numberCast(double.class, 1340))) { 
 BA.debugLineNum = 232;BA.debugLine="pnlWidth = 490dip";
Debug.ShouldStop(128);
_pnlwidth = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 490)));Debug.locals.put("pnlWidth", _pnlwidth);
 BA.debugLineNum = 233;BA.debugLine="pnlHeight = 300dip";
Debug.ShouldStop(256);
_pnlheight = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)));Debug.locals.put("pnlHeight", _pnlheight);
 BA.debugLineNum = 234;BA.debugLine="padding = 10dip";
Debug.ShouldStop(512);
_padding = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);
 BA.debugLineNum = 235;BA.debugLine="leftPosition = 10dip";
Debug.ShouldStop(1024);
_leftposition = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("leftPosition", _leftposition);
 };
 BA.debugLineNum = 237;BA.debugLine="For Each record As Map In TableDetails";
Debug.ShouldStop(4096);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group23 = branch.mostCurrent._tabledetails;
final int groupLen23 = group23.runMethod(true,"getSize").<Integer>get()
;int index23 = 0;
;
for (; index23 < groupLen23;index23++){
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group23.runMethod(false,"Get",index23));Debug.locals.put("record", _record);
Debug.locals.put("record", _record);
 BA.debugLineNum = 239;BA.debugLine="Panel.Initialize(\"Panel\")";
Debug.ShouldStop(16384);
branch.mostCurrent._panel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel")));
 BA.debugLineNum = 240;BA.debugLine="Panel.Visible = showHide";
Debug.ShouldStop(32768);
branch.mostCurrent._panel.runMethod(true,"setVisible",branch._showhide);
 BA.debugLineNum = 241;BA.debugLine="scrollViewPanel4.Panel.AddView(Panel, leftPo";
Debug.ShouldStop(65536);
branch.mostCurrent._scrollviewpanel4.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((branch.mostCurrent._panel.getObject())),(Object)(_leftposition),(Object)(_topposition),(Object)(_pnlwidth),(Object)(_pnlheight));
 BA.debugLineNum = 242;BA.debugLine="Panel.Color = Colors.Black";
Debug.ShouldStop(131072);
branch.mostCurrent._panel.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 243;BA.debugLine="If Panel.Visible = True Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",branch.mostCurrent._panel.runMethod(true,"getVisible"),branch.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 244;BA.debugLine="Dim companyName As String = record.Get(\"com";
Debug.ShouldStop(524288);
_companyname = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("company_name")))));Debug.locals.put("companyName", _companyname);Debug.locals.put("companyName", _companyname);
 BA.debugLineNum = 245;BA.debugLine="Dim id As String = record.Get(\"branch_id\")";
Debug.ShouldStop(1048576);
_id = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("branch_id")))));Debug.locals.put("id", _id);Debug.locals.put("id", _id);
 BA.debugLineNum = 246;BA.debugLine="Dim name As String = record.Get(\"branch_nam";
Debug.ShouldStop(2097152);
_name = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("branch_name")))));Debug.locals.put("name", _name);Debug.locals.put("name", _name);
 BA.debugLineNum = 247;BA.debugLine="Dim total_count As Int = record.Get(\"target";
Debug.ShouldStop(4194304);
_total_count = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("target_no")))));Debug.locals.put("total_count", _total_count);Debug.locals.put("total_count", _total_count);
 BA.debugLineNum = 248;BA.debugLine="Dim total_pos As Int = record.Get(\"count_de";
Debug.ShouldStop(8388608);
_total_pos = BA.numberCast(int.class, _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("count_device")))));Debug.locals.put("total_pos", _total_pos);Debug.locals.put("total_pos", _total_pos);
 BA.debugLineNum = 249;BA.debugLine="Dim totalPur1 As String = record.Get(\"purch";
Debug.ShouldStop(16777216);
_totalpur1 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("purchase_1")))));Debug.locals.put("totalPur1", _totalpur1);Debug.locals.put("totalPur1", _totalpur1);
 BA.debugLineNum = 250;BA.debugLine="Dim totalPur2 As String = record.Get(\"purch";
Debug.ShouldStop(33554432);
_totalpur2 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("purchase_2")))));Debug.locals.put("totalPur2", _totalpur2);Debug.locals.put("totalPur2", _totalpur2);
 BA.debugLineNum = 251;BA.debugLine="Dim totalPur3 As String = record.Get(\"purch";
Debug.ShouldStop(67108864);
_totalpur3 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("purchase_3")))));Debug.locals.put("totalPur3", _totalpur3);Debug.locals.put("totalPur3", _totalpur3);
 BA.debugLineNum = 252;BA.debugLine="Dim totalSales1 As String = record.Get(\"sal";
Debug.ShouldStop(134217728);
_totalsales1 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("sales_1")))));Debug.locals.put("totalSales1", _totalsales1);Debug.locals.put("totalSales1", _totalsales1);
 BA.debugLineNum = 253;BA.debugLine="Dim totalSales2 As String = record.Get(\"sal";
Debug.ShouldStop(268435456);
_totalsales2 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("sales_2")))));Debug.locals.put("totalSales2", _totalsales2);Debug.locals.put("totalSales2", _totalsales2);
 BA.debugLineNum = 254;BA.debugLine="Dim totalSales3 As String = record.Get(\"sal";
Debug.ShouldStop(536870912);
_totalsales3 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("sales_3")))));Debug.locals.put("totalSales3", _totalsales3);Debug.locals.put("totalSales3", _totalsales3);
 BA.debugLineNum = 255;BA.debugLine="Dim target_id As String = record.Get(\"targe";
Debug.ShouldStop(1073741824);
_target_id = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("target_id")))));Debug.locals.put("target_id", _target_id);Debug.locals.put("target_id", _target_id);
 BA.debugLineNum = 256;BA.debugLine="totalSales = totalSales1.Length";
Debug.ShouldStop(-2147483648);
branch._totalsales = _totalsales1.runMethod(true,"length");
 BA.debugLineNum = 257;BA.debugLine="branches.Text = \"Branches - \" & companyName";
Debug.ShouldStop(1);
branch.mostCurrent._branches.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Branches - "),_companyname)));
 BA.debugLineNum = 258;BA.debugLine="branches.Text = branches.Text.ToUpperCase";
Debug.ShouldStop(2);
branch.mostCurrent._branches.runMethod(true,"setText",BA.ObjectToCharSequence(branch.mostCurrent._branches.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 260;BA.debugLine="LabelTitle.Text = companyName";
Debug.ShouldStop(8);
branch.mostCurrent._labeltitle.runMethod(true,"setText",BA.ObjectToCharSequence(_companyname));
 BA.debugLineNum = 261;BA.debugLine="LabelTitle.Text = LabelTitle.Text.ToUpperCa";
Debug.ShouldStop(16);
branch.mostCurrent._labeltitle.runMethod(true,"setText",BA.ObjectToCharSequence(branch.mostCurrent._labeltitle.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 262;BA.debugLine="LabelTitle.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(32);
branch.mostCurrent._labeltitle.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 265;BA.debugLine="Dim Panel2 As Panel";
Debug.ShouldStop(256);
_panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("Panel2", _panel2);
 BA.debugLineNum = 266;BA.debugLine="Panel2.Initialize(\"Panel2\")";
Debug.ShouldStop(512);
_panel2.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel2")));
 BA.debugLineNum = 267;BA.debugLine="Dim gradient As GradientDrawable";
Debug.ShouldStop(1024);
_gradient = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("gradient", _gradient);
 BA.debugLineNum = 268;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As";
Debug.ShouldStop(2048);
_gradient.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"RIGHT_LEFT")),(Object)(RemoteObject.createNewArray("int",new int[] {2},new Object[] {branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 185)),(Object)(BA.numberCast(int.class, 46)),(Object)(BA.numberCast(int.class, 52))),branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 61)),(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 2)))})));
 BA.debugLineNum = 269;BA.debugLine="Panel2.Background = gradient";
Debug.ShouldStop(4096);
_panel2.runMethod(false,"setBackground",(_gradient.getObject()));
 BA.debugLineNum = 270;BA.debugLine="Panel2.Tag = name";
Debug.ShouldStop(8192);
_panel2.runMethod(false,"setTag",(_name));
 BA.debugLineNum = 271;BA.debugLine="Panel2.SendToBack";
Debug.ShouldStop(16384);
_panel2.runVoidMethod ("SendToBack");
 BA.debugLineNum = 272;BA.debugLine="Panel.AddView(Panel2, 0, 0, Panel.Width, 6%";
Debug.ShouldStop(32768);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_panel2.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(branch.mostCurrent._panel.runMethod(true,"getWidth")),(Object)(branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 6)),branch.mostCurrent.activityBA)));
 BA.debugLineNum = 274;BA.debugLine="Dim BranchNameLabel As Label";
Debug.ShouldStop(131072);
_branchnamelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("BranchNameLabel", _branchnamelabel);
 BA.debugLineNum = 275;BA.debugLine="BranchNameLabel.Initialize(\"Label17\")";
Debug.ShouldStop(262144);
_branchnamelabel.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Label17")));
 BA.debugLineNum = 276;BA.debugLine="BranchNameLabel.Text = name";
Debug.ShouldStop(524288);
_branchnamelabel.runMethod(true,"setText",BA.ObjectToCharSequence(_name));
 BA.debugLineNum = 277;BA.debugLine="BranchNameLabel.Tag = id";
Debug.ShouldStop(1048576);
_branchnamelabel.runMethod(false,"setTag",(_id));
 BA.debugLineNum = 278;BA.debugLine="BranchNameLabel.TextSize = 18";
Debug.ShouldStop(2097152);
_branchnamelabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 18));
 BA.debugLineNum = 279;BA.debugLine="BranchNameLabel.TextColor = Colors.White";
Debug.ShouldStop(4194304);
_branchnamelabel.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 280;BA.debugLine="BranchNameLabel.Typeface = Typeface.MONOSPA";
Debug.ShouldStop(8388608);
_branchnamelabel.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 281;BA.debugLine="BranchNameLabel.Gravity = Gravity.CENTER_VE";
Debug.ShouldStop(16777216);
_branchnamelabel.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 282;BA.debugLine="Panel2.AddView(BranchNameLabel, 10dip, 0dip";
Debug.ShouldStop(33554432);
_panel2.runVoidMethod ("AddView",(Object)((_branchnamelabel.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(_panel2.runMethod(true,"getWidth")),(Object)(_panel2.runMethod(true,"getHeight")));
 BA.debugLineNum = 284;BA.debugLine="Dim myImage As Bitmap";
Debug.ShouldStop(134217728);
_myimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 285;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"arrow";
Debug.ShouldStop(268435456);
_myimage = branch.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(branch.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("arrows-removebg-preview.png")));Debug.locals.put("myImage", _myimage);
 BA.debugLineNum = 286;BA.debugLine="If myImage.IsInitialized Then";
Debug.ShouldStop(536870912);
if (_myimage.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 287;BA.debugLine="Dim resizedImage As Bitmap = myImage.Resiz";
Debug.ShouldStop(1073741824);
_resizedimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_resizedimage = _myimage.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 4.5)),branch.mostCurrent.activityBA))))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_myimage.runMethod(true,"getHeight"),branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(branch.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 2)),branch.mostCurrent.activityBA))),_myimage.runMethod(true,"getWidth")}, "*/",0, 0))),(Object)(branch.mostCurrent.__c.getField(true,"True")));Debug.locals.put("resizedImage", _resizedimage);Debug.locals.put("resizedImage", _resizedimage);
 BA.debugLineNum = 288;BA.debugLine="Dim imgView As ImageView";
Debug.ShouldStop(-2147483648);
_imgview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("imgView", _imgview);
 BA.debugLineNum = 289;BA.debugLine="imgView.Initialize(\"\")";
Debug.ShouldStop(1);
_imgview.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 290;BA.debugLine="imgView.Bitmap = resizedImage";
Debug.ShouldStop(2);
_imgview.runMethod(false,"setBitmap",(_resizedimage.getObject()));
 BA.debugLineNum = 291;BA.debugLine="Panel2.AddView(imgView, Panel2.Width - 8%x";
Debug.ShouldStop(4);
_panel2.runVoidMethod ("AddView",(Object)((_imgview.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_panel2.runMethod(true,"getWidth"),branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 8)),branch.mostCurrent.activityBA)}, "-",1, 1)),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(branch.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),branch.mostCurrent.activityBA)),(Object)(_panel2.runMethod(true,"getHeight")));
 }else {
 BA.debugLineNum = 293;BA.debugLine="Log(\"Error loading image\")";
Debug.ShouldStop(16);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22162770",RemoteObject.createImmutable("Error loading image"),0);
 };
 BA.debugLineNum = 296;BA.debugLine="Dim panelWidth As Int = Panel.Width / 3";
Debug.ShouldStop(128);
_panelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(3)}, "/",0, 0));Debug.locals.put("panelWidth", _panelwidth);Debug.locals.put("panelWidth", _panelwidth);
 BA.debugLineNum = 297;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(256);
_padding = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 298;BA.debugLine="Dim labelheight As Int = 35dip";
Debug.ShouldStop(512);
_labelheight = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)));Debug.locals.put("labelheight", _labelheight);Debug.locals.put("labelheight", _labelheight);
 BA.debugLineNum = 300;BA.debugLine="Dim purchase1 As Label";
Debug.ShouldStop(2048);
_purchase1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("purchase1", _purchase1);
 BA.debugLineNum = 301;BA.debugLine="purchase1.Initialize(\"\")";
Debug.ShouldStop(4096);
_purchase1.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 302;BA.debugLine="purchase1.Text = totalPur1";
Debug.ShouldStop(8192);
_purchase1.runMethod(true,"setText",BA.ObjectToCharSequence(_totalpur1));
 BA.debugLineNum = 303;BA.debugLine="purchase1.TextColor = Colors.Black";
Debug.ShouldStop(16384);
_purchase1.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 304;BA.debugLine="purchase1.TextSize = primaryFontSize";
Debug.ShouldStop(32768);
_purchase1.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 305;BA.debugLine="purchase1.Gravity = Gravity.CENTER";
Debug.ShouldStop(65536);
_purchase1.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 306;BA.debugLine="purchase1.Typeface = Typeface.SERIF";
Debug.ShouldStop(131072);
_purchase1.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 307;BA.debugLine="Panel.AddView(purchase1, 0, Panel2.Height +";
Debug.ShouldStop(262144);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_purchase1.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_panel2.runMethod(true,"getHeight"),_padding}, "+",1, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 309;BA.debugLine="Dim purchase1Title As Label";
Debug.ShouldStop(1048576);
_purchase1title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("purchase1Title", _purchase1title);
 BA.debugLineNum = 310;BA.debugLine="purchase1Title.Initialize(\"\")";
Debug.ShouldStop(2097152);
_purchase1title.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 311;BA.debugLine="purchase1Title.Text = \"First Purchase\"";
Debug.ShouldStop(4194304);
_purchase1title.runMethod(true,"setText",BA.ObjectToCharSequence("First Purchase"));
 BA.debugLineNum = 312;BA.debugLine="purchase1Title.TextColor = Colors.Gray";
Debug.ShouldStop(8388608);
_purchase1title.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 313;BA.debugLine="purchase1Title.TextSize = secondaryFontSize";
Debug.ShouldStop(16777216);
_purchase1title.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 314;BA.debugLine="purchase1Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(33554432);
_purchase1title.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 315;BA.debugLine="purchase1Title.Typeface = Typeface.MONOSPAC";
Debug.ShouldStop(67108864);
_purchase1title.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 316;BA.debugLine="purchase1Title.Text = purchase1Title.Text.T";
Debug.ShouldStop(134217728);
_purchase1title.runMethod(true,"setText",BA.ObjectToCharSequence(_purchase1title.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 317;BA.debugLine="Panel.AddView(purchase1Title, 0, purchase1.";
Debug.ShouldStop(268435456);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_purchase1title.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_purchase1.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 319;BA.debugLine="Dim purchase2 As Label";
Debug.ShouldStop(1073741824);
_purchase2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("purchase2", _purchase2);
 BA.debugLineNum = 320;BA.debugLine="purchase2.Initialize(\"\")";
Debug.ShouldStop(-2147483648);
_purchase2.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 321;BA.debugLine="purchase2.Text = totalPur2";
Debug.ShouldStop(1);
_purchase2.runMethod(true,"setText",BA.ObjectToCharSequence(_totalpur2));
 BA.debugLineNum = 322;BA.debugLine="purchase2.TextColor = Colors.Black";
Debug.ShouldStop(2);
_purchase2.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 323;BA.debugLine="purchase2.TextSize = primaryFontSize";
Debug.ShouldStop(4);
_purchase2.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 324;BA.debugLine="purchase2.Gravity = Gravity.CENTER";
Debug.ShouldStop(8);
_purchase2.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 325;BA.debugLine="purchase2.Typeface = Typeface.SERIF";
Debug.ShouldStop(16);
_purchase2.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 326;BA.debugLine="Panel.AddView(purchase2, panelWidth, Panel2";
Debug.ShouldStop(32);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_purchase2.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_panel2.runMethod(true,"getHeight"),_padding}, "+",1, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 328;BA.debugLine="Dim purchase2Title As Label";
Debug.ShouldStop(128);
_purchase2title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("purchase2Title", _purchase2title);
 BA.debugLineNum = 329;BA.debugLine="purchase2Title.Initialize(\"\")";
Debug.ShouldStop(256);
_purchase2title.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 330;BA.debugLine="purchase2Title.Text = \"Second Purchase\"";
Debug.ShouldStop(512);
_purchase2title.runMethod(true,"setText",BA.ObjectToCharSequence("Second Purchase"));
 BA.debugLineNum = 331;BA.debugLine="purchase2Title.TextColor = Colors.Gray";
Debug.ShouldStop(1024);
_purchase2title.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 332;BA.debugLine="purchase2Title.TextSize = secondaryFontSize";
Debug.ShouldStop(2048);
_purchase2title.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 333;BA.debugLine="purchase2Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(4096);
_purchase2title.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 334;BA.debugLine="purchase2Title.Typeface = Typeface.MONOSPAC";
Debug.ShouldStop(8192);
_purchase2title.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 335;BA.debugLine="purchase2Title.Text = purchase2Title.Text.T";
Debug.ShouldStop(16384);
_purchase2title.runMethod(true,"setText",BA.ObjectToCharSequence(_purchase2title.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 336;BA.debugLine="Panel.AddView(purchase2Title, panelWidth, p";
Debug.ShouldStop(32768);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_purchase2title.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_purchase1.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 338;BA.debugLine="Dim purchase3 As Label";
Debug.ShouldStop(131072);
_purchase3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("purchase3", _purchase3);
 BA.debugLineNum = 339;BA.debugLine="purchase3.Initialize(\"\")";
Debug.ShouldStop(262144);
_purchase3.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 340;BA.debugLine="purchase3.Text = totalPur3";
Debug.ShouldStop(524288);
_purchase3.runMethod(true,"setText",BA.ObjectToCharSequence(_totalpur3));
 BA.debugLineNum = 341;BA.debugLine="purchase3.TextColor = Colors.Black";
Debug.ShouldStop(1048576);
_purchase3.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 342;BA.debugLine="purchase3.TextSize = primaryFontSize";
Debug.ShouldStop(2097152);
_purchase3.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 343;BA.debugLine="purchase3.Gravity = Gravity.CENTER";
Debug.ShouldStop(4194304);
_purchase3.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 344;BA.debugLine="purchase3.Typeface = Typeface.SERIF";
Debug.ShouldStop(8388608);
_purchase3.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 345;BA.debugLine="Panel.AddView(purchase3, panelWidth * 2, Pa";
Debug.ShouldStop(16777216);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_purchase3.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_panelwidth,RemoteObject.createImmutable(2)}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_panel2.runMethod(true,"getHeight"),_padding}, "+",1, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 347;BA.debugLine="Dim purchase3Title As Label";
Debug.ShouldStop(67108864);
_purchase3title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("purchase3Title", _purchase3title);
 BA.debugLineNum = 348;BA.debugLine="purchase3Title.Initialize(\"\")";
Debug.ShouldStop(134217728);
_purchase3title.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 349;BA.debugLine="purchase3Title.Text = \"Third Purchase\"";
Debug.ShouldStop(268435456);
_purchase3title.runMethod(true,"setText",BA.ObjectToCharSequence("Third Purchase"));
 BA.debugLineNum = 350;BA.debugLine="purchase3Title.TextColor = Colors.Gray";
Debug.ShouldStop(536870912);
_purchase3title.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 351;BA.debugLine="purchase3Title.TextSize = secondaryFontSize";
Debug.ShouldStop(1073741824);
_purchase3title.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 352;BA.debugLine="purchase3Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(-2147483648);
_purchase3title.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 353;BA.debugLine="purchase3Title.Typeface = Typeface.MONOSPAC";
Debug.ShouldStop(1);
_purchase3title.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 354;BA.debugLine="purchase3Title.Text = purchase3Title.Text.T";
Debug.ShouldStop(2);
_purchase3title.runMethod(true,"setText",BA.ObjectToCharSequence(_purchase3title.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 355;BA.debugLine="Panel.AddView(purchase3Title, panelWidth *";
Debug.ShouldStop(4);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_purchase3title.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_panelwidth,RemoteObject.createImmutable(2)}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_purchase1.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 357;BA.debugLine="Dim sale1 As Label";
Debug.ShouldStop(16);
_sale1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale1", _sale1);
 BA.debugLineNum = 358;BA.debugLine="sale1.Initialize(\"\")";
Debug.ShouldStop(32);
_sale1.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 359;BA.debugLine="sale1.Text = totalSales1";
Debug.ShouldStop(64);
_sale1.runMethod(true,"setText",BA.ObjectToCharSequence(_totalsales1));
 BA.debugLineNum = 360;BA.debugLine="sale1.TextColor = Colors.Black";
Debug.ShouldStop(128);
_sale1.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 361;BA.debugLine="sale1.TextSize = primaryFontSize";
Debug.ShouldStop(256);
_sale1.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 362;BA.debugLine="sale1.Gravity = Gravity.CENTER";
Debug.ShouldStop(512);
_sale1.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 363;BA.debugLine="sale1.Typeface = Typeface.SERIF";
Debug.ShouldStop(1024);
_sale1.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 364;BA.debugLine="Panel.AddView(sale1, 0, purchase3Title.Heig";
Debug.ShouldStop(2048);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_sale1.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_purchase3title.runMethod(true,"getHeight"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 90)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 366;BA.debugLine="Dim sale1Title As Label";
Debug.ShouldStop(8192);
_sale1title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale1Title", _sale1title);
 BA.debugLineNum = 367;BA.debugLine="sale1Title.Initialize(\"\")";
Debug.ShouldStop(16384);
_sale1title.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 368;BA.debugLine="sale1Title.Text = \"First Sale\"";
Debug.ShouldStop(32768);
_sale1title.runMethod(true,"setText",BA.ObjectToCharSequence("First Sale"));
 BA.debugLineNum = 369;BA.debugLine="sale1Title.TextColor = Colors.Gray";
Debug.ShouldStop(65536);
_sale1title.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 370;BA.debugLine="sale1Title.TextSize = secondaryFontSize";
Debug.ShouldStop(131072);
_sale1title.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 371;BA.debugLine="sale1Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(262144);
_sale1title.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 372;BA.debugLine="sale1Title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(524288);
_sale1title.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 373;BA.debugLine="sale1Title.Text = sale1Title.Text.ToUpperCa";
Debug.ShouldStop(1048576);
_sale1title.runMethod(true,"setText",BA.ObjectToCharSequence(_sale1title.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 374;BA.debugLine="Panel.AddView(sale1Title, 0, sale1.top + pa";
Debug.ShouldStop(2097152);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_sale1title.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_sale1.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 376;BA.debugLine="Dim sale2 As Label";
Debug.ShouldStop(8388608);
_sale2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale2", _sale2);
 BA.debugLineNum = 377;BA.debugLine="sale2.Initialize(\"\")";
Debug.ShouldStop(16777216);
_sale2.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 378;BA.debugLine="sale2.Text = totalSales2";
Debug.ShouldStop(33554432);
_sale2.runMethod(true,"setText",BA.ObjectToCharSequence(_totalsales2));
 BA.debugLineNum = 379;BA.debugLine="sale2.TextColor = Colors.Black";
Debug.ShouldStop(67108864);
_sale2.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 380;BA.debugLine="sale2.TextSize = primaryFontSize";
Debug.ShouldStop(134217728);
_sale2.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 381;BA.debugLine="sale2.Gravity = Gravity.CENTER";
Debug.ShouldStop(268435456);
_sale2.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 382;BA.debugLine="sale2.Typeface = Typeface.SERIF";
Debug.ShouldStop(536870912);
_sale2.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 383;BA.debugLine="Panel.AddView(sale2, panelWidth, purchase3T";
Debug.ShouldStop(1073741824);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_sale2.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_purchase3title.runMethod(true,"getHeight"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 90)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 385;BA.debugLine="Dim sale2Title As Label";
Debug.ShouldStop(1);
_sale2title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale2Title", _sale2title);
 BA.debugLineNum = 386;BA.debugLine="sale2Title.Initialize(\"\")";
Debug.ShouldStop(2);
_sale2title.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 387;BA.debugLine="sale2Title.Text = \" Second Sale\"";
Debug.ShouldStop(4);
_sale2title.runMethod(true,"setText",BA.ObjectToCharSequence(" Second Sale"));
 BA.debugLineNum = 388;BA.debugLine="sale2Title.TextColor = Colors.Gray";
Debug.ShouldStop(8);
_sale2title.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 389;BA.debugLine="sale2Title.TextSize = secondaryFontSize";
Debug.ShouldStop(16);
_sale2title.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 390;BA.debugLine="sale2Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(32);
_sale2title.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 391;BA.debugLine="sale2Title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(64);
_sale2title.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 392;BA.debugLine="sale2Title.Text = sale2Title.Text.ToUpperCa";
Debug.ShouldStop(128);
_sale2title.runMethod(true,"setText",BA.ObjectToCharSequence(_sale2title.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 393;BA.debugLine="Panel.AddView(sale2Title, panelWidth, sale2";
Debug.ShouldStop(256);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_sale2title.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_sale2.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 395;BA.debugLine="Dim sale3 As Label";
Debug.ShouldStop(1024);
_sale3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale3", _sale3);
 BA.debugLineNum = 396;BA.debugLine="sale3.Initialize(\"\")";
Debug.ShouldStop(2048);
_sale3.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 397;BA.debugLine="sale3.Text = totalSales3";
Debug.ShouldStop(4096);
_sale3.runMethod(true,"setText",BA.ObjectToCharSequence(_totalsales3));
 BA.debugLineNum = 398;BA.debugLine="sale3.TextColor = Colors.Black";
Debug.ShouldStop(8192);
_sale3.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 399;BA.debugLine="sale3.TextSize = primaryFontSize";
Debug.ShouldStop(16384);
_sale3.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 400;BA.debugLine="sale3.Gravity = Gravity.CENTER";
Debug.ShouldStop(32768);
_sale3.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 401;BA.debugLine="sale3.Typeface = Typeface.SERIF";
Debug.ShouldStop(65536);
_sale3.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 402;BA.debugLine="Panel.AddView(sale3, panelWidth * 2, sale2T";
Debug.ShouldStop(131072);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_sale3.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_panelwidth,RemoteObject.createImmutable(2)}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_sale2title.runMethod(true,"getHeight"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 90)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 404;BA.debugLine="Dim sale3Title As Label";
Debug.ShouldStop(524288);
_sale3title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("sale3Title", _sale3title);
 BA.debugLineNum = 405;BA.debugLine="sale3Title.Initialize(\"\")";
Debug.ShouldStop(1048576);
_sale3title.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 406;BA.debugLine="sale3Title.Text = \" Third Sale\"";
Debug.ShouldStop(2097152);
_sale3title.runMethod(true,"setText",BA.ObjectToCharSequence(" Third Sale"));
 BA.debugLineNum = 407;BA.debugLine="sale3Title.TextColor = Colors.Gray";
Debug.ShouldStop(4194304);
_sale3title.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 408;BA.debugLine="sale3Title.TextSize = secondaryFontSize";
Debug.ShouldStop(8388608);
_sale3title.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 409;BA.debugLine="sale3Title.Gravity = Gravity.CENTER";
Debug.ShouldStop(16777216);
_sale3title.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 410;BA.debugLine="sale3Title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(33554432);
_sale3title.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 411;BA.debugLine="sale3Title.Text = sale3Title.Text.ToUpperCa";
Debug.ShouldStop(67108864);
_sale3title.runMethod(true,"setText",BA.ObjectToCharSequence(_sale3title.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 412;BA.debugLine="Panel.AddView(sale3Title, panelWidth * 2, s";
Debug.ShouldStop(134217728);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_sale3title.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_panelwidth,RemoteObject.createImmutable(2)}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_sale1.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 414;BA.debugLine="panelWidth = Panel.Width / 2";
Debug.ShouldStop(536870912);
_panelwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("panelWidth", _panelwidth);
 BA.debugLineNum = 417;BA.debugLine="totalTarget.Initialize(\"totalTarget\")";
Debug.ShouldStop(1);
branch.mostCurrent._totaltarget.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("totalTarget")));
 BA.debugLineNum = 418;BA.debugLine="totalTarget.Text = total_count";
Debug.ShouldStop(2);
branch.mostCurrent._totaltarget.runMethod(true,"setText",BA.ObjectToCharSequence(_total_count));
 BA.debugLineNum = 419;BA.debugLine="totalTarget.Tag = target_id";
Debug.ShouldStop(4);
branch.mostCurrent._totaltarget.runMethod(false,"setTag",(_target_id));
 BA.debugLineNum = 420;BA.debugLine="totalTarget.TextColor = Colors.Black";
Debug.ShouldStop(8);
branch.mostCurrent._totaltarget.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 421;BA.debugLine="totalTarget.Color = Colors.White";
Debug.ShouldStop(16);
branch.mostCurrent._totaltarget.runVoidMethod ("setColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 422;BA.debugLine="totalTarget.TextSize = primaryFontSize";
Debug.ShouldStop(32);
branch.mostCurrent._totaltarget.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 423;BA.debugLine="totalTarget.Gravity = Gravity.CENTER";
Debug.ShouldStop(64);
branch.mostCurrent._totaltarget.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 424;BA.debugLine="totalTarget.Typeface = Typeface.SERIF";
Debug.ShouldStop(128);
branch.mostCurrent._totaltarget.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 425;BA.debugLine="Panel.AddView(totalTarget, 2dip, sale3Title";
Debug.ShouldStop(256);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((branch.mostCurrent._totaltarget.getObject())),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(RemoteObject.solve(new RemoteObject[] {_sale3title.runMethod(true,"getHeight"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 160)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 427;BA.debugLine="Dim totalTargetTitle As Label";
Debug.ShouldStop(1024);
_totaltargettitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalTargetTitle", _totaltargettitle);
 BA.debugLineNum = 428;BA.debugLine="totalTargetTitle.Initialize(\"totalTargetTit";
Debug.ShouldStop(2048);
_totaltargettitle.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("totalTargetTitles")));
 BA.debugLineNum = 429;BA.debugLine="totalTargetTitle.Text = \" Total Target\"";
Debug.ShouldStop(4096);
_totaltargettitle.runMethod(true,"setText",BA.ObjectToCharSequence(" Total Target"));
 BA.debugLineNum = 430;BA.debugLine="totalTargetTitle.Tag = 20";
Debug.ShouldStop(8192);
_totaltargettitle.runMethod(false,"setTag",RemoteObject.createImmutable((20)));
 BA.debugLineNum = 431;BA.debugLine="totalTargetTitle.TextColor = Colors.Gray";
Debug.ShouldStop(16384);
_totaltargettitle.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 432;BA.debugLine="totalTargetTitle.TextSize = secondaryFontSi";
Debug.ShouldStop(32768);
_totaltargettitle.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 433;BA.debugLine="totalTargetTitle.Gravity = Gravity.CENTER";
Debug.ShouldStop(65536);
_totaltargettitle.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 434;BA.debugLine="totalTargetTitle.Typeface = Typeface.MONOSP";
Debug.ShouldStop(131072);
_totaltargettitle.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 435;BA.debugLine="totalTargetTitle.Text = totalTargetTitle.Te";
Debug.ShouldStop(262144);
_totaltargettitle.runMethod(true,"setText",BA.ObjectToCharSequence(_totaltargettitle.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 436;BA.debugLine="Panel.AddView(totalTargetTitle, 0, totalTar";
Debug.ShouldStop(524288);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_totaltargettitle.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {branch.mostCurrent._totaltarget.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 438;BA.debugLine="Dim totalPos As Label";
Debug.ShouldStop(2097152);
_totalpos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalPos", _totalpos);
 BA.debugLineNum = 439;BA.debugLine="totalPos.Initialize(\"\")";
Debug.ShouldStop(4194304);
_totalpos.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 440;BA.debugLine="totalPos.Text = total_pos";
Debug.ShouldStop(8388608);
_totalpos.runMethod(true,"setText",BA.ObjectToCharSequence(_total_pos));
 BA.debugLineNum = 441;BA.debugLine="totalPos.TextColor = Colors.Black";
Debug.ShouldStop(16777216);
_totalpos.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 442;BA.debugLine="totalPos.TextSize = primaryFontSize";
Debug.ShouldStop(33554432);
_totalpos.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._primaryfontsize));
 BA.debugLineNum = 443;BA.debugLine="totalPos.Gravity = Gravity.CENTER";
Debug.ShouldStop(67108864);
_totalpos.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 444;BA.debugLine="totalPos.Typeface = Typeface.SERIF";
Debug.ShouldStop(134217728);
_totalpos.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 445;BA.debugLine="Panel.AddView(totalPos, panelWidth, totalTa";
Debug.ShouldStop(268435456);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_totalpos.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_totaltargettitle.runMethod(true,"getHeight"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 160)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 449;BA.debugLine="Dim totalPosTitle As Label";
Debug.ShouldStop(1);
_totalpostitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("totalPosTitle", _totalpostitle);
 BA.debugLineNum = 450;BA.debugLine="totalPosTitle.Initialize(\"\")";
Debug.ShouldStop(2);
_totalpostitle.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 451;BA.debugLine="totalPosTitle.Text = \" Total Pos\"";
Debug.ShouldStop(4);
_totalpostitle.runMethod(true,"setText",BA.ObjectToCharSequence(" Total Pos"));
 BA.debugLineNum = 452;BA.debugLine="totalPosTitle.TextColor = Colors.Gray";
Debug.ShouldStop(8);
_totalpostitle.runMethod(true,"setTextColor",branch.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 453;BA.debugLine="totalPosTitle.TextSize = secondaryFontSize";
Debug.ShouldStop(16);
_totalpostitle.runMethod(true,"setTextSize",BA.numberCast(float.class, branch._secondaryfontsize));
 BA.debugLineNum = 454;BA.debugLine="totalPosTitle.Gravity = Gravity.CENTER";
Debug.ShouldStop(32);
_totalpostitle.runMethod(true,"setGravity",branch.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 455;BA.debugLine="totalPosTitle.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(64);
_totalpostitle.runMethod(false,"setTypeface",branch.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 456;BA.debugLine="totalPosTitle.Text = totalPosTitle.Text.ToU";
Debug.ShouldStop(128);
_totalpostitle.runMethod(true,"setText",BA.ObjectToCharSequence(_totalpostitle.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 457;BA.debugLine="Panel.AddView(totalPosTitle, panelWidth, to";
Debug.ShouldStop(256);
branch.mostCurrent._panel.runVoidMethod ("AddView",(Object)((_totalpostitle.getObject())),(Object)(_panelwidth),(Object)(RemoteObject.solve(new RemoteObject[] {_totalpos.runMethod(true,"getTop"),_padding,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(_panelwidth),(Object)(_labelheight));
 BA.debugLineNum = 459;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(1024);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 460;BA.debugLine="cd.Initialize2(Colors.White, 0dip, 2dip, Co";
Debug.ShouldStop(2048);
_cd.runVoidMethod ("Initialize2",(Object)(branch.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(branch.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 156)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 461;BA.debugLine="Panel.Background = cd";
Debug.ShouldStop(4096);
branch.mostCurrent._panel.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 465;BA.debugLine="If Activity.Width >= 1340 Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("g",branch.mostCurrent._activity.runMethod(true,"getWidth"),BA.numberCast(double.class, 1340))) { 
 BA.debugLineNum = 466;BA.debugLine="count = count + 1";
Debug.ShouldStop(131072);
_count = RemoteObject.solve(new RemoteObject[] {_count,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("count", _count);
 BA.debugLineNum = 467;BA.debugLine="If count Mod numColumns = 0 Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {_count,_numcolumns}, "%",0, 1),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 468;BA.debugLine="leftPosition = 10dip";
Debug.ShouldStop(524288);
_leftposition = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("leftPosition", _leftposition);
 BA.debugLineNum = 469;BA.debugLine="topPosition = topPosition + pnlHeight + p";
Debug.ShouldStop(1048576);
_topposition = RemoteObject.solve(new RemoteObject[] {_topposition,_pnlheight,_padding}, "++",2, 1);Debug.locals.put("topPosition", _topposition);
 }else {
 BA.debugLineNum = 471;BA.debugLine="leftPosition = leftPosition + pnlWidth +";
Debug.ShouldStop(4194304);
_leftposition = RemoteObject.solve(new RemoteObject[] {_leftposition,_pnlwidth,_padding}, "++",2, 1);Debug.locals.put("leftPosition", _leftposition);
 };
 BA.debugLineNum = 473;BA.debugLine="scrollHeight = scrollHeight + 175dip";
Debug.ShouldStop(16777216);
_scrollheight = RemoteObject.solve(new RemoteObject[] {_scrollheight,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 175)))}, "+",1, 1);Debug.locals.put("scrollHeight", _scrollheight);
 }else {
 BA.debugLineNum = 475;BA.debugLine="topPosition = topPosition + pnlHeight + pa";
Debug.ShouldStop(67108864);
_topposition = RemoteObject.solve(new RemoteObject[] {_topposition,_pnlheight,_padding}, "++",2, 1);Debug.locals.put("topPosition", _topposition);
 BA.debugLineNum = 476;BA.debugLine="scrollHeight = scrollHeight + 290dip";
Debug.ShouldStop(134217728);
_scrollheight = RemoteObject.solve(new RemoteObject[] {_scrollheight,branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 290)))}, "+",1, 1);Debug.locals.put("scrollHeight", _scrollheight);
 };
 };
 }
}Debug.locals.put("record", _record);
;
 BA.debugLineNum = 481;BA.debugLine="scrollViewPanel4.Panel.Height = scrollHeight";
Debug.ShouldStop(1);
branch.mostCurrent._scrollviewpanel4.runMethod(false,"getPanel").runMethod(true,"setHeight",_scrollheight);
 BA.debugLineNum = 482;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(2);
branch.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 break; }
case 1: {
 BA.debugLineNum = 484;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
Debug.ShouldStop(8);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Data updated successfully")),(Object)(branch.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 485;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(16);
_loadcompanydata();
 break; }
case 2: {
 BA.debugLineNum = 488;BA.debugLine="Dim salesArray As List = parser.NextArray";
Debug.ShouldStop(128);
_salesarray = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_salesarray = _parser.runMethod(false,"NextArray");Debug.locals.put("salesArray", _salesarray);Debug.locals.put("salesArray", _salesarray);
 BA.debugLineNum = 489;BA.debugLine="If salesArray.Size = 0 Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",_salesarray.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 490;BA.debugLine="Log(\"No branch data returned\")";
Debug.ShouldStop(512);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22162967",RemoteObject.createImmutable("No branch data returned"),0);
 BA.debugLineNum = 491;BA.debugLine="ToastMessageShow(\"No branch data available\",";
Debug.ShouldStop(1024);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No branch data available")),(Object)(branch.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 492;BA.debugLine="Return";
Debug.ShouldStop(2048);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 496;BA.debugLine="Dim totalBranches As Int = salesArray.Size";
Debug.ShouldStop(32768);
_totalbranches = _salesarray.runMethod(true,"getSize");Debug.locals.put("totalBranches", _totalbranches);Debug.locals.put("totalBranches", _totalbranches);
 BA.debugLineNum = 497;BA.debugLine="Dim branchNames(totalBranches) As String";
Debug.ShouldStop(65536);
_branchnames = RemoteObject.createNewArray ("String", new int[] {_totalbranches.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("branchNames", _branchnames);
 BA.debugLineNum = 498;BA.debugLine="Dim branchSales1(totalBranches) As Int";
Debug.ShouldStop(131072);
_branchsales1 = RemoteObject.createNewArray ("int", new int[] {_totalbranches.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("branchSales1", _branchsales1);
 BA.debugLineNum = 499;BA.debugLine="Dim branchSales2(totalBranches) As Int";
Debug.ShouldStop(262144);
_branchsales2 = RemoteObject.createNewArray ("int", new int[] {_totalbranches.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("branchSales2", _branchsales2);
 BA.debugLineNum = 500;BA.debugLine="Dim branchSales3(totalBranches) As Int";
Debug.ShouldStop(524288);
_branchsales3 = RemoteObject.createNewArray ("int", new int[] {_totalbranches.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("branchSales3", _branchsales3);
 BA.debugLineNum = 501;BA.debugLine="Dim branchCount As Int = 0";
Debug.ShouldStop(1048576);
_branchcount = BA.numberCast(int.class, 0);Debug.locals.put("branchCount", _branchcount);Debug.locals.put("branchCount", _branchcount);
 BA.debugLineNum = 504;BA.debugLine="For i = 0 To totalBranches - 1";
Debug.ShouldStop(8388608);
{
final int step253 = 1;
final int limit253 = RemoteObject.solve(new RemoteObject[] {_totalbranches,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step253 > 0 && _i <= limit253) || (step253 < 0 && _i >= limit253) ;_i = ((int)(0 + _i + step253))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 505;BA.debugLine="Dim record As Map = salesArray.Get(i)";
Debug.ShouldStop(16777216);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _salesarray.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("record", _record);Debug.locals.put("record", _record);
 BA.debugLineNum = 506;BA.debugLine="branchNames(i) = record.GetDefault(\"branch_n";
Debug.ShouldStop(33554432);
_branchnames.setArrayElement (BA.ObjectToString(_record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("branch_name"))),(Object)((RemoteObject.createImmutable("Unknown"))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 507;BA.debugLine="branchSales1(i) = record.GetDefault(\"sales_1";
Debug.ShouldStop(67108864);
_branchsales1.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_1"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 508;BA.debugLine="branchSales2(i) = record.GetDefault(\"sales_2";
Debug.ShouldStop(134217728);
_branchsales2.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_2"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 509;BA.debugLine="branchSales3(i) = record.GetDefault(\"sales_3";
Debug.ShouldStop(268435456);
_branchsales3.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_3"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 510;BA.debugLine="branchCount = record.GetDefault(\"total_branc";
Debug.ShouldStop(536870912);
_branchcount = BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("total_branch_count"))),(Object)(RemoteObject.createImmutable((0)))));Debug.locals.put("branchCount", _branchcount);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 512;BA.debugLine="Log($\"branchCount:${branchCount}\"$)";
Debug.ShouldStop(-2147483648);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22162989",(RemoteObject.concat(RemoteObject.createImmutable("branchCount:"),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_branchcount))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 514;BA.debugLine="Dim legend() As String = Array As String(\"Sal";
Debug.ShouldStop(2);
_legend = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Sales 1"),BA.ObjectToString("Sales 2"),RemoteObject.createImmutable("Sales 3")});Debug.locals.put("legend", _legend);Debug.locals.put("legend", _legend);
 BA.debugLineNum = 517;BA.debugLine="purchasePanel.RemoveAllViews";
Debug.ShouldStop(16);
branch.mostCurrent._purchasepanel.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 520;BA.debugLine="If barGraphInitialized = False Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",branch._bargraphinitialized,branch.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 521;BA.debugLine="nxtBtn.Initialize(\"nxtBtn\")";
Debug.ShouldStop(256);
branch.mostCurrent._nxtbtn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("nxtBtn")));
 BA.debugLineNum = 522;BA.debugLine="backbtn.Initialize(\"backbtn\")";
Debug.ShouldStop(512);
branch.mostCurrent._backbtn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("backbtn")));
 BA.debugLineNum = 523;BA.debugLine="sortBtn1.Initialize(\"sortBtn1\")";
Debug.ShouldStop(1024);
branch.mostCurrent._sortbtn1.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sortBtn1")));
 BA.debugLineNum = 524;BA.debugLine="sortBtn2.Initialize(\"sortBtn2\")";
Debug.ShouldStop(2048);
branch.mostCurrent._sortbtn2.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sortBtn2")));
 BA.debugLineNum = 525;BA.debugLine="defBtn.Initialize(\"defBtn\")";
Debug.ShouldStop(4096);
branch.mostCurrent._defbtn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("defBtn")));
 BA.debugLineNum = 526;BA.debugLine="salesBtn1.Initialize(\"salesBtn1\")";
Debug.ShouldStop(8192);
branch.mostCurrent._salesbtn1.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("salesBtn1")));
 BA.debugLineNum = 527;BA.debugLine="salesBtn2.Initialize(\"salesBtn2\")";
Debug.ShouldStop(16384);
branch.mostCurrent._salesbtn2.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("salesBtn2")));
 BA.debugLineNum = 528;BA.debugLine="salesBtn3.Initialize(\"salesBtn3\")";
Debug.ShouldStop(32768);
branch.mostCurrent._salesbtn3.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("salesBtn3")));
 BA.debugLineNum = 530;BA.debugLine="Dim showHideBtn As Button";
Debug.ShouldStop(131072);
branch.mostCurrent._showhidebtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 BA.debugLineNum = 531;BA.debugLine="showHideBtn.Initialize(\"showHideBtn\")";
Debug.ShouldStop(262144);
branch.mostCurrent._showhidebtn.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("showHideBtn")));
 BA.debugLineNum = 532;BA.debugLine="barGraph.Initialize(Activity, purchasePanel,";
Debug.ShouldStop(524288);
branch.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_initialize" /*RemoteObject*/ ,branch.mostCurrent.activityBA,(Object)(branch.mostCurrent._activity),(Object)(branch.mostCurrent._purchasepanel),(Object)(_branchsales1),(Object)(_branchsales2),(Object)(_branchsales3),(Object)(_branchnames),(Object)(_legend),(Object)(BA.numberCast(int.class, 10000)),(Object)(BA.ObjectToString("Sales Per Branch")),(Object)(_branchsales1),(Object)(BA.ObjectToString("Branch")),(Object)(branch.mostCurrent._nxtbtn),(Object)(branch.mostCurrent._backbtn),(Object)(branch.mostCurrent._sortbtn1),(Object)(branch.mostCurrent._sortbtn2),(Object)(branch.mostCurrent._defbtn),(Object)(branch.mostCurrent._salesbtn1),(Object)(branch.mostCurrent._salesbtn2),(Object)(branch.mostCurrent._salesbtn3),(Object)(branch.mostCurrent._showhidebtn));
 BA.debugLineNum = 533;BA.debugLine="barGraph.totalPages = branchCount / 5";
Debug.ShouldStop(1048576);
branch.mostCurrent._bargraph.setField ("_totalpages" /*RemoteObject*/ ,BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_branchcount,RemoteObject.createImmutable(5)}, "/",0, 0)));
 BA.debugLineNum = 534;BA.debugLine="barGraph.UpdateGraph";
Debug.ShouldStop(2097152);
branch.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_updategraph" /*RemoteObject*/ );
 BA.debugLineNum = 535;BA.debugLine="barGraphInitialized = True";
Debug.ShouldStop(4194304);
branch._bargraphinitialized = branch.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 536;BA.debugLine="Log(\"Bar graph initialized\")";
Debug.ShouldStop(8388608);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22163013",RemoteObject.createImmutable("Bar graph initialized"),0);
 }else {
 BA.debugLineNum = 539;BA.debugLine="barGraph.pageNo = currentPage";
Debug.ShouldStop(67108864);
branch.mostCurrent._bargraph.setField ("_pageno" /*RemoteObject*/ ,branch._currentpage);
 BA.debugLineNum = 540;BA.debugLine="barGraph.sale_1 = branchSales1";
Debug.ShouldStop(134217728);
branch.mostCurrent._bargraph.setField ("_sale_1" /*RemoteObject*/ ,_branchsales1);
 BA.debugLineNum = 541;BA.debugLine="barGraph.sale_2 = branchSales2";
Debug.ShouldStop(268435456);
branch.mostCurrent._bargraph.setField ("_sale_2" /*RemoteObject*/ ,_branchsales2);
 BA.debugLineNum = 542;BA.debugLine="barGraph.sale_3 = branchSales3";
Debug.ShouldStop(536870912);
branch.mostCurrent._bargraph.setField ("_sale_3" /*RemoteObject*/ ,_branchsales3);
 BA.debugLineNum = 543;BA.debugLine="barGraph.product1 = branchNames";
Debug.ShouldStop(1073741824);
branch.mostCurrent._bargraph.setField ("_product1" /*RemoteObject*/ ,_branchnames);
 BA.debugLineNum = 544;BA.debugLine="barGraph.comId1 = branchSales1 ' Assuming th";
Debug.ShouldStop(-2147483648);
branch.mostCurrent._bargraph.setField ("_comid1" /*RemoteObject*/ ,_branchsales1);
 BA.debugLineNum = 546;BA.debugLine="barGraph.UpdateGraph";
Debug.ShouldStop(2);
branch.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_updategraph" /*RemoteObject*/ );
 BA.debugLineNum = 547;BA.debugLine="Log(\"Bar graph updated\")";
Debug.ShouldStop(4);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22163024",RemoteObject.createImmutable("Bar graph updated"),0);
 };
 BA.debugLineNum = 551;BA.debugLine="backbtn.Enabled = currentPage > 1";
Debug.ShouldStop(64);
branch.mostCurrent._backbtn.runMethod(true,"setEnabled",BA.ObjectToBoolean(RemoteObject.solveBoolean(">",branch._currentpage,BA.numberCast(double.class, 1))));
 BA.debugLineNum = 552;BA.debugLine="nxtBtn.Enabled = salesArray.Size > 0 ' Adjust";
Debug.ShouldStop(128);
branch.mostCurrent._nxtbtn.runMethod(true,"setEnabled",BA.ObjectToBoolean(RemoteObject.solveBoolean(">",_salesarray.runMethod(true,"getSize"),BA.numberCast(double.class, 0))));
 break; }
case 3: {
 BA.debugLineNum = 555;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
Debug.ShouldStop(1024);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Data updated successfully")),(Object)(branch.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 556;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(2048);
_loadcompanydata();
 break; }
default: {
 BA.debugLineNum = 559;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
Debug.ShouldStop(16384);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22163036",RemoteObject.concat(RemoteObject.createImmutable("Unknown job: "),_job.getField(true,"_jobname" /*RemoteObject*/ )),0);
 break; }
}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e299) {
			BA.rdebugUtils.runVoidMethod("setLastException",branch.processBA, e299.toString()); BA.debugLineNum = 563;BA.debugLine="Log(\"Error parsing data: \" & LastException.Mess";
Debug.ShouldStop(262144);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22163040",RemoteObject.concat(RemoteObject.createImmutable("Error parsing data: "),branch.mostCurrent.__c.runMethod(false,"LastException",branch.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 BA.debugLineNum = 564;BA.debugLine="ToastMessageShow(\"Error parsing graph data\", Tr";
Debug.ShouldStop(524288);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Error parsing graph data")),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 };
 }else {
 BA.debugLineNum = 567;BA.debugLine="Log(\"Job failed: \" & job.ErrorMessage)";
Debug.ShouldStop(4194304);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22163044",RemoteObject.concat(RemoteObject.createImmutable("Job failed: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )),0);
 BA.debugLineNum = 568;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
Debug.ShouldStop(8388608);
branch.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(branch.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 571;BA.debugLine="job.Release";
Debug.ShouldStop(67108864);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 572;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("Label17_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,625);
if (RapidSub.canDelegate("label17_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","label17_click");}
RemoteObject _clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _selectedcompany = RemoteObject.createImmutable("");
 BA.debugLineNum = 625;BA.debugLine="Private Sub Label17_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 626;BA.debugLine="Dim clickedLabel As Label = Sender";
Debug.ShouldStop(131072);
_clickedlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("clickedLabel", _clickedlabel);Debug.locals.put("clickedLabel", _clickedlabel);
 BA.debugLineNum = 627;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
Debug.ShouldStop(262144);
_selectedcompany = BA.ObjectToString(_clickedlabel.runMethod(false,"getTag"));Debug.locals.put("selectedCompany", _selectedcompany);Debug.locals.put("selectedCompany", _selectedcompany);
 BA.debugLineNum = 628;BA.debugLine="branch_selected = selectedCompany";
Debug.ShouldStop(524288);
branch._branch_selected = _selectedcompany;
 BA.debugLineNum = 629;BA.debugLine="StartActivity(\"Device\")";
Debug.ShouldStop(1048576);
branch.mostCurrent.__c.runVoidMethod ("StartActivity",branch.processBA,(Object)((RemoteObject.createImmutable("Device"))));
 BA.debugLineNum = 630;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("LoadCompanyData (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,193);
if (RapidSub.canDelegate("loadcompanydata")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","loadcompanydata");}
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 193;BA.debugLine="Sub LoadCompanyData";
Debug.ShouldStop(1);
 BA.debugLineNum = 194;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(2);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 195;BA.debugLine="totalTarget.Initialize(\"\")";
Debug.ShouldStop(4);
branch.mostCurrent._totaltarget.runVoidMethod ("Initialize",branch.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 196;BA.debugLine="totalTarget.RemoveView";
Debug.ShouldStop(8);
branch.mostCurrent._totaltarget.runVoidMethod ("RemoveView");
 BA.debugLineNum = 197;BA.debugLine="PHPURL = $\"https://192.168.8.117/Company/controll";
Debug.ShouldStop(16);
branch.mostCurrent._phpurl = (RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.117/Company/controller/branch.php?action=get_branch&company_id="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._starter._company_selected /*RemoteObject*/ ))),RemoteObject.createImmutable("&page="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._currentpage))),RemoteObject.createImmutable("")));
 BA.debugLineNum = 198;BA.debugLine="Log($\"Fetching panel data for company ID: ${Start";
Debug.ShouldStop(32);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22031621",(RemoteObject.concat(RemoteObject.createImmutable("Fetching panel data for company ID: "),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._starter._company_selected /*RemoteObject*/ ))),RemoteObject.createImmutable(", page: "),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._currentpage))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 199;BA.debugLine="Job1.Initialize(\"GetData\", Me)";
Debug.ShouldStop(64);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,branch.processBA,(Object)(BA.ObjectToString("GetData")),(Object)(branch.getObject()));
 BA.debugLineNum = 200;BA.debugLine="ProgressDialogShow(\"Loading Graph Data...\")";
Debug.ShouldStop(128);
branch.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",branch.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Graph Data..."))));
 BA.debugLineNum = 201;BA.debugLine="Job1.Download(PHPURL)";
Debug.ShouldStop(256);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(branch.mostCurrent._phpurl));
 BA.debugLineNum = 202;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadcompanydatabranchgraph() throws Exception{
try {
		Debug.PushSubsStack("LoadCompanyDataBranchGraph (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,178);
if (RapidSub.canDelegate("loadcompanydatabranchgraph")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","loadcompanydatabranchgraph");}
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 178;BA.debugLine="Sub LoadCompanyDataBranchGraph";
Debug.ShouldStop(131072);
 BA.debugLineNum = 179;BA.debugLine="Try";
Debug.ShouldStop(262144);
try { BA.debugLineNum = 180;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(524288);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 181;BA.debugLine="Job1.Initialize(\"GetBranches\", Me)";
Debug.ShouldStop(1048576);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,branch.processBA,(Object)(BA.ObjectToString("GetBranches")),(Object)(branch.getObject()));
 BA.debugLineNum = 182;BA.debugLine="PHPURL1 = $\"https://192.168.8.117/Company/contro";
Debug.ShouldStop(2097152);
branch.mostCurrent._phpurl1 = (RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.117/Company/controller/branch.php?action=get_branch&company_id="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._starter._company_selected /*RemoteObject*/ ))),RemoteObject.createImmutable("&page="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._currentpage))),RemoteObject.createImmutable("&branch_sales="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._salesdata1))),RemoteObject.createImmutable("&sort_type="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable("")));
 BA.debugLineNum = 183;BA.debugLine="Log(Starter.company_selected & \"isd\")";
Debug.ShouldStop(4194304);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","21966085",RemoteObject.concat(branch.mostCurrent._starter._company_selected /*RemoteObject*/ ,RemoteObject.createImmutable("isd")),0);
 BA.debugLineNum = 184;BA.debugLine="Job1.Download(PHPURL1)";
Debug.ShouldStop(8388608);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(branch.mostCurrent._phpurl1));
 BA.debugLineNum = 185;BA.debugLine="ProgressDialogShow(\"Loading Graph Data...\")";
Debug.ShouldStop(16777216);
branch.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",branch.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Graph Data..."))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e9) {
			BA.rdebugUtils.runVoidMethod("setLastException",branch.processBA, e9.toString()); BA.debugLineNum = 188;BA.debugLine="Log(LastException.Message)";
Debug.ShouldStop(134217728);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","21966090",branch.mostCurrent.__c.runMethod(false,"LastException",branch.mostCurrent.activityBA).runMethod(true,"getMessage"),0);
 };
 BA.debugLineNum = 190;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("nxtBtn_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,632);
if (RapidSub.canDelegate("nxtbtn_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","nxtbtn_click");}
 BA.debugLineNum = 632;BA.debugLine="Sub nxtBtn_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 633;BA.debugLine="currentPage = currentPage + 1";
Debug.ShouldStop(16777216);
branch._currentpage = RemoteObject.solve(new RemoteObject[] {branch._currentpage,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 634;BA.debugLine="Log($\"Next page: ${currentPage}\"$)";
Debug.ShouldStop(33554432);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22752514",(RemoteObject.concat(RemoteObject.createImmutable("Next page: "),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch._currentpage))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 635;BA.debugLine="LoadCompanyDataBranchGraph ' Updates graph";
Debug.ShouldStop(67108864);
_loadcompanydatabranchgraph();
 BA.debugLineNum = 636;BA.debugLine="LoadCompanyData ' Updates panels";
Debug.ShouldStop(134217728);
_loadcompanydata();
 BA.debugLineNum = 637;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
branch._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 8;BA.debugLine="Public company_name As String";
branch._company_name = RemoteObject.createImmutable("");
 //BA.debugLineNum = 9;BA.debugLine="Public branch_selected As String";
branch._branch_selected = RemoteObject.createImmutable("");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _responsivelabel(RemoteObject _label) throws Exception{
try {
		Debug.PushSubsStack("responsiveLabel (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,611);
if (RapidSub.canDelegate("responsivelabel")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","responsivelabel", _label);}
RemoteObject _charwidth = RemoteObject.createImmutable(0);
RemoteObject _padding = RemoteObject.createImmutable(0);
RemoteObject _homewidth = RemoteObject.createImmutable(0);
Debug.locals.put("label", _label);
 BA.debugLineNum = 611;BA.debugLine="Sub responsiveLabel(label As Label) As Int";
Debug.ShouldStop(4);
 BA.debugLineNum = 612;BA.debugLine="Dim charWidth As Int = 10dip";
Debug.ShouldStop(8);
_charwidth = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("charWidth", _charwidth);Debug.locals.put("charWidth", _charwidth);
 BA.debugLineNum = 613;BA.debugLine="Dim padding As Int = 10dip";
Debug.ShouldStop(16);
_padding = branch.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 614;BA.debugLine="Dim homeWidth As Int = (label.Text.Length * charW";
Debug.ShouldStop(32);
_homewidth = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_label.runMethod(true,"getText").runMethod(true,"length"),_charwidth}, "*",0, 1)),_padding}, "+",1, 1);Debug.locals.put("homeWidth", _homewidth);Debug.locals.put("homeWidth", _homewidth);
 BA.debugLineNum = 615;BA.debugLine="Return homeWidth";
Debug.ShouldStop(64);
if (true) return _homewidth;
 BA.debugLineNum = 616;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _salesbtn1_click() throws Exception{
try {
		Debug.PushSubsStack("salesBtn1_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,682);
if (RapidSub.canDelegate("salesbtn1_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","salesbtn1_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 682;BA.debugLine="Sub salesBtn1_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 683;BA.debugLine="Dim btn As Button = Sender";
Debug.ShouldStop(1024);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 684;BA.debugLine="Dim index As String = btn.Tag";
Debug.ShouldStop(2048);
_index = BA.ObjectToString(_btn.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 685;BA.debugLine="salesData1 = index.ToLowerCase";
Debug.ShouldStop(4096);
branch._salesdata1 = BA.numberCast(int.class, _index.runMethod(true,"toLowerCase"));
 BA.debugLineNum = 686;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",branch.mostCurrent._sortdefaultvalue,BA.ObjectToString("asc")) || RemoteObject.solveBoolean("=",branch.mostCurrent._sortdefaultvalue,BA.ObjectToString("desc"))) { 
 BA.debugLineNum = 687;BA.debugLine="LoadCompanyDataBranchGraph";
Debug.ShouldStop(16384);
_loadcompanydatabranchgraph();
 };
 BA.debugLineNum = 689;BA.debugLine="Log(sortDefaultValue)";
Debug.ShouldStop(65536);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","23080199",branch.mostCurrent._sortdefaultvalue,0);
 BA.debugLineNum = 690;BA.debugLine="Log(\" sales 1 Button clicked: \" & index)";
Debug.ShouldStop(131072);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","23080200",RemoteObject.concat(RemoteObject.createImmutable(" sales 1 Button clicked: "),_index),0);
 BA.debugLineNum = 691;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _salesbtn2_click() throws Exception{
try {
		Debug.PushSubsStack("salesBtn2_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,693);
if (RapidSub.canDelegate("salesbtn2_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","salesbtn2_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 693;BA.debugLine="Sub salesBtn2_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 694;BA.debugLine="Dim btn As Button = Sender ' Get the button that";
Debug.ShouldStop(2097152);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 695;BA.debugLine="Dim index As String = btn.Tag";
Debug.ShouldStop(4194304);
_index = BA.ObjectToString(_btn.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 696;BA.debugLine="salesData1 = index.ToLowerCase";
Debug.ShouldStop(8388608);
branch._salesdata1 = BA.numberCast(int.class, _index.runMethod(true,"toLowerCase"));
 BA.debugLineNum = 697;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",branch.mostCurrent._sortdefaultvalue,BA.ObjectToString("asc")) || RemoteObject.solveBoolean("=",branch.mostCurrent._sortdefaultvalue,BA.ObjectToString("desc"))) { 
 BA.debugLineNum = 698;BA.debugLine="LoadCompanyDataBranchGraph";
Debug.ShouldStop(33554432);
_loadcompanydatabranchgraph();
 };
 BA.debugLineNum = 700;BA.debugLine="Log(sortDefaultValue)";
Debug.ShouldStop(134217728);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","23145735",branch.mostCurrent._sortdefaultvalue,0);
 BA.debugLineNum = 701;BA.debugLine="Log(index)";
Debug.ShouldStop(268435456);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","23145736",_index,0);
 BA.debugLineNum = 702;BA.debugLine="Log(\"(Sale2)\")";
Debug.ShouldStop(536870912);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","23145737",RemoteObject.createImmutable("(Sale2)"),0);
 BA.debugLineNum = 703;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _salesbtn3_click() throws Exception{
try {
		Debug.PushSubsStack("salesBtn3_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,704);
if (RapidSub.canDelegate("salesbtn3_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","salesbtn3_click");}
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 704;BA.debugLine="Sub salesBtn3_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 705;BA.debugLine="Dim btn As Button = Sender ' Get the button that";
Debug.ShouldStop(1);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("btn", _btn);Debug.locals.put("btn", _btn);
 BA.debugLineNum = 706;BA.debugLine="Dim index As String = btn.Tag";
Debug.ShouldStop(2);
_index = BA.ObjectToString(_btn.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 707;BA.debugLine="salesData1 = index.ToLowerCase";
Debug.ShouldStop(4);
branch._salesdata1 = BA.numberCast(int.class, _index.runMethod(true,"toLowerCase"));
 BA.debugLineNum = 708;BA.debugLine="If sortDefaultValue=\"asc\" Or sortDefaultValue=\"de";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",branch.mostCurrent._sortdefaultvalue,BA.ObjectToString("asc")) || RemoteObject.solveBoolean("=",branch.mostCurrent._sortdefaultvalue,BA.ObjectToString("desc"))) { 
 BA.debugLineNum = 709;BA.debugLine="LoadCompanyDataBranchGraph";
Debug.ShouldStop(16);
_loadcompanydatabranchgraph();
 };
 BA.debugLineNum = 711;BA.debugLine="Log(sortDefaultValue)";
Debug.ShouldStop(64);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","23211271",branch.mostCurrent._sortdefaultvalue,0);
 BA.debugLineNum = 713;BA.debugLine="Log(index)";
Debug.ShouldStop(256);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","23211273",_index,0);
 BA.debugLineNum = 714;BA.debugLine="Log(\"(Sale3)\")";
Debug.ShouldStop(512);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","23211274",RemoteObject.createImmutable("(Sale3)"),0);
 BA.debugLineNum = 715;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _showhidebtn_click() throws Exception{
try {
		Debug.PushSubsStack("showHideBtn_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,718);
if (RapidSub.canDelegate("showhidebtn_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","showhidebtn_click");}
 BA.debugLineNum = 718;BA.debugLine="Public Sub showHideBtn_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 720;BA.debugLine="If showHide = True Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",branch._showhide,branch.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 721;BA.debugLine="showHide = False";
Debug.ShouldStop(65536);
branch._showhide = branch.mostCurrent.__c.getField(true,"False");
 }else {
 BA.debugLineNum = 723;BA.debugLine="showHide = True";
Debug.ShouldStop(262144);
branch._showhide = branch.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 725;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(1048576);
_loadcompanydata();
 BA.debugLineNum = 726;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("sortBtn1_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,673);
if (RapidSub.canDelegate("sortbtn1_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","sortbtn1_click");}
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 673;BA.debugLine="Sub sortBtn1_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 674;BA.debugLine="Dim chk As RadioButton = Sender";
Debug.ShouldStop(2);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
_chk = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("chk", _chk);Debug.locals.put("chk", _chk);
 BA.debugLineNum = 675;BA.debugLine="Dim index As String = chk.Tag";
Debug.ShouldStop(4);
_index = BA.ObjectToString(_chk.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 677;BA.debugLine="sortDefaultValue = index.ToLowerCase";
Debug.ShouldStop(16);
branch.mostCurrent._sortdefaultvalue = _index.runMethod(true,"toLowerCase");
 BA.debugLineNum = 678;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
Debug.ShouldStop(32);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","23014661",(RemoteObject.concat(RemoteObject.createImmutable("sort value: "),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 679;BA.debugLine="LoadCompanyDataBranchGraph";
Debug.ShouldStop(64);
_loadcompanydatabranchgraph();
 BA.debugLineNum = 680;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("sortBtn2_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,663);
if (RapidSub.canDelegate("sortbtn2_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","sortbtn2_click");}
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable("");
 BA.debugLineNum = 663;BA.debugLine="Sub sortBtn2_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 664;BA.debugLine="Dim chk As RadioButton = Sender";
Debug.ShouldStop(8388608);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
_chk = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("chk", _chk);Debug.locals.put("chk", _chk);
 BA.debugLineNum = 665;BA.debugLine="Dim index As String = chk.Tag";
Debug.ShouldStop(16777216);
_index = BA.ObjectToString(_chk.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 666;BA.debugLine="sortDefaultValue = index.ToLowerCase";
Debug.ShouldStop(33554432);
branch.mostCurrent._sortdefaultvalue = _index.runMethod(true,"toLowerCase");
 BA.debugLineNum = 667;BA.debugLine="LoadCompanyDataBranchGraph";
Debug.ShouldStop(67108864);
_loadcompanydatabranchgraph();
 BA.debugLineNum = 668;BA.debugLine="Log($\"sort value: ${sortDefaultValue}\"$)";
Debug.ShouldStop(134217728);
branch.mostCurrent.__c.runVoidMethod ("LogImpl","22949125",(RemoteObject.concat(RemoteObject.createImmutable("sort value: "),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((branch.mostCurrent._sortdefaultvalue))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 669;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _totaltarget_click() throws Exception{
try {
		Debug.PushSubsStack("totalTarget_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,592);
if (RapidSub.canDelegate("totaltarget_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","totaltarget_click");}
RemoteObject _target_id_btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _target_id = RemoteObject.createImmutable("");
RemoteObject _total_count = RemoteObject.createImmutable("");
 BA.debugLineNum = 592;BA.debugLine="Sub totalTarget_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 593;BA.debugLine="popupPanel.Visible = True";
Debug.ShouldStop(65536);
branch.mostCurrent._popuppanel.runMethod(true,"setVisible",branch.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 594;BA.debugLine="Dim target_id_btn As Label = Sender";
Debug.ShouldStop(131072);
_target_id_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_target_id_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("target_id_btn", _target_id_btn);Debug.locals.put("target_id_btn", _target_id_btn);
 BA.debugLineNum = 595;BA.debugLine="Dim target_id As String = target_id_btn.Tag";
Debug.ShouldStop(262144);
_target_id = BA.ObjectToString(_target_id_btn.runMethod(false,"getTag"));Debug.locals.put("target_id", _target_id);Debug.locals.put("target_id", _target_id);
 BA.debugLineNum = 596;BA.debugLine="Dim total_count As String = target_id_btn.Text";
Debug.ShouldStop(524288);
_total_count = _target_id_btn.runMethod(true,"getText");Debug.locals.put("total_count", _total_count);Debug.locals.put("total_count", _total_count);
 BA.debugLineNum = 597;BA.debugLine="target_id_display.Text = target_id";
Debug.ShouldStop(1048576);
branch.mostCurrent._target_id_display.runMethod(true,"setText",BA.ObjectToCharSequence(_target_id));
 BA.debugLineNum = 598;BA.debugLine="target_countLabel.Text = total_count";
Debug.ShouldStop(2097152);
branch.mostCurrent._target_countlabel.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_total_count));
 BA.debugLineNum = 599;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _totaltargettitle_click() throws Exception{
try {
		Debug.PushSubsStack("totalTargetTitle_Click (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,601);
if (RapidSub.canDelegate("totaltargettitle_click")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","totaltargettitle_click");}
RemoteObject _target_id_btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _target_id = RemoteObject.createImmutable("");
 BA.debugLineNum = 601;BA.debugLine="Sub totalTargetTitle_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 602;BA.debugLine="popupPanel.Visible = True";
Debug.ShouldStop(33554432);
branch.mostCurrent._popuppanel.runMethod(true,"setVisible",branch.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 603;BA.debugLine="Dim target_id_btn As Label = Sender";
Debug.ShouldStop(67108864);
_target_id_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_target_id_btn = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), branch.mostCurrent.__c.runMethod(false,"Sender",branch.mostCurrent.activityBA));Debug.locals.put("target_id_btn", _target_id_btn);Debug.locals.put("target_id_btn", _target_id_btn);
 BA.debugLineNum = 604;BA.debugLine="Dim target_id As String = target_id_btn.Tag";
Debug.ShouldStop(134217728);
_target_id = BA.ObjectToString(_target_id_btn.runMethod(false,"getTag"));Debug.locals.put("target_id", _target_id);Debug.locals.put("target_id", _target_id);
 BA.debugLineNum = 605;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _updatedata_remote(RemoteObject _target_id,RemoteObject _new_value) throws Exception{
try {
		Debug.PushSubsStack("UpdateData_Remote (branch) ","branch",1,branch.mostCurrent.activityBA,branch.mostCurrent,204);
if (RapidSub.canDelegate("updatedata_remote")) { return b4a.example.branch.remoteMe.runUserSub(false, "branch","updatedata_remote", _target_id, _new_value);}
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
Debug.locals.put("target_id", _target_id);
Debug.locals.put("new_value", _new_value);
 BA.debugLineNum = 204;BA.debugLine="Sub UpdateData_Remote(target_id As Int, new_value";
Debug.ShouldStop(2048);
 BA.debugLineNum = 205;BA.debugLine="Dim PHPURL As String = $\"https://192.168.8.117/Co";
Debug.ShouldStop(4096);
branch.mostCurrent._phpurl = (RemoteObject.concat(RemoteObject.createImmutable("https://192.168.8.117/Company/controller/branch.php?action=target_update&id="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_target_id))),RemoteObject.createImmutable("&value="),branch.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_new_value))),RemoteObject.createImmutable("")));
 BA.debugLineNum = 206;BA.debugLine="Dim job As HttpJob";
Debug.ShouldStop(8192);
_job = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("job", _job);
 BA.debugLineNum = 207;BA.debugLine="job.Initialize(\"UpdateData\", Me)";
Debug.ShouldStop(16384);
_job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,branch.processBA,(Object)(BA.ObjectToString("UpdateData")),(Object)(branch.getObject()));
 BA.debugLineNum = 208;BA.debugLine="job.Download(PHPURL)";
Debug.ShouldStop(32768);
_job.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(branch.mostCurrent._phpurl));
 BA.debugLineNum = 209;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}