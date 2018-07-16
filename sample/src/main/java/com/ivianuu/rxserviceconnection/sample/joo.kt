package com.ivianuu.rxserviceconnection.sample

/**
 * @author Manuel Wrage (IVIanuu)
 * package com.xda.nobar.util;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.support.annotation.ColorInt;
import android.util.TypedValue;
import android.view.WindowManager;
import com.xda.nobar.App;
import com.xda.nobar.C0487R;
import com.xda.nobar.activities.IntroActivity;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J2\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0017j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0018J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010$\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00040'j\b\u0012\u0004\u0012\u00020\u0004`(2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010)\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010*\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010+\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010,\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010-\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010.\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u00100\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u00101\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u00102\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u00103\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u00104\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u00105\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u00106\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u00107\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u00108\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J2\u00109\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0017j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0018J\u000e\u0010:\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010;\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\nJ\u0016\u0010=\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\nJ\u0016\u0010?\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\nJ\u000e\u0010A\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010B\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010C\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010D\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010E\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010F\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010G\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006H"}, d2 = {"Lcom/xda/nobar/util/Utils;", "", "()V", "actionToName", "", "context", "Landroid/content/Context;", "action", "", "canRunHiddenCommands", "", "clearBlackNav", "", "disableNavImmersive", "dontMoveForKeyboard", "dpAsPx", "dpVal", "", "feedbackSound", "forceNavBlack", "forceTouchWizNavEnabled", "getActionList", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getBackupImmersive", "getCustomHeight", "getCustomHeightWithoutHitbox", "getCustomWidth", "getCustomWidthPercent", "getDefaultPillBGColor", "getDefaultPillFGColor", "getDefaultY", "getHandler", "Lcom/xda/nobar/App;", "getHomeX", "getHomeXPercent", "getHomeY", "getLauncherPackage", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getNavBarHeight", "getPillBGColor", "getPillCornerRadiusInDp", "getPillCornerRadiusInPx", "getPillFGColor", "getRealScreenSize", "Landroid/graphics/Point;", "hideInFullscreen", "hideOnLauncher", "isAccessibilityEnabled", "isFirstRun", "isInImmersive", "isOffForRebootOrScreenLock", "largerHitbox", "origBarInFullscreen", "resetBackupImmersive", "saveActionSet", "saveBackupImmersive", "setFirstRun", "isFirst", "setOffForRebootOrScreenLock", "off", "setShouldUseOverscanMethod", "use", "shouldShowShadow", "shouldUseImmersiveInsteadOfOverscan", "shouldUseOverscanMethod", "shouldUseRootCommands", "undoForceTouchWizNavEnabled", "useRot270Fix", "useTabletMode", "NoBar_1.1.6-18_06_08_1549_55_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: Utils.kt */
public final class Utils {
public static final Utils INSTANCE = new Utils();

public final boolean hideOnLauncher(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return false;
}

public final boolean shouldUseRootCommands(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return false;
}

private Utils() {
}

public final void disableNavImmersive(@org.jetbrains.annotations.NotNull android.content.Context r8) {
/* JADX: method processing error */
/*
Error: java.lang.NullPointerException
at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
at jadx.core.ProcessClass.process(ProcessClass.java:37)
at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
at jadx.core.ProcessClass.process(ProcessClass.java:42)
at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
at jadx.api.JavaClass.decompile(JavaClass.java:62)
at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
/*
r7 = this;
r0 = "context";
kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0);
r0 = r8.getContentResolver();
r1 = "policy_control";
r0 = android.provider.Settings.Global.getString(r0, r1);
if (r0 == 0) goto L_0x0078;
L_0x0011:
r1 = r0;
r1 = (java.lang.CharSequence) r1;
r0 = "immersive.navigation";
r0 = (java.lang.CharSequence) r0;
r2 = 2;
r3 = 0;
r4 = 0;
r0 = kotlin.text.StringsKt__StringsKt.contains$default(r1, r0, r3, r2, r4);
if (r0 == 0) goto L_0x0030;
L_0x0021:
r0 = INSTANCE;
r0.saveBackupImmersive(r8);
r8 = r8.getContentResolver();
r0 = "policy_control";
android.provider.Settings.Global.putString(r8, r0, r4);
goto L_0x0077;
L_0x0030:
r0 = "immersive.full";
r0 = (java.lang.CharSequence) r0;
r0 = kotlin.text.StringsKt__StringsKt.contains$default(r1, r0, r3, r2, r4);
if (r0 == 0) goto L_0x0072;
L_0x003a:
r0 = "=";
r2 = new java.lang.String[]{r0};
r3 = 0;
r4 = 0;
r5 = 6;
r6 = 0;
r0 = kotlin.text.StringsKt__StringsKt.split$default(r1, r2, r3, r4, r5, r6);
r1 = 1;
r0 = r0.get(r1);	 Catch:{ Exception -> 0x0050 }
r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0050 }
goto L_0x0052;
L_0x0050:
r0 = "*";
L_0x0052:
r1 = INSTANCE;
r1.saveBackupImmersive(r8);
r8 = r8.getContentResolver();
r1 = "policy_control";
r2 = new java.lang.StringBuilder;
r2.<init>();
r3 = "immersive.status=";
r2.append(r3);
r2.append(r0);
r0 = r2.toString();
android.provider.Settings.Global.putString(r8, r1, r0);
goto L_0x0077;
L_0x0072:
r0 = INSTANCE;
r0.resetBackupImmersive(r8);
L_0x0077:
return;
L_0x0078:
r7.resetBackupImmersive(r8);
return;
*/
throw new UnsupportedOperationException("Method not decompiled: com.xda.nobar.util.Utils.disableNavImmersive(android.content.Context):void");
}

public final boolean isInImmersive(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
context = Global.getString(context.getContentResolver(), "policy_control");
if (context == null) {
context = "";
}
CharSequence charSequence = (CharSequence) context;
return StringsKt__StringsKt.contains$default(charSequence, (CharSequence) "immersive.navigation", false, 2, null) || StringsKt__StringsKt.contains$default(charSequence, (CharSequence) "immersive.full", false, 2, null) != null;
}

@NotNull
public final Point getRealScreenSize(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
context = context.getSystemService("window");
if (context == null) {
throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
}
context = ((WindowManager) context).getDefaultDisplay();
Point point = new Point();
context.getRealSize(point);
return point;
}

public final int dpAsPx(@NotNull Context context, int i) {
Intrinsics.checkParameterIsNotNull(context, "context");
return dpAsPx(context, (float) i);
}

public final int dpAsPx(@NotNull Context context, float f) {
Intrinsics.checkParameterIsNotNull(context, "context");
context = context.getResources();
Intrinsics.checkExpressionValueIsNotNull(context, "r");
return Math.round(TypedValue.applyDimension(1, f, context.getDisplayMetrics()));
}

@NotNull
public final App getHandler(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
context = context.getApplicationContext();
if (context instanceof App) {
return (App) context;
}
StringBuilder stringBuilder = new StringBuilder();
stringBuilder.append("Bad app context: ");
stringBuilder.append(context.getClass().getSimpleName());
throw new IllegalStateException(stringBuilder.toString());
}

public final int getNavBarHeight(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
Object systemService = context.getSystemService("uimode");
if (systemService == null) {
throw new TypeCastException("null cannot be cast to non-null type android.app.UiModeManager");
} else if (((UiModeManager) systemService).getCurrentModeType() == 3) {
return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height_car_mode", "dimen", AbstractSpiCall.ANDROID_CLIENT_TYPE));
} else {
return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", AbstractSpiCall.ANDROID_CLIENT_TYPE));
}
}

public final void setOffForRebootOrScreenLock(@NotNull Context context, boolean z) {
Intrinsics.checkParameterIsNotNull(context, "context");
PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("special_off", z).apply();
}

public final boolean isOffForRebootOrScreenLock(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("special_off", false);
}

public final boolean shouldUseImmersiveInsteadOfOverscan(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("use_immersive", false);
}

public final void saveActionSet(@NotNull Context context, @NotNull HashMap<String, Integer> hashMap) {
Intrinsics.checkParameterIsNotNull(context, "context");
Intrinsics.checkParameterIsNotNull(hashMap, "map");
context = PreferenceManager.getDefaultSharedPreferences(context).edit();
hashMap.forEach((BiConsumer) new Utils$saveActionSet$1$1(context));
context.apply();
}

public final void getActionList(@org.jetbrains.annotations.NotNull android.content.Context r13, @org.jetbrains.annotations.NotNull java.util.HashMap<java.lang.String, java.lang.Integer> r14) {
/* JADX: method processing error */
/*
Error: java.lang.NullPointerException
at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
at jadx.core.ProcessClass.process(ProcessClass.java:37)
at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
at jadx.core.ProcessClass.process(ProcessClass.java:42)
at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
at jadx.api.JavaClass.decompile(JavaClass.java:62)
at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
/*
r12 = this;
r0 = "context";
kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r13, r0);
r0 = "map";
kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r0);
r0 = android.preference.PreferenceManager.getDefaultSharedPreferences(r13);	 Catch:{ Exception -> 0x0197 }
r13 = r12.getHandler(r13);	 Catch:{ Exception -> 0x0197 }
r1 = r13.getActionLeft();	 Catch:{ Exception -> 0x0197 }
r2 = r13.getTypeBack();	 Catch:{ Exception -> 0x0197 }
r2 = java.lang.String.valueOf(r2);	 Catch:{ Exception -> 0x0197 }
r1 = r0.getString(r1, r2);	 Catch:{ Exception -> 0x0197 }
r2 = "prefs.getString(app.acti… app.typeBack.toString())";	 Catch:{ Exception -> 0x0197 }
kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2);	 Catch:{ Exception -> 0x0197 }
r1 = java.lang.Integer.parseInt(r1);	 Catch:{ Exception -> 0x0197 }
r2 = r13.getActionRight();	 Catch:{ Exception -> 0x0197 }
r3 = r13.getTypeRecents();	 Catch:{ Exception -> 0x0197 }
r3 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x0197 }
r2 = r0.getString(r2, r3);	 Catch:{ Exception -> 0x0197 }
r3 = "prefs.getString(app.acti…p.typeRecents.toString())";	 Catch:{ Exception -> 0x0197 }
kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3);	 Catch:{ Exception -> 0x0197 }
r2 = java.lang.Integer.parseInt(r2);	 Catch:{ Exception -> 0x0197 }
r3 = r13.getActionTap();	 Catch:{ Exception -> 0x0197 }
r4 = r13.getTypeHome();	 Catch:{ Exception -> 0x0197 }
r4 = java.lang.String.valueOf(r4);	 Catch:{ Exception -> 0x0197 }
r3 = r0.getString(r3, r4);	 Catch:{ Exception -> 0x0197 }
r4 = "prefs.getString(app.acti… app.typeHome.toString())";	 Catch:{ Exception -> 0x0197 }
kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4);	 Catch:{ Exception -> 0x0197 }
r3 = java.lang.Integer.parseInt(r3);	 Catch:{ Exception -> 0x0197 }
r4 = r13.getActionHold();	 Catch:{ Exception -> 0x0197 }
r5 = r13.getTypeAssist();	 Catch:{ Exception -> 0x0197 }
r5 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x0197 }
r4 = r0.getString(r4, r5);	 Catch:{ Exception -> 0x0197 }
r5 = "prefs.getString(app.acti…pp.typeAssist.toString())";	 Catch:{ Exception -> 0x0197 }
kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5);	 Catch:{ Exception -> 0x0197 }
r4 = java.lang.Integer.parseInt(r4);	 Catch:{ Exception -> 0x0197 }
r5 = r13.getActionUp();	 Catch:{ Exception -> 0x0197 }
r6 = r13.getTypeNoAction();	 Catch:{ Exception -> 0x0197 }
r6 = java.lang.String.valueOf(r6);	 Catch:{ Exception -> 0x0197 }
r5 = r0.getString(r5, r6);	 Catch:{ Exception -> 0x0197 }
r6 = "prefs.getString(app.acti….typeNoAction.toString())";	 Catch:{ Exception -> 0x0197 }
kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6);	 Catch:{ Exception -> 0x0197 }
r5 = java.lang.Integer.parseInt(r5);	 Catch:{ Exception -> 0x0197 }
r6 = r13.getActionDown();	 Catch:{ Exception -> 0x0197 }
r7 = r13.getTypeHide();	 Catch:{ Exception -> 0x0197 }
r7 = java.lang.String.valueOf(r7);	 Catch:{ Exception -> 0x0197 }
r6 = r0.getString(r6, r7);	 Catch:{ Exception -> 0x0197 }
r7 = "prefs.getString(app.acti… app.typeHide.toString())";	 Catch:{ Exception -> 0x0197 }
kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7);	 Catch:{ Exception -> 0x0197 }
r6 = java.lang.Integer.parseInt(r6);	 Catch:{ Exception -> 0x0197 }
r7 = r13.getActionDouble();	 Catch:{ Exception -> 0x0197 }
r8 = r13.getTypeNoAction();	 Catch:{ Exception -> 0x0197 }
r8 = java.lang.String.valueOf(r8);	 Catch:{ Exception -> 0x0197 }
r7 = r0.getString(r7, r8);	 Catch:{ Exception -> 0x0197 }
r8 = "prefs.getString(app.acti….typeNoAction.toString())";	 Catch:{ Exception -> 0x0197 }
kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r8);	 Catch:{ Exception -> 0x0197 }
r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x0197 }
r8 = r13.getActionUpHold();	 Catch:{ Exception -> 0x0197 }
r9 = r13.getTypeNoAction();	 Catch:{ Exception -> 0x0197 }
r9 = java.lang.String.valueOf(r9);	 Catch:{ Exception -> 0x0197 }
r8 = r0.getString(r8, r9);	 Catch:{ Exception -> 0x0197 }
r9 = "prefs.getString(app.acti….typeNoAction.toString())";	 Catch:{ Exception -> 0x0197 }
kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r9);	 Catch:{ Exception -> 0x0197 }
r8 = java.lang.Integer.parseInt(r8);	 Catch:{ Exception -> 0x0197 }
r9 = r13.getActionLeftHold();	 Catch:{ Exception -> 0x0197 }
r10 = r13.getTypeNoAction();	 Catch:{ Exception -> 0x0197 }
r10 = java.lang.String.valueOf(r10);	 Catch:{ Exception -> 0x0197 }
r9 = r0.getString(r9, r10);	 Catch:{ Exception -> 0x0197 }
r10 = "prefs.getString(app.acti….typeNoAction.toString())";	 Catch:{ Exception -> 0x0197 }
kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r10);	 Catch:{ Exception -> 0x0197 }
r9 = java.lang.Integer.parseInt(r9);	 Catch:{ Exception -> 0x0197 }
r10 = r13.getActionRightHold();	 Catch:{ Exception -> 0x0197 }
r11 = r13.getTypeNoAction();	 Catch:{ Exception -> 0x0197 }
r11 = java.lang.String.valueOf(r11);	 Catch:{ Exception -> 0x0197 }
r0 = r0.getString(r10, r11);	 Catch:{ Exception -> 0x0197 }
r10 = "prefs.getString(app.acti….typeNoAction.toString())";	 Catch:{ Exception -> 0x0197 }
kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r10);	 Catch:{ Exception -> 0x0197 }
r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Exception -> 0x0197 }
r10 = r14;	 Catch:{ Exception -> 0x0197 }
r10 = (java.util.Map) r10;	 Catch:{ Exception -> 0x0197 }
r11 = r13.getActionLeft();	 Catch:{ Exception -> 0x0197 }
r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0197 }
r10.put(r11, r1);	 Catch:{ Exception -> 0x0197 }
r1 = r14;	 Catch:{ Exception -> 0x0197 }
r1 = (java.util.Map) r1;	 Catch:{ Exception -> 0x0197 }
r10 = r13.getActionRight();	 Catch:{ Exception -> 0x0197 }
r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0197 }
r1.put(r10, r2);	 Catch:{ Exception -> 0x0197 }
r1 = r14;	 Catch:{ Exception -> 0x0197 }
r1 = (java.util.Map) r1;	 Catch:{ Exception -> 0x0197 }
r2 = r13.getActionTap();	 Catch:{ Exception -> 0x0197 }
r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0197 }
r1.put(r2, r3);	 Catch:{ Exception -> 0x0197 }
r1 = r14;	 Catch:{ Exception -> 0x0197 }
r1 = (java.util.Map) r1;	 Catch:{ Exception -> 0x0197 }
r2 = r13.getActionHold();	 Catch:{ Exception -> 0x0197 }
r3 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0197 }
r1.put(r2, r3);	 Catch:{ Exception -> 0x0197 }
r1 = r14;	 Catch:{ Exception -> 0x0197 }
r1 = (java.util.Map) r1;	 Catch:{ Exception -> 0x0197 }
r2 = r13.getActionUp();	 Catch:{ Exception -> 0x0197 }
r3 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0197 }
r1.put(r2, r3);	 Catch:{ Exception -> 0x0197 }
r1 = r14;	 Catch:{ Exception -> 0x0197 }
r1 = (java.util.Map) r1;	 Catch:{ Exception -> 0x0197 }
r2 = r13.getActionDown();	 Catch:{ Exception -> 0x0197 }
r3 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0197 }
r1.put(r2, r3);	 Catch:{ Exception -> 0x0197 }
r1 = r14;	 Catch:{ Exception -> 0x0197 }
r1 = (java.util.Map) r1;	 Catch:{ Exception -> 0x0197 }
r2 = r13.getActionDouble();	 Catch:{ Exception -> 0x0197 }
r3 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0197 }
r1.put(r2, r3);	 Catch:{ Exception -> 0x0197 }
r1 = r14;	 Catch:{ Exception -> 0x0197 }
r1 = (java.util.Map) r1;	 Catch:{ Exception -> 0x0197 }
r2 = r13.getActionUpHold();	 Catch:{ Exception -> 0x0197 }
r3 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0197 }
r1.put(r2, r3);	 Catch:{ Exception -> 0x0197 }
r1 = r14;	 Catch:{ Exception -> 0x0197 }
r1 = (java.util.Map) r1;	 Catch:{ Exception -> 0x0197 }
r2 = r13.getActionLeftHold();	 Catch:{ Exception -> 0x0197 }
r3 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x0197 }
r1.put(r2, r3);	 Catch:{ Exception -> 0x0197 }
r14 = (java.util.Map) r14;	 Catch:{ Exception -> 0x0197 }
r13 = r13.getActionRightHold();	 Catch:{ Exception -> 0x0197 }
r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0197 }
r14.put(r13, r0);	 Catch:{ Exception -> 0x0197 }
L_0x0197:
return;
*/
throw new UnsupportedOperationException("Method not decompiled: com.xda.nobar.util.Utils.getActionList(android.content.Context, java.util.HashMap):void");
}

@NotNull
public final String actionToName(@NotNull Context context, int i) {
Intrinsics.checkParameterIsNotNull(context, "context");
Context applicationContext = context.getApplicationContext();
if (applicationContext == null) {
throw new TypeCastException("null cannot be cast to non-null type com.xda.nobar.App");
}
App app = (App) applicationContext;
context = context.getResources();
int i2 = 17039375;
if (i == app.getTypeNoAction()) {
i2 = C0487R.string.nothing;
} else if (i == app.getTypeBack()) {
i2 = C0487R.string.back;
} else if (i == app.getTypeOhm()) {
i2 = C0487R.string.ohm;
} else if (i == app.getTypeRecents()) {
i2 = C0487R.string.recents;
} else if (i == app.getTypeHide()) {
i2 = C0487R.string.hide;
} else if (i == app.getTypeSwitch()) {
i2 = C0487R.string.switch_apps;
} else if (i == app.getTypeAssist()) {
i2 = C0487R.string.assist;
} else if (i == app.getTypeHome()) {
i2 = C0487R.string.home;
} else if (i == app.getPremTypeNotif()) {
i2 = C0487R.string.prem_notif;
} else if (i == app.getPremTypeQs()) {
i2 = C0487R.string.prem_qs;
} else if (i == app.getPremTypePower()) {
i2 = C0487R.string.prem_power;
} else if (i == app.getTypeSplit()) {
i2 = C0487R.string.split;
} else if (i != app.getPremTypeVibe()) {
if (i != app.getPremTypeSilent()) {
if (i != app.getPremTypeMute()) {
if (i == app.getPremTypePlayPause()) {
i2 = C0487R.string.prem_play_pause;
} else if (i == app.getPremTypeNext()) {
i2 = C0487R.string.prem_next;
} else if (i == app.getPremTypePrev()) {
i2 = C0487R.string.prem_prev;
} else if (i == app.getTypeRootHoldBack()) {
i2 = C0487R.string.hold_back;
} else if (i == app.getTypeRootForward()) {
i2 = C0487R.string.forward;
} else if (i == app.getTypeRootMenu()) {
i2 = C0487R.string.menu;
} else if (i == app.getTypeRootSleep()) {
i2 = C0487R.string.sleep;
} else if (i == app.getPremTypeRootVolUp()) {
i2 = C0487R.string.prem_vol_up;
} else if (i == app.getPremTypeRootVolDown()) {
i2 = C0487R.string.prem_vol_down;
} else if (i == app.getPremTypeRootScreenshot()) {
i2 = C0487R.string.prem_type_screenshot;
} else if (i == app.getPremTypeSwitchIme()) {
i2 = C0487R.string.prem_switch_ime;
} else if (i == app.getPremTypeLaunchApp()) {
i2 = C0487R.string.prem_launch_app;
}
}
}
}
context = context.getString(i2);
Intrinsics.checkExpressionValueIsNotNull(context, "context.resources.getStr…tring.untitled\n        })");
return context;
}

public final boolean shouldUseOverscanMethod(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("hide_nav", false);
}

public final void setShouldUseOverscanMethod(@NotNull Context context, boolean z) {
Intrinsics.checkParameterIsNotNull(context, "context");
PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("hide_nav", z).apply();
}

public final void forceTouchWizNavEnabled(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
Global.putInt(context.getContentResolver(), "navigationbar_hide_bar_enabled", 0);
}

public final void undoForceTouchWizNavEnabled(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
Global.putString(context.getContentResolver(), "navigationbar_hide_bar_enabled", null);
}

public final int getHomeY(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getInt("custom_y", getDefaultY(context));
}

public final int getDefaultY(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return (getNavBarHeight(context) / 2) - (context.getResources().getDimensionPixelSize(C0487R.dimen.pill_height) / 2);
}

public final int getHomeX(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return (int) ((((float) getHomeXPercent(context)) / 100.0f) * ((((float) getRealScreenSize(context).x) / 2.0f) - (((float) getCustomWidth(context)) / 1073741824)));
}

public final int getHomeXPercent(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getInt("custom_x_percent", context.getResources().getInteger(C0487R.integer.pill_x_pos_percent));
}

public final int getCustomWidth(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return (int) ((((float) getCustomWidthPercent(context)) / 100.0f) * ((float) getRealScreenSize(context).x));
}

public final int getCustomWidthPercent(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getInt("custom_width_percent", context.getResources().getInteger(C0487R.integer.pill_width_percent));
}

public final int getCustomHeight(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
int customHeightWithoutHitbox = getCustomHeightWithoutHitbox(context);
return largerHitbox(context) ? customHeightWithoutHitbox + context.getResources().getDimensionPixelSize(C0487R.dimen.pill_large_hitbox_height_increase) : customHeightWithoutHitbox;
}

public final int getCustomHeightWithoutHitbox(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getInt("custom_height", context.getResources().getDimensionPixelSize(C0487R.dimen.pill_height));
}

@ColorInt
public final int getPillBGColor(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getInt("pill_bg", getDefaultPillBGColor());
}

public final int getDefaultPillBGColor() {
return Color.argb(238, 204, 204, 204);
}

@ColorInt
public final int getPillFGColor(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getInt("pill_fg", getDefaultPillFGColor());
}

public final int getDefaultPillFGColor() {
return Color.argb(50, 34, 34, 34);
}

public final int getPillCornerRadiusInDp(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getInt("pill_corner_radius", 8);
}

public final int getPillCornerRadiusInPx(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return dpAsPx(context, getPillCornerRadiusInDp(context));
}

public final boolean shouldShowShadow(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("show_shadow", true);
}

public final boolean dontMoveForKeyboard(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("static_pill", false);
}

public final boolean useRot270Fix(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("rot270_fix", false);
}

public final boolean useTabletMode(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("tablet_mode", false);
}

public final boolean feedbackSound(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("audio_feedback", true);
}

public final boolean isAccessibilityEnabled(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
String string = Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
if (string == null) {
return false;
}
CharSequence charSequence = string;
context = context.getPackageName();
Intrinsics.checkExpressionValueIsNotNull(context, "context.packageName");
if (StringsKt__StringsKt.contains$default(charSequence, (CharSequence) context, false, 2, null) != null) {
return true;
}
return false;
}

public final boolean isFirstRun(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("first_run", true);
}

public final void setFirstRun(@NotNull Context context, boolean z) {
Intrinsics.checkParameterIsNotNull(context, "context");
PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("first_run", z).apply();
}

public final void saveBackupImmersive(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
PreferenceManager.getDefaultSharedPreferences(context).edit().putString("def_imm", Global.getString(context.getContentResolver(), "policy_control")).apply();
}

public final void resetBackupImmersive(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
PreferenceManager.getDefaultSharedPreferences(context).edit().remove("def_imm").apply();
}

@NotNull
public final String getBackupImmersive(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
context = PreferenceManager.getDefaultSharedPreferences(context).getString("def_imm", "immersive.none");
Intrinsics.checkExpressionValueIsNotNull(context, "PreferenceManager.getDef…f_imm\", \"immersive.none\")");
return context;
}

public final boolean canRunHiddenCommands(@org.jetbrains.annotations.NotNull android.content.Context r4) {
/* JADX: method processing error */
/*
Error: java.lang.NullPointerException
at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
at jadx.core.ProcessClass.process(ProcessClass.java:37)
at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
at jadx.core.ProcessClass.process(ProcessClass.java:42)
at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
at jadx.api.JavaClass.decompile(JavaClass.java:62)
at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
/*
r3 = this;
r0 = "context";
kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0);
r0 = 0;
r1 = 1;
r2 = "window";	 Catch:{ Throwable -> 0x0027 }
r4 = r4.getSystemService(r2);	 Catch:{ Throwable -> 0x0027 }
if (r4 != 0) goto L_0x0017;	 Catch:{ Throwable -> 0x0027 }
L_0x000f:
r4 = new kotlin.TypeCastException;	 Catch:{ Throwable -> 0x0027 }
r2 = "null cannot be cast to non-null type android.view.WindowManager";	 Catch:{ Throwable -> 0x0027 }
r4.<init>(r2);	 Catch:{ Throwable -> 0x0027 }
throw r4;	 Catch:{ Throwable -> 0x0027 }
L_0x0017:
r4 = (android.view.WindowManager) r4;	 Catch:{ Throwable -> 0x0027 }
r4 = r4.getDefaultDisplay();	 Catch:{ Throwable -> 0x0027 }
r2 = new android.graphics.Rect;	 Catch:{ Throwable -> 0x0027 }
r2.<init>();	 Catch:{ Throwable -> 0x0027 }
r4.getOverscanInsets(r2);	 Catch:{ Throwable -> 0x0027 }
r4 = r1;
goto L_0x0028;
L_0x0027:
r4 = r0;
L_0x0028:
if (r4 == 0) goto L_0x0033;
L_0x002a:
r4 = com.xda.nobar.util.IWindowManager.INSTANCE;
r4 = r4.canRunCommands();
if (r4 == 0) goto L_0x0033;
L_0x0032:
r0 = r1;
L_0x0033:
return r0;
*/
throw new UnsupportedOperationException("Method not decompiled: com.xda.nobar.util.Utils.canRunHiddenCommands(android.content.Context):boolean");
}

@NotNull
public final ArrayList<String> getLauncherPackage(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
Intent intent = new Intent("android.intent.action.MAIN");
intent.addCategory("android.intent.category.HOME");
context = context.getPackageManager().queryIntentActivities(intent, 0);
ArrayList<String> arrayList = new ArrayList();
Intrinsics.checkExpressionValueIsNotNull(context, "info");
for (ResolveInfo resolveInfo : (Iterable) context) {
arrayList.add(resolveInfo.activityInfo.packageName);
}
return arrayList;
}

public final void forceNavBlack(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
PreferenceManager.getDefaultSharedPreferences(context).edit().putString("navigationbar_color", Global.getString(context.getContentResolver(), "navigationbar_color")).putString("navigationbar_current_color", Global.getString(context.getContentResolver(), "navigationbar_current_color")).putString("navigationbar_use_theme_default", Global.getString(context.getContentResolver(), "navigationbar_use_theme_default")).apply();
int argb = Color.argb(255, 0, 0, 0);
if (!IntroActivity.Companion.needsToRun(context) && shouldUseOverscanMethod(context) && VERSION.SDK_INT > 22) {
Global.putInt(context.getContentResolver(), "navigationbar_color", argb);
Global.putInt(context.getContentResolver(), "navigationbar_current_color", argb);
Global.putInt(context.getContentResolver(), "navigationbar_use_theme_default", 0);
}
}

public final void clearBlackNav(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
if (!IntroActivity.Companion.needsToRun(context) && shouldUseOverscanMethod(context) && VERSION.SDK_INT > 22) {
Global.putString(context.getContentResolver(), "navigationbar_color", defaultSharedPreferences.getString("navigationbar_color", null));
Global.putString(context.getContentResolver(), "navigationbar_current_color", defaultSharedPreferences.getString("navigationbar_current_color", null));
Global.putString(context.getContentResolver(), "navigationbar_use_theme_default", defaultSharedPreferences.getString("navigationbar_use_theme_default", null));
}
}

public final boolean hideInFullscreen(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("hide_in_fullscreen", true);
}

public final boolean largerHitbox(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("larger_hitbox", true);
}

public final boolean origBarInFullscreen(@NotNull Context context) {
Intrinsics.checkParameterIsNotNull(context, "context");
return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("orig_nav_in_immersive", false);
}
}

 */