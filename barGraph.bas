﻿B4A=true
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
	Dim layout As String = ""
	Private isFirstInit As Boolean = True
End Sub

Public Sub Initialize(Active As Activity, panel As Panel, sale1() As Int, sale2() As Int, sale3() As Int, product() As String, legend() As String, maxSales As Int, TitleString As String, comId() As Int, layout1 As String,NextBtn As Button,Backbtn As Button)
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
	If sale1.Length <> product.Length Or sale2.Length <> product.Length Or sale3.Length <> product.Length Then
		Return
	End If
    
	legendPanel.Initialize("")
	legendPanel.Width = panel.Width
	legendPanel.Height = 30dip
    
	Dim legendWidth As Int = legendPanel.Width / legend.Length
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
			chk.Tag = i
			chk.Checked = True  ' Default state
			checkedSales(i) = True
			legendPanel.AddView(chk, (legendWidth * i) + 30dip, 0dip, legendWidth - 30dip, legendPanel.Height)
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
	'btnBack.Initialize("btnBack")
	btnBack.Text = "Back"
	btnBack.TextSize = 14
	btnBack.Typeface = Typeface.MONOSPACE
	btnBack.TextColor = Colors.White
	Dim cdBack As ColorDrawable
	cdBack.Initialize2(Colors.RGB(61, 12, 2), 10dip, 2dip, Colors.Black)
	btnBack.Background = cdBack

	'btnNext.Initialize("btnNext")
	btnNext.Text = "Next"
	btnNext.TextSize = 14
	btnNext.Typeface = Typeface.MONOSPACE
	btnNext.TextColor = Colors.White
	Dim cdNext As ColorDrawable
	cdNext.Initialize2(Colors.RGB(185, 46, 52), 10dip, 2dip, Colors.Black)
	btnNext.Background = cdNext

	DrawGraph(Active, panel, sale1, sale2, sale3, product, maxSales, TitleString)
End Sub

Public Sub DrawGraph(Active As Activity, panel As Panel, sale1() As Int, sale2() As Int, sale3() As Int, product() As String, maxSales As Int, TitleString As String)
	Try
		panel.Invalidate
		panel.RemoveAllViews
		panel.Height = 450dip
		If panel.Width = 0 Then
			panel.Width = 800dip
		End If
		
		panel.AddView(legendPanel, 0, 0, panel.Width, 30dip)
		
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
		panel.AddView(Title, 0, alignTopCenter / 2, panel.Width, 30dip)
    
		panel.AddView(activityPanel, alignLeftCenter, alignTopCenter, activityPanel.Width, activityPanel.Height)

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
			panel.AddView(productLabel, xPos + productLabelX, productLabelY, 100dip, 30dip)
		Next
    
		Dim numLabels As Int = 10
		For i = 0 To numLabels
			Dim labelValue As Int = Round((maxSale / numLabels) * i)
			Dim labelYPos As Int = activityPanel.Height - ((labelValue / maxSale) * activityPanel.Height)
			cv.DrawText(FormatNumberWithLabel(labelValue), alignLeftCenter - 10dip, labelYPos + alignTopCenter + 5dip, Typeface.MONOSPACE, 10, Colors.Black, "RIGHT")
		Next
		'btnBack.Enabled = currentPage > 1
		'btnNext.Enabled = (currentPage * itemsPerPage) < sale1.Length
		' Add buttons to panel without reinitializing
		panel.AddView(btnBack, alignLeftCenter, activityPanel.Height + alignTopCenter + 50dip, 100dip, 40dip)
       		panel.AddView(btnNext, activityPanel.Width - alignLeftCenter , activityPanel.Height + alignTopCenter + 50dip, 100dip, 40dip)
    

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