package com.rodrigoguerrero.mymoney.components.common

import android.content.res.Configuration
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditableTextField(
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    text: String,
    placeholder: String,
    label: String,
    backgroundColor: Color,
    textColor: Color,
    cursorColor: Color,
    onTextChanged: (String) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(MyMoneyTheme.padding.s)
    ) {
        Text(
            text = label,
            style = MyMoneyTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold,
            color = MyMoneyTheme.color.onPrimaryContainer
        )

        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = onTextChanged,
            interactionSource = interactionSource,
            keyboardOptions = keyboardOptions,
            decorationBox = { innerTextField ->
                TextFieldDefaults.TextFieldDecorationBox(
                    value = text,
                    innerTextField = innerTextField,
                    enabled = true,
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    interactionSource = interactionSource,
                    colors = TextFieldDefaults.textFieldColors(
                        focusedTextColor = textColor,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        containerColor = backgroundColor
                    ),
                    placeholder = {
                        Text(
                            text = placeholder,
                            fontWeight = FontWeight.Bold,
                            color = textColor,
                            style = MyMoneyTheme.typography.labelMedium,
                        )
                    },
                    shape = MyMoneyTheme.shapes.medium,
                    contentPadding = PaddingValues(
                        horizontal = MyMoneyTheme.padding.s,
                        vertical = dimensionResource(id = R.dimen.editable_text_vertical_padding)
                    )
                )
            },
            maxLines = 1,
            textStyle = LocalTextStyle.current.copy(color = textColor),
            cursorBrush = SolidColor(cursorColor)
        )
    }
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showBackground = true)
@Composable
private fun PreviewEditableTextField() {
    MyMoneyTheme {
        EditableTextField(
            placeholder = "Placeholder",
            label = "Label",
            backgroundColor = Color.Gray,
            textColor = Color.Black,
            cursorColor = Color.Black,
            text = "",
            onTextChanged = { }
        )
    }
}
