B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=13.1
@EndOfDesignText@
Sub Class_Globals

	Dim activityPanel As Panel
End Sub

Public Sub Initialize(Active As Activity, panel As Panel, sale1() As Int, sale2() As Int, sale3() As Int, product() As String , legend() As String, maxSales As Int, TitleString As String)
	panel.RemoveAllViews
	panel.Height = 400dip

	Dim activityPanel As Panel
	activityPanel.Initialize("activityPanel")
	
	activityPanel.Width = 80%x
	If Active.Width > 800 Then
		activityPanel.Width = 55%x
	End If
	activityPanel.Height = 250dip
	activityPanel.Color = Colors.ARGB(70, 211, 211, 211)
	
	Dim alignLeftCenter As Int = (Active.Width - activityPanel.Width) / 2
	Dim alignTopCenter As Int = (panel.Height - activityPanel.Height) / 2
	
	Dim Title As Label
	Title.Initialize("")
	Title.Text = TitleString
	Title.TextSize = 20
	Title.Typeface = Typeface.MONOSPACE
	Title.Gravity = Gravity.CENTER
	Title.TextColor = Colors.Black
	
	' Add legend above the title
	Dim legendPanel As Panel
	legendPanel.Initialize("")
	legendPanel.Width = panel.Width
	legendPanel.Height = 30dip
	panel.AddView(legendPanel, (panel.Width/2) + 20dip, 0, activityPanel.Width/2, 30dip)
	
	Dim legend() As String = Array As String("Sales 1", "Sales 2", "Sales 3")
	Dim color() As Int = Array As Int(Colors.RGB(255, 0, 0), Colors.RGB(200, 20, 20), Colors.RGB(100, 10, 10))

	Dim legendWidth As Int = legendPanel.Width / legend.Length
	
	For i = 0 To legend.Length - 1
		Dim colorLabel As Label
		colorLabel.Initialize("")
		colorLabel.Color = color(i)
		legendPanel.AddView(colorLabel, (legendWidth * i)+20dip, 10dip, 10dip, legendPanel.Height-18dip)

		Dim legendLabel As Label
		legendLabel.Initialize("")
		legendLabel.Text = legend(i)
		legendLabel.TextColor = Colors.black  ' Set text color for better visibility
		legendLabel.Gravity = Gravity.CENTER
		legendPanel.AddView(legendLabel, (legendWidth * i)+30dip, 0dip, legendWidth-30dip, legendPanel.Height)
	Next

	' Add title label below the legend
	panel.AddView(Title, 0, alignTopCenter / 2, panel.Width, 30dip)
	
	' Add the panel to the activity
	panel.AddView(activityPanel, alignLeftCenter, alignTopCenter, activityPanel.Width, activityPanel.Height)

	' Create a Canvas object to draw on the panel
	Dim graphCanvas As Canvas
	graphCanvas.Initialize(activityPanel)

	' Define the maximum sale value to scale the bars accordingly
	Dim maxSale As Int = maxSales * 1.2

	Dim cv As Canvas
	cv.Initialize(panel)
    
	' Draw bars
	Dim totalProducts As Int =  sale1.Length
	Dim barsPerProduct As Int = 3
	Dim totalBars As Int = totalProducts * barsPerProduct
	Dim gap As Int = 5dip
	Dim productGap As Int = 15dip
	Dim padding As Int = 20dip
    
	Dim availableWidth As Int = activityPanel.Width - (padding * 2) - ((totalProducts - 1) * productGap) - ((totalBars - totalProducts) * gap)
	Dim barWidth As Int = availableWidth / totalBars
	Dim xStart As Int = padding
    
	Dim graphCanvas As Canvas
	graphCanvas.Initialize(activityPanel)
    
	For i = 0 To totalProducts - 1
		Dim xPos As Int = xStart + i * (barsPerProduct * (barWidth + gap) + productGap)
		Dim saleValues() As Int = Array As Int(sale1(i), sale2(i), sale3(i))
        
		For j = 0 To barsPerProduct - 1
			Dim sale As Int = saleValues(j)
			Dim barHeight As Int = (sale / maxSale) * (activityPanel.Height - 50dip)
			Dim xBar As Int = xPos + j * (barWidth + gap)
            
			Dim r As Rect
			r.Initialize(xBar, activityPanel.Height - barHeight, xBar + barWidth, panel.Height)
			graphCanvas.DrawRect(r, color(j), True, 2dip)
            
			' Display sales value
			Dim fontSize As Int = 8
			If Active.Width > 800 Then
				fontSize = 10
			End If
			graphCanvas.DrawText( FormatNumberWithSuffix(sale), xBar + (barWidth / 2), activityPanel.Height - barHeight - 5dip, Typeface.MONOSPACE, fontSize, Colors.Black, "CENTER")
		Next
		
		Dim productLabelY As Int = activityPanel.Height + alignTopCenter + 20dip
		Dim productLabelX As Int = alignLeftCenter + 50dip
		cv.DrawText(product(i), xPos + productLabelX, productLabelY, Typeface.MONOSPACE, 12, Colors.Black, "CENTER")
	Next
	Dim numLabels As Int = 10
	For i = 0 To numLabels
		Dim labelValue As Int = Round((maxSale / numLabels) * i) ' Ensure whole number
		Dim labelYPos As Int = activityPanel.Height - ((labelValue / maxSale) * activityPanel.Height) ' Adjust Y position based on the scale

		' Use IntToString to avoid decimal points
		cv.DrawText(FormatNumberWithLabel(labelValue), alignLeftCenter - 10dip, labelYPos + alignTopCenter + 5dip, Typeface.MONOSPACE, 10, Colors.Black, "RIGHT")
	Next
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
        Return number ' No formatting needed for values below 1000
    End If
End Sub

Sub DrawWrappedTextRotated(canvas As Canvas, text As String, x As Int, y As Int, maxWidth As Int, fontSize As Float, color As Int, alignment As String, angle As Float) As Int
	Dim words() As String = Regex.Split(" ", text)
	Dim line As String = ""
	Dim lineHeight As Int = 20dip ' Space between lines
	Dim originalY As Int = y ' Store original Y position

	For Each word As String In words
		Dim testLine As String = line & word & " "
		Dim textWidth As Int = canvas.MeasureStringWidth(testLine, Typeface.MONOSPACE, fontSize)

		If textWidth > maxWidth And line <> "" Then
			' Draw the current line
			canvas.DrawTextRotated(line, x, y, Typeface.DEFAULT_BOLD, fontSize, color, alignment, angle)
			y = y + lineHeight ' Move to next line
			line = word & " " ' Start new line
		Else
			line = testLine ' Add word to current line
		End If
	Next

	' Draw the last line
	If line <> "" Then
		canvas.DrawTextRotated(line, x, y, Typeface.DEFAULT_BOLD, fontSize, color, alignment, angle)
		y = y + lineHeight ' Move final Y position
	End If

	' Return the new height
	Return y - originalY
End Sub