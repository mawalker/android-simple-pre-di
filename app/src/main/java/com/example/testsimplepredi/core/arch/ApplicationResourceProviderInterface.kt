package com.example.testsimplepredi.core.arch

import android.content.res.AssetFileDescriptor
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.content.res.Resources
import android.content.res.TypedArray
import android.content.res.XmlResourceParser
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.TypedValue
import java.io.InputStream

interface ApplicationResourceProviderInterface {

    @Throws(Resources.NotFoundException::class)
    fun getString(resId: Int): String

    @Throws(Resources.NotFoundException::class)
    fun getString(resId: Int, vararg formatArgs: Any?): String {
        throw RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getResourcePackageName(resid: Int): String? {
        throw RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getQuantityString(id: Int, quantity: Int, vararg formatArgs: Any?): String {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getQuantityString(id: Int, quantity: Int): String {
        throw java.lang.RuntimeException("Stub!")
    }

    fun getSystem(): Resources? {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getStringArray(id: Int): Array<String?> {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getIntArray(id: Int): IntArray {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun obtainTypedArray(id: Int): TypedArray {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getDimension(id: Int): Float {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getDimensionPixelOffset(id: Int): Int {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getDimensionPixelSize(id: Int): Int {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getDrawable(id: Int, theme: Resources.Theme?): Drawable? {
        throw java.lang.RuntimeException("Stub!")
    }

    fun getDrawableForDensity(id: Int, density: Int, theme: Resources.Theme?): Drawable? {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getColor(id: Int, theme: Resources.Theme?): Int {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getColorStateList(id: Int, theme: Resources.Theme?): ColorStateList {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getBoolean(id: Int): Boolean {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getInteger(id: Int): Int {
        throw java.lang.RuntimeException("Stub!")
    }

    fun getFloat(id: Int): Float {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getLayout(id: Int): XmlResourceParser {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getAnimation(id: Int): XmlResourceParser {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getXml(id: Int): XmlResourceParser {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun openRawResource(id: Int): InputStream {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun openRawResource(id: Int, value: TypedValue?): InputStream {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun openRawResourceFd(id: Int): AssetFileDescriptor? {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getValue(id: Int, outValue: TypedValue?, resolveRefs: Boolean) {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getValueForDensity(id: Int, density: Int, outValue: TypedValue?, resolveRefs: Boolean) {
        throw java.lang.RuntimeException("Stub!")
    }

    @Throws(Resources.NotFoundException::class)
    fun getValue(name: String?, outValue: TypedValue?, resolveRefs: Boolean) {
        throw java.lang.RuntimeException("Stub!")
    }

    fun getAttributeSetSourceResId(set: AttributeSet?): Int {
        throw java.lang.RuntimeException("Stub!")
    }

    fun newTheme(): Resources.Theme {
        throw java.lang.RuntimeException("Stub!")
    }

    fun obtainAttributes(set: AttributeSet?, attrs: IntArray?): TypedArray? {
        throw java.lang.RuntimeException("Stub!")
    }

    fun getDisplayMetrics(): DisplayMetrics? {
        throw java.lang.RuntimeException("Stub!")
    }

    fun getConfiguration(): Configuration? {
        throw java.lang.RuntimeException("Stub!")
    }


}