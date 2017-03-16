#include <string.h>
#include <jni.h>
JNIEXPORT jstring JNICALL
Java_com_bazhangkeji_demo01_MainActivity_stringFromJNI(JNIEnv *env, jobject instance) {

    return (*env)->NewStringUTF(env, "Hello from JNI !");
}
