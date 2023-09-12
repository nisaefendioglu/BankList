-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose

-keepattributes Signature
-keepattributes *Annotation*

-keep public class com.nisaefendioglu.banklist.App


-keepclassmembers class **.R$* {
    public static <fields>;
}

-keep class android.support.** { *; }
-keep class androidx.** { *; }
