package com.jadsonlourenco.RNShakeEvent;

import android.content.Context;
import android.hardware.SensorManager;
import android.support.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.squareup.seismic.ShakeDetector;

/**
 * Created by richard on 20/09/16.
 */
public class RNShakeEventModule extends ReactContextBaseJavaModule implements ShakeDetector.Listener {
    public RNShakeEventModule(ReactApplicationContext reactContext) {
        super(reactContext);
        SensorManager sensorManager = (SensorManager) reactContext.getSystemService(Context.SENSOR_SERVICE);
        ShakeDetector shakeDetector = new ShakeDetector(this);
        shakeDetector.start(sensorManager);
    }

    @Override
    public String getName() {
        return "RNShakeEvent";
    }

    @Override
    public void hearShake() {
        sendEvent(this.getReactApplicationContext(), "ShakeEvent", null);
    }

    private void sendEvent(ReactContext reactContext,
                           String eventName,
                           @Nullable WritableMap params) {
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, params);
    }
}
