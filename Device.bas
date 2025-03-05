B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=13.1
@EndOfDesignText@
#Region  Activity Attributes 
    #FullScreen: False
    #IncludeTitle: False
#End Region

Sub Process_Globals
	Private xui As XUI
End Sub

Sub Globals
	Dim limit As Int = 13
	Private ScrollView1 As ScrollView
	Private ScrollViewPanel As Panel
	Dim TableDetails As List
	Private LabelTitle As Label
	Private Label1 As Label
	Dim num As Int = 0
	Private Panel3 As Panel
	Dim pageNo As Int = 1
	Dim pageLabel As Label
	Dim PHPURL As String = "https://192.168.8.117/Company/fetch.php?action=get_device&id="&Branch.branch_selected&"&page="&pageNo&"limit="&limit
	Dim panelWidth As Int = 0
	Private Panel2 As Panel
	Private Panel1 As Panel
	Private Panel4 As Panel
	Dim branches As Label
	Dim devices As Label
	Dim home As Label
	Dim tdleftPos As Int = 5dip
	Dim TotalLabel As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("Device")
	ScrollView1.Width = 100%x
	ScrollViewPanel.Initialize("")
	ScrollView1.Panel.AddView(ScrollViewPanel, 0, 0, 100%x, 100%y)
	ProgressDialogShow("Loading Data...")
	TableDetails.Initialize

	'Dim deviceTitle As Label
	'deviceTitle.Initialize("deviceTitle")
	'deviceTitle.Text = " List of Devices"
	'deviceTitle.TextSize = 30
	'deviceTitle.TextColor = Colors.Black
	'deviceTitle.Color = Colors.white
	'deviceTitle.Gravity = Gravity.CENTER_VERTICAL
	'deviceTitle.Typeface = Typeface.MONOSPACE
	'deviceTitle.Text = deviceTitle.Text.ToUpperCase
	'Panel1.AddView(deviceTitle, 0, Panel2.Height, Activity.Width, 5%y)
			
	Dim tableLabel As Panel
	tableLabel.Initialize("deviceTitle")
	tableLabel.Color = Colors.Black
	Panel1.AddView(tableLabel, 0, Panel2.Height+Panel4.Height- 5dip, Activity.Width, 6%y)
	
	ScrollView1.Top = tableLabel.Height + Panel2.Height + Panel4.Height - 5dip
				
	panelWidth = tableLabel.Width /6
			
	Dim idLabel As Label
	idLabel.Initialize("")
	idLabel.Text = "ID"
	idLabel.TextColor= Colors.White
	idLabel.Gravity = Gravity.CENTER_VERTICAL
	idLabel.Typeface = Typeface.MONOSPACE
	tableLabel.AddView(idLabel,tdleftPos,0dip,panelWidth,tableLabel.Height)
			
	Dim deviceLabel As Label
	deviceLabel.Initialize("")
	deviceLabel.Text = "NAME"
	deviceLabel.TextColor= Colors.White
	deviceLabel.Gravity = Gravity.CENTER_VERTICAL
	deviceLabel.Typeface = Typeface.MONOSPACE
	tableLabel.AddView(deviceLabel,panelWidth,0,panelWidth,tableLabel.Height)
				
	Dim serialLabel As Label
	serialLabel.Initialize("")
	serialLabel.Text = "SERIAL NUMBER"
	serialLabel.TextSize = 11
	serialLabel.TextColor= Colors.White
	serialLabel.Gravity = Gravity.CENTER_VERTICAL
	serialLabel.Typeface = Typeface.MONOSPACE
	tableLabel.AddView(serialLabel,panelWidth*2,0,panelWidth,tableLabel.Height)
				
	Dim sale1Label As Label
	sale1Label.Initialize("")
	sale1Label.Text = "FIRST SALE"
	sale1Label.TextColor= Colors.White
	sale1Label.TextSize = 11
	sale1Label.Gravity = Gravity.CENTER_VERTICAL
	sale1Label.Typeface = Typeface.MONOSPACE
	tableLabel.AddView(sale1Label,panelWidth*3,0,panelWidth,tableLabel.Height)
				
	Dim sale2Label As Label
	sale2Label.Initialize("")
	sale2Label.Text = "SECOND SALE"
	sale2Label.TextColor= Colors.White
	sale2Label.TextSize = 11
	sale2Label.Gravity = Gravity.CENTER_VERTICAL
	sale2Label.Typeface = Typeface.MONOSPACE
	tableLabel.AddView(sale2Label,panelWidth*4,0,panelWidth,tableLabel.Height)
				
	Dim sale3Label As Label
	sale3Label.Initialize("")
	sale3Label.Text = "THIRD SALE"
	sale3Label.TextSize = 11
	sale3Label.TextColor= Colors.White
	sale3Label.Gravity = Gravity.CENTER_VERTICAL
	sale3Label.Typeface = Typeface.MONOSPACE
	tableLabel.AddView(sale3Label,panelWidth*5,0,panelWidth,tableLabel.Height)
	
	
	home.Initialize("home")
	home.Text = "HOME |"
	home.TextColor = Colors.Black
	home.Typeface = Typeface.MONOSPACE
	home.Gravity = Gravity.CENTER
	home.TextSize = 16 '
	Panel4.AddView(home, 0, 0, responsiveLabel(home), Panel4.Height)
	Panel4.Color = Colors.Transparent

	branches.Initialize("branch")
	branches.Text = "Branches"
	branches.Typeface = Typeface.MONOSPACE
	branches.Gravity = Gravity.CENTER_VERTICAL
	branches.TextSize = 16
	branches.TextColor = Colors.Black
	Panel4.AddView(branches, responsiveLabel(home), 0, 210dip, Panel4.Height)
	

	devices.Initialize("device")
	devices.Text = "Devices"
	devices.Typeface = Typeface.MONOSPACE
	devices.Gravity = Gravity.CENTER_VERTICAL
	devices.TextSize = 16 
	Panel4.AddView(devices, branches.Left + branches.Width, 0,300dip, Panel4.Height)
	Panel4.Color = Colors.Transparent
	
	Dim gradient As GradientDrawable
	gradient.Initialize("RIGHT_LEFT", Array As Int(Colors.ARGB(255, 185, 46, 52), Colors.ARGB(255, 61, 12, 2)))
	Panel2.Background = gradient
	
	LoadCompanyData
End Sub

Sub responsiveLabel(label As Label) As Int
	Dim charWidth As Int = 10dip
	Dim padding As Int = 10dip
	Dim homeWidth As Int = (label.Text.Length * charWidth) + padding
	Return homeWidth
End Sub

Sub LoadCompanyData
	PHPURL = "https://192.168.8.142/Company/fetch.php?action=get_device&id="&Branch.branch_selected&"&page="&pageNo&"&limit="&limit
	Dim Job1 As HttpJob
	Job1.Initialize("LoadData", Me)
	Job1.Download(PHPURL)
End Sub

Private Sub backBtn_Click
	If pageNo > 1 Then
		pageNo = pageNo - 1
		num = 1
		pageLabel.Text = pageNo
		ScrollView1.Panel.RemoveAllViews
		LoadCompanyData
	End If
End Sub


Private Sub nxtLabel_Click
	pageNo = pageNo + 1
	pageLabel.Text = pageNo
	ScrollView1.Panel.RemoveAllViews
	ProgressDialogShow("Loading Data...")
	LoadCompanyData
End Sub


Sub JobDone(job As HttpJob)
	ProgressDialogHide
	If job.Success = True Then
		Try
			ProgressDialogHide
			Dim parser As JSONParser
			parser.Initialize(job.GetString)
			TableDetails = parser.NextArray
			ScrollViewPanel.RemoveAllViews
			Dim YPos As Int = 0
			Dim Margin As Int = 0dip
			Dim TotalHeight As Int = 0
			Dim totalDevices As Int = 0
			YPos = YPos + 0%y + Margin
			Dim tdFontSize As Int = 13
				
			TotalLabel.Initialize("TotalLabel")
			For Each record As Map In TableDetails
		
				Dim serial_num As String = record.Get("serial")
				Dim sales1 As String = record.Get("sales1")
				Dim sales2 As String = record.Get("sales2")
				Dim sales3 As String = record.Get("sales3")
				Dim id As Int = record.Get("num")
				totalDevices = record.Get("totalDevices")
				Dim comName As String = record.Get("comName")
				LabelTitle.Text = record.Get("branchName")
				LabelTitle.Text = LabelTitle.Text.ToUpperCase
				
				Label1.Text = comName
				Label1.Text = Label1.Text.ToUpperCase
				
				branches.Text = "Branches - "&comName&" |"
				branches.Text = branches.Text.ToUpperCase
				
				devices.Text = "Devices - "&record.Get("branchName")
				devices.Text = devices.Text.ToUpperCase
				
				Dim ItemPanel As Panel
				ItemPanel.Initialize("")
				ItemPanel.SetLayout(0, YPos, ScrollView1.Width, 18%y)
				ScrollView1.Panel.AddView(ItemPanel, 0, YPos, ScrollView1.Width, 60dip)
				panelWidth = ItemPanel.Width /6
				If num Mod 2 = 0 Then
					ItemPanel.Color = Colors.LightGray
				Else
					ItemPanel.Color = Colors.ARGB(255, 251, 251, 251)
				End If
				
				Dim number As Label
				number.Initialize("")
				number.Text = id
				number.TextSize = tdFontSize
				number.TextColor = Colors.Black
				number.Gravity = Gravity.CENTER_VERTICAL
				number.Typeface = Typeface.MONOSPACE
				ItemPanel.AddView(number, tdleftPos, 0, panelWidth, ItemPanel.Height)

				Dim deviceLabel As Label
				deviceLabel.Initialize("")
				deviceLabel.Text = "Pos0"&id
				deviceLabel.TextSize = tdFontSize
				deviceLabel.TextColor = Colors.Black
				deviceLabel.Gravity = Gravity.CENTER_VERTICAL
				ItemPanel.AddView(deviceLabel, panelWidth, 0, panelWidth, ItemPanel.Height)
				
				Dim serialLabel As Label
				serialLabel.Initialize("")
				serialLabel.Text = serial_num
				serialLabel.TextSize = tdFontSize
				serialLabel.TextColor = Colors.Black
				serialLabel.Gravity = Gravity.CENTER_VERTICAL
				ItemPanel.AddView(serialLabel, panelWidth*2, 0, panelWidth, ItemPanel.Height)

				Dim sale As Label
				sale.Initialize("")
				sale.Text = sales1
				sale.TextSize = tdFontSize
				sale.TextColor = Colors.Black
				sale.Gravity = Gravity.CENTER_VERTICAL
				ItemPanel.AddView(sale, panelWidth*3, 0, panelWidth, ItemPanel.Height)
				
				Dim sale1 As Label
				sale1.Initialize("")
				sale1.Text = sales2
				sale1.TextSize = tdFontSize
				sale1.TextColor = Colors.Black
				sale1.Gravity = Gravity.CENTER_VERTICAL
				ItemPanel.AddView(sale1, panelWidth*4, 0, panelWidth, ItemPanel.Height)
				
				Dim sale2 As Label
				sale2.Initialize("")
				sale2.Text = sales3
				sale2.TextSize = tdFontSize
				sale2.TextColor = Colors.Black
				sale2.Gravity = Gravity.CENTER_VERTICAL
				ItemPanel.AddView(sale2, panelWidth*5, 0, panelWidth, ItemPanel.Height)
				
				Dim backBtn As Label
				backBtn.Initialize("backBtn")
				backBtn.TextColor =Colors.White
				backBtn.Text = "<"
				backBtn.Gravity = Gravity.CENTER
				backBtn.Typeface = Typeface.SERIF
				backBtn.Color = Colors.Black
				backBtn.TextSize = 25
				Panel3.AddView(backBtn,3dip,5dip,50dip,Panel3.Height-10dip)
			
				pageLabel.Initialize("pageLabel")
				pageLabel.TextColor =Colors.Black
				pageLabel.Text = pageNo
				pageLabel.Gravity = Gravity.CENTER
				pageLabel.Typeface = Typeface.DEFAULT_BOLD
				pageLabel.Color = Colors.white
				pageLabel.TextSize = 15
				Dim cd As ColorDrawable
				cd.Initialize2(Colors.White, 5dip, 2dip, Colors.Black) 
				Panel3.AddView(pageLabel,backBtn.Width+backBtn.Left+5dip,10dip,40dip,Panel3.Height-20dip)
			
				Dim nxtLabel As Label
				nxtLabel.Initialize("nxtLabel")
				nxtLabel.TextColor =Colors.White
				nxtLabel.Text = ">"
				nxtLabel.Gravity = Gravity.CENTER
				nxtLabel.Typeface = Typeface.SERIF
				nxtLabel.Color = Colors.black
				nxtLabel.TextSize = 25
				Panel3.AddView(nxtLabel,pageLabel.Width+pageLabel.Left+5dip,5dip,50dip,Panel3.Height-10dip)
			
				Dim cd As ColorDrawable
				cd.Initialize2(Colors.Black, 5dip, 2dip, Colors.White)
				backBtn.Background = cd
				nxtLabel.Background = cd
			
			
				
				YPos = YPos + ItemPanel.Height + Margin ' Update position for next item
				nxtLabel.Enabled = False
				If limit * pageNo < totalDevices Then
					nxtLabel.Enabled = True
				End If

				
				TotalHeight = TotalHeight + 65dip
				ScrollView1.Panel.Height =TotalHeight
				num = num +1
				TotalLabel.Text = ""
				
			Next
			
			TotalLabel.RemoveView
			TotalLabel.TextColor =Colors.White
			TotalLabel.Text = num&" out of "&totalDevices&" devices"
			TotalLabel.Gravity = Gravity.CENTER
			TotalLabel.Typeface = Typeface.MONOSPACE
			TotalLabel.Color = Colors.Transparent
			TotalLabel.TextSize = 15
	
			Panel3.AddView(TotalLabel,Panel3.Width-240dip,5dip,230dip,Panel3.Height-10dip)
			
		Catch
			'ToastMessageShow("Error parsing data", True)
		End Try
	Else
		ToastMessageShow("Error: " & job.ErrorMessage, True)
	End If
	
End Sub


Sub Activity_Resume
End Sub

Sub Activity_Pause (UserClosed As Boolean)
End Sub
Private Sub home_Click
	StartActivity("Main")
	Activity.Finish
End Sub
Private Sub branch_Click
	StartActivity("Branch")
	Activity.Finish
End Sub

