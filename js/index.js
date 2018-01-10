/**
 * @providesModule RNShakeEvent
 * @flow
 */
'use strict';

import React, {DeviceEventEmitter, NativeModules} from 'react-native';
import invariant from 'invariant';

var listener;
class RNShakeEvent {
  static addEventListener(type, handler) {
    invariant(
      type === 'shake',
      'RNShakeEventIOS only supports `shake` event'
    );
    listener = DeviceEventEmitter.addListener('ShakeEvent', () => {
      if (handler) {
        handler();
      }
    });
  }
  static removeEventListener(type, handler) {
    invariant(
      type === 'shake',
      'RNShakeEventIOS only supports `shake` event'
    );
    if (!listener) {
      return;
    }
    if (handler) {
      handler();
    }
    listener.remove();
  }
};

export default RNShakeEvent;