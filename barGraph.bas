B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=13.1
@EndOfDesignText@
Sub Class_Globals
	Private checkBoxes() As CheckBox
	Public checkedSales() As Boolean
	Dim color() As Int = Array As Int(Colors.RGB(255, 0, 0), Colors.RGB(200, 20, 20), Colors.RGB(100, 10, 10))
	Dim legendPanel As Panel
	Dim salePanel As Panel
	Dim radioPanel As Panel
	Dim sortPanel As Panel
	Dim radioLabelSalesTitles As Label
	Dim radioLabelSortTitles As Label
	Dim radioLabelLegendTitles As Label
	Dim Active1 As Activity
	Dim panel_l As Panel
	Dim sale_1() As Int
	Dim sale_2() As Int
	Dim sale_3() As Int
	Dim product1() As String
	Dim legend1() As String
	Dim maxSales1 As Int = 0
	Dim titleString1 As String = ""
	Dim comId1() As Int
	Private currentPage As Int = 1
	Private itemsPerPage As Int = 5
	Public btnNext As Button
	Public btnBack As Button
	Public sortBtn1 As RadioButton
	Public sortBtn2 As RadioButton
	Public defBtn As RadioButton
	Public sales1 As RadioButton
	Public sales2 As RadioButton
	Public sales3 As RadioButton
	Dim layout As String = ""
	Private isFirstInit As Boolean = True
	Dim sortMainpanel As Panel
	Dim showHideBtn As Button
	Dim paginationLabel As Label
	Dim pageNo As Int = 1
	Dim totalPages As Int = 1
	Dim hideShowBoolean As Boolean 
End Sub

Public Sub Initialize(Active As Activity, panel As Panel, sale1() As Int, sale2() As Int, sale3() As Int, product() As String, legend() As String, maxSales As Int, TitleString As String, comId() As Int, layout1 As String,NextBtn As Button,Backbtn As Button,sortBtn As RadioButton,BtnSort2 As RadioButton,Defaultbtn As RadioButton,Sales1btn As RadioButton,Sales2btn As RadioButton,Sales3btn As RadioButton,hideShowBtn As Button)
	If Active.IsInitialized = False Then
		Log("Error: Activity is not initialized")
		Return
	End If
	Active1 = Active
	panel_l = panel
	sale_1 = sale1
	sale_2 = sale2
	sale_3 = sale3
	product1 = product
	legend1 = legend
	maxSales1 = maxSales
	titleString1 = TitleString
	comId1 = comId
	layout = layout1
	btnNext = NextBtn
	btnBack = Backbtn
	sortBtn1 = sortBtn
	sortBtn2 = BtnSort2
	defBtn = Defaultbtn
	sales1 = Sales1btn
	sales2 = Sales2btn
	sales3 = Sales3btn
	showHideBtn = hideShowBtn
	Dim cd As ColorDrawable
	cd.Initialize2(Colors.White, 5dip, 1dip, Colors.Black)
	
	defBtn.Checked = True

	If sale1.Length <> product.Length Or sale2.Length <> product.Length Or sale3.Length <> product.Length Then
		Return
	End If
	Dim halfWidth As Int = panel.Width / 2
	
	legendPanel.Initialize("")
	legendPanel.Width = halfWidth
	legendPanel.Height = 60dip
	
	radioPanel.Initialize("")
	radioPanel.Width = halfWidth
	radioPanel.Height = 30dip
	
	radioPanel.Color = Colors.Transparent ' Keep it transparent
	Dim borderPanel As Panel
	borderPanel.Initialize("")
	borderPanel.Color = Colors.Black ' Border color
	panel.AddView(borderPanel, radioPanel.Left, radioPanel.Top, radioPanel.Width, radioPanel.Height)
	panel.AddView(radioPanel, radioPanel.Left + 1dip, radioPanel.Top + 1dip, radioPanel.Width - 2dip, radioPanel.Height - 2dip) ' Inside border

	Dim legendWidth As Int = (legendPanel.Width-20dip) / legend.Length
	checkBoxes = Array As CheckBox()
	checkedSales = Array As Boolean()
    
	Dim checkBoxes(legend.Length) As CheckBox
	Dim checkedSales(legend.Length) As Boolean
	If isFirstInit Then
		' Only initialize arrays on first call
		Dim tempCheckBoxes(legend.Length) As CheckBox
		checkBoxes = tempCheckBoxes
		Dim tempCheckedSales(legend.Length) As Boolean
		checkedSales = tempCheckedSales
        
		' Initialize checkboxes only once
		For i = 0 To legend.Length - 1
			Dim chk As CheckBox
			chk.Initialize("chkChange")
			chk.Text = legend(i)
			chk.TextSize = 10
			chk.Typeface = Typeface.MONOSPACE
			chk.TextColor = color(i)
			chk.Gravity = Gravity.CENTER
			chk.Tag = i
			chk.Checked = True  ' Default state
			checkedSales(i) = True
			legendPanel.AddView(chk, (legendWidth * i), 10dip, legendWidth, legendPanel.Height -20dip)
			checkBoxes(i) = chk
		Next
		isFirstInit = False
	Else
		' Restore previous states
		For i = 0 To checkBoxes.Length - 1
			checkBoxes(i).Checked = checkedSales(i)
		Next
	End If

	' Initialize buttons here, not in DrawGraph

	sortMainpanel.Initialize("")
	panel.AddView(sortMainpanel, 0dip, 5dip, halfWidth, 120dip)
	'sortMainpanel.Color = Colors.Cyan
	
	Dim radioButtons() As RadioButton = Array As RadioButton(sortBtn1, sortBtn2, defBtn)
	Dim radioTexts() As String = Array As String("ASC", "DESC", "DEFAULT")
	
	salePanel.Initialize("")
	salePanel.Width = halfWidth
	salePanel.Height = 30dip
	salePanel.SendToBack
	sortMainpanel.AddView(salePanel, 10dip, 5dip, sortMainpanel.Width-20dip, 45dip)
	salePanel.Background = cd
	
	radioLabelSalesTitles.Initialize("radioLabelSalesTitles")
	radioLabelSalesTitles.Text = "Base on"
	radioLabelSalesTitles.TextSize = 8
	radioLabelSalesTitles.Gravity = Gravity.CENTER
	radioLabelSalesTitles.Typeface = Typeface.MONOSPACE
	radioLabelSalesTitles.TextColor = Colors.Black
	radioLabelSalesTitles.Color = Colors.White
	sortMainpanel.AddView(radioLabelSalesTitles, 15dip, -2dip, 60dip, 10dip)
	
	sortPanel.Initialize("")
	sortPanel.Width = halfWidth ' Half of the main panel width
	sortPanel.Height = 30dip ' Height remains the same
	sortMainpanel.AddView(sortPanel, 10dip, salePanel.Height+20dip, sortMainpanel.Width -20dip, 45dip)
	sortPanel.Background = cd
	
	radioLabelSortTitles.Initialize("radioLabelSortTitles")
	radioLabelSortTitles.Text = "Sort By"
	radioLabelSortTitles.TextSize = 8
	radioLabelSortTitles.Typeface = Typeface.MONOSPACE
	radioLabelSortTitles.Gravity = Gravity.CENTER
	radioLabelSortTitles.TextColor = Colors.Black
	radioLabelSortTitles.Color = Colors.White
	sortMainpanel.AddView(radioLabelSortTitles,15dip,salePanel.Height + 12dip, 60dip, 10dip)
	
	
	If salePanel.Width = 0 Then
		salePanel.Width = halfWidth ' Default width to half of the panel
	End If

	Dim totalButtons As Int = radioButtons.Length
	Dim buttonWidth As Int = (salePanel.Width - (totalButtons * 5dip)) / totalButtons ' Adjust width based on panel size
	Dim spacing As Int = 5dip ' Small gap between buttons

	For i = 0 To totalButtons - 1
		radioButtons(i).Text = radioTexts(i)
		radioButtons(i).TextSize = 10
		radioButtons(i).Tag = radioTexts(i)
		radioButtons(i).Gravity = Gravity.CENTER_VERTICAL
		radioButtons(i).Typeface = Typeface.MONOSPACE
		radioButtons(i).TextColor = Colors.Black
		'radioButtons(i).Color = Colors.Gray

		Dim cdNext As ColorDrawable
		cdNext.Initialize2(Colors.RGB(128, 128, 128), 10dip, 2dip, Colors.Black)

		' Position buttons dynamically to fit inside salePanel
		sortPanel.AddView(radioButtons(i), (i * (buttonWidth + spacing)), 10dip, buttonWidth, 25dip)
	Next
	'salePanel.Color = Colors.blue
	Dim salesLabels() As RadioButton = Array As RadioButton(sales1, sales2, sales3)
	Dim salesTexts() As String = Array As String("1", "2", "3") ' Example values
	
	Dim totalLabels As Int = salesLabels.Length
	Dim labelWidth As Int = (sortPanel.Width - (totalLabels * 5dip)) / totalLabels ' Adjust width to fit all labels
	Dim spacing As Int = 5dip ' Small spacing between labels

	For i = 0 To totalLabels - 1
		salesLabels(i).Text = legend(i)
		salesLabels(i).TextSize = 10
		salesLabels(i).Tag = salesTexts(i)
		salesLabels(i).Typeface = Typeface.MONOSPACE
		salesLabels(i).TextColor = Colors.Black

		Dim cdBack As ColorDrawable
		cdBack.Initialize2(Colors.RGB(128, 128, 128), 10dip, 2dip, Colors.Black)
		'salesLabels(i).Color = Colors.White

		' Add label dynamically with calculated width
		salePanel.AddView(salesLabels(i), (i * (labelWidth + spacing)), 10dip, labelWidth, 20dip)
	Next
	'radioLabelSalesTitles.Visible = sale1.Length >= 5
	'radioLabelSortTitles.Visible = sale1.Length >= 5
	
	DrawGraph(Active, panel, sale1, sale2, sale3, product, maxSales, TitleString)
End Sub

Public Sub DrawGraph(Active As Activity, panel As Panel, sale1() As Int, sale2() As Int, sale3() As Int, product() As String, maxSales As Int, TitleString As String)
	Try
		panel.Invalidate
		panel.RemoveAllViews
		panel.Height = 530dip
		If panel.Width = 0 Then
			panel.Width = 800dip
		End If
		Dim halfWidth As Int = panel.Width / 2
		If sortMainpanel.IsInitialized = False Then
			sortMainpanel.Initialize("")
		End If
		sortMainpanel.Left = 0dip
		sortMainpanel.Top = 5dip
		sortMainpanel.Width = halfWidth
		sortMainpanel.Height = 120dip
		panel.AddView(sortMainpanel, 0dip, 5dip, halfWidth, 120dip)
		
		Dim cd As ColorDrawable
		cd.Initialize2(Colors.White, 5dip, 1dip, Colors.Black)
		panel.AddView(legendPanel, halfWidth +10dip, 10dip, halfWidth -20dip, 45dip)
		legendPanel.Background = cd
		
		radioLabelLegendTitles.Initialize("radioLabelLegendTitles")
		radioLabelLegendTitles.Text = "Shown Details"
		radioLabelLegendTitles.TextSize = 8
		radioLabelLegendTitles.Typeface = Typeface.MONOSPACE
		radioLabelLegendTitles.Gravity = Gravity.CENTER
		radioLabelLegendTitles.TextColor = Colors.Black
		radioLabelLegendTitles.Color = Colors.White
		panel.AddView(radioLabelLegendTitles, halfWidth+15dip, 2.5dip, 100dip, 10dip)
		
		
		Dim activityPanel As Panel
		activityPanel.Initialize("activityPanel")

		activityPanel.Width = 80%x
		If Active.Width > 800 Then
			activityPanel.Width = 55%x
		End If
		activityPanel.Height = 250dip
		activityPanel.Color = Colors.ARGB(70, 211, 211, 211)
    
		Dim alignLeftCenter As Int = (Active.Width - activityPanel.Width) / 2
		Dim alignTopCenter As Int = (panel.Height - activityPanel.Height) / 2 - 20dip
    
		Dim Title As Label
		Title.Initialize("")
		Title.Text = TitleString
		Title.TextSize = 20
		Title.Typeface = Typeface.MONOSPACE
		Title.Gravity = Gravity.CENTER
		Title.TextColor = Colors.Black
		panel.AddView(Title, 0, alignTopCenter / 2 +55dip, panel.Width, 30dip)
    
		panel.AddView(activityPanel, alignLeftCenter, alignTopCenter+(alignTopCenter/4), activityPanel.Width, activityPanel.Height)

		Dim graphCanvas As Canvas
		graphCanvas.Initialize(activityPanel)

		Dim maxSale As Int = maxSales * 1.2
		Dim cv As Canvas
		cv.Initialize(panel)
    
		Dim totalProducts As Int = sale1.Length
		Dim startIndex As Int = (currentPage - 1) * itemsPerPage
		Dim endIndex As Int = Min(startIndex + itemsPerPage - 1, totalProducts - 1)
		Dim barsPerProduct As Int = 3
		Dim totalBars As Int = (endIndex - startIndex + 1) * barsPerProduct
		Dim gap As Int = 5dip
		Dim productGap As Int = 0dip
		Dim padding As Int = 10dip
    
		Dim availableWidth As Int = activityPanel.Width - (padding * 2) - (((endIndex - startIndex + 1) - 1) * productGap) - ((totalBars - (endIndex - startIndex + 1)) * gap)
		Dim barWidth As Int = availableWidth / totalBars
		Dim xStart As Int = padding
    
		For i = startIndex To endIndex
			Dim xPos As Int = xStart + (i - startIndex) * (barsPerProduct * (barWidth + gap) + productGap)
			Dim saleValues() As Int = Array As Int(sale1(i), sale2(i), sale3(i))
			Dim indexOffset As Int = 0
        
			For j = 0 To barsPerProduct - 1
				If j < checkedSales.Length And checkedSales(j) Then
					Dim sale As Int = saleValues(j)
					Dim barHeight As Int = (sale / maxSale) * (activityPanel.Height)
					Dim xBar As Int = xPos + indexOffset * barWidth
                
					Dim r As Rect
					r.Initialize(xBar, activityPanel.Height - barHeight, xBar + barWidth, activityPanel.Height)
					graphCanvas.DrawRect(r, color(j), True, 2dip)
                
					Dim fontSize As Int = 8
					If Active.Width > 800 Then
						fontSize = 10
					End If
					graphCanvas.DrawText(FormatNumberWithSuffix(sale), xBar + (barWidth / 2), activityPanel.Height - barHeight - 5dip, Typeface.MONOSPACE, fontSize, Colors.Black, "CENTER")
					indexOffset = indexOffset + 1
				End If
			Next
        
			Dim productLabel As Label
			productLabel.Initialize("productLabel")
			productLabel.Text = product(i)
			productLabel.Typeface = Typeface.MONOSPACE
			productLabel.TextSize = 12
			productLabel.Tag = comId1(i)
			productLabel.TextColor = Colors.Black
			productLabel.Gravity = Gravity.CENTER
			Dim productLabelY As Int = activityPanel.Height + alignTopCenter + 10dip
			Dim productLabelX As Int = alignLeftCenter
			Dim productLabelWidth As Int = (activityPanel.Width / totalProducts) - (padding+gap)
			panel.AddView(productLabel, xPos + productLabelX, productLabelY+20dip, productLabelWidth, 30dip)
		Next
    
		Dim numLabels As Int = 10
		For i = 0 To numLabels
			Dim labelValue As Int = Round((maxSale / numLabels) * i)
			Dim labelYPos As Int = activityPanel.Height - ((labelValue / maxSale) * activityPanel.Height)
			
			Dim yAxisLabel As Label
			yAxisLabel.Initialize("")
			yAxisLabel.Text = FormatNumberWithLabel(labelValue)
			yAxisLabel.TextSize = 10
			yAxisLabel.Typeface = Typeface.MONOSPACE
			yAxisLabel.TextColor = Colors.Black
			yAxisLabel.Gravity = Gravity.RIGHT
			' Position the label to the left of the graph, aligned with the y-axis value
			panel.AddView(yAxisLabel, alignLeftCenter - 40dip, activityPanel.top + labelYPos - 10dip , 30dip, 15dip)
		Next
		btnBack.Enabled = currentPage > 1
		btnNext.Enabled = (currentPage * itemsPerPage) < sale1.Length
		' Add buttons to panel without reinitializing
		
		Dim buttonWidth As Int = 50dip
		Dim buttonHeight As Int = 40dip
		
		Dim btnMainPanel As Panel
		btnMainPanel.Initialize("")
		panel.AddView(btnMainPanel, alignLeftCenter, panel.Height - ((alignTopCenter / 2) + 20dip), activityPanel.Width, 50dip)
		
        Dim paginationPanel As Panel
		paginationPanel.Initialize("")
		btnMainPanel.AddView(paginationPanel, 0, 0, btnMainPanel.Width - 150dip, btnMainPanel.Height)
		
		' Ensure buttons are removed from any existing parent BEFORE configuring and adding
        If btnBack.Parent <> Null Then btnBack.RemoveView
        If btnNext.Parent <> Null Then btnNext.RemoveView
		If showHideBtn.Parent <> Null Then showHideBtn.RemoveView ' Also handle showHideBtn
		
		' Configure btnBack
        btnBack.Text = "<"
		btnBack.TextSize = 14
		btnBack.Typeface = Typeface.MONOSPACE
		btnBack.TextColor = Colors.White
		Dim cdBack As ColorDrawable
		cdBack.Initialize2(Colors.RGB(61, 12, 2), 10dip, 2dip, Colors.Black)
		btnBack.Background = cdBack
		
		' Configure btnNext
        btnNext.Text = ">"
		btnNext.TextSize = 14
		btnNext.Typeface = Typeface.MONOSPACE
		btnNext.TextColor = Colors.White
		Dim cdNext As ColorDrawable
		cdNext.Initialize2(Colors.RGB(185, 46, 52), 10dip, 2dip, Colors.Black)
		btnNext.Background = cdNext
		
		' Configure pagination label
        paginationLabel.Initialize("")
		paginationLabel.Text = $"Page ${pageNo} out of ${totalPages}"$
		paginationLabel.Gravity = Gravity.CENTER
		paginationLabel.Typeface = Typeface.MONOSPACE
		paginationPanel.AddView(paginationLabel, buttonWidth, 0, paginationPanel.Width - (buttonWidth * 2), paginationPanel.Height)

		' Add buttons with proper positioning
		Dim buttonWidth As Int = 50dip
        Dim buttonHeight As Int = 40dip
		paginationPanel.AddView(btnBack, 0, (paginationPanel.Height - buttonHeight) / 2, buttonWidth, buttonHeight)
		paginationPanel.AddView(btnNext, paginationPanel.Width - buttonWidth, (paginationPanel.Height - buttonHeight) / 2, buttonWidth, buttonHeight)

		' Update button states
		btnBack.Enabled = currentPage > 1
		btnNext.Enabled = (currentPage * itemsPerPage) < sale1.Length

		' Configure and add showHideBtn
		showHideBtn.Text = "Show Details"
		showHideBtn.TextColor = Colors.White
		showHideBtn.Background = cdBack
        btnMainPanel.AddView(showHideBtn, paginationPanel.Width + 5dip, 5dip, (btnMainPanel.Width - paginationPanel.Width) - 10dip, buttonHeight)
		If hideShowBoolean = True Then
			paginationPanel.Width = btnMainPanel.Width
		End If
		'Dim cdBack As ColorDrawable
		'cdBack.Initialize2(Colors.RGB(61, 12, 2), 10dip, 2dip, Colors.Black)
		'showHideBtn.Background = cdBack
	Catch
		Log(LastException)
	End Try
End Sub

Public Sub UpdateGraph
	DrawGraph(Active1, panel_l, sale_1, sale_2, sale_3, product1, maxSales1, titleString1)
End Sub

Public Sub GetCurrentPage As Int
	Return currentPage
End Sub

Public Sub SetCurrentPage(page As Int)
	currentPage = page
	UpdateGraph
End Sub

Sub productLabel_Click
	Dim clickedLabel As Label = Sender
	Dim selectedCompany As Int = clickedLabel.Tag
	Log("Selected Company ID: " & selectedCompany)
	Starter.company_selected = selectedCompany
	StartActivity(layout)
	Active1.Finish
End Sub

Sub FormatNumberWithSuffix(number As Int) As String
	If number >= 1000000 Then
		Return NumberFormat(number / 1000000, 1, 1) & "M"
	Else If number >= 1000 Then
		Return NumberFormat(number / 1000, 1, 1) & "k"
	Else
		Return NumberFormat(number, 1, 0)
	End If
End Sub

Sub FormatNumberWithLabel(number As Int) As String
	If number >= 1000000 Then
		Return Floor(number / 1000000) & "M"
	Else If number >= 1000 Then
		Return Floor(number / 1000) & "k"
	Else
		Return number
	End If
End Sub
Sub chkChange_CheckedChange(Checked As Boolean)
	If Sender Is CheckBox Then
		Dim chk As CheckBox = Sender
		Dim index As Int = chk.Tag
        
		Dim checkedCount As Int = 0
		For i = 0 To checkedSales.Length - 1
			If checkedSales(i) = True Then checkedCount = checkedCount + 1
		Next
        
		If Checked = False And checkedCount = 1 Then
			chk.Checked = True
			Return
		End If
        
		checkedSales(index) = Checked
		UpdateGraph ' Call DrawGraph without parameters
	Else
		Log("Error: Sender is not a CheckBox")
	End If
End Sub

Public Sub GetCheckedSales As Boolean()
	Return checkedSales
End Sub

