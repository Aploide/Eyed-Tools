package de.aploi.eyedtools

import android.content.ClipData
import android.content.Context
import android.content.ClipboardManager
import kotlin.random.Random

fun copyToClipboard(context: Context, text: String) {
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("Copied Text", text)
    clipboard.setPrimaryClip(clip)
}


fun generatePassword(length: Float, want_symb: Boolean, want_numb: Boolean): String {
    // Characters to be used in password
    var total = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val numbers = "0123456789"
    val symbols = "!@#\$%^&*()_+-={}[]|;:<>,.?/"

    // Building the character pool based on user preferences
    if (want_symb) total += symbols
    if (want_numb) total += numbers

    // Generate password
    val password = StringBuilder()
    for (i in 0 until length.toInt()) {
        val randomIndex = Random.nextInt(total.length)
        password.append(total[randomIndex])
    }

    return password.toString()
}