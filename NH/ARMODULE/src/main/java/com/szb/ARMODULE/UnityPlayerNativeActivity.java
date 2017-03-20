package com.szb.ARMODULE;

import com.unity3d.player.*;
import android.app.NativeActivity;
import android.os.Bundle;
import android.util.Log;

public class UnityPlayerNativeActivity extends UnityPlayerActivity
{
	@Override protected void onCreate (Bundle savedInstanceState)
	{
		Log.w("Unity", "UnityPlayerNativeActivity has been deprecated, please update your AndroidManifest to use UnityPlayerActivity instead");
		super.onCreate(savedInstanceState);
	}
}
