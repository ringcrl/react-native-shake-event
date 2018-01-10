## Source

author: Jadson Lourenco <jadsonlourenco@gmail.com>

homepage: <https://github.com/jadsonlourenco/react-native-shake-event>

Notes: Source can not be used directly, republish it...

---

Add the shake event on your React Native app, giving to users improved usability. Enjoy!
*(works only on real device)*

## Install

```shell
$ npm install @chenng/react-native-shake-event --save
```

### Linking Libraries

`react-native link react-native-shake-event`

## Usage

```js
import RNShakeEvent from 'react-native-shake-event';

class MyComponent extends React.Component {
  componentWillMount() {
    RNShakeEvent.addEventListener('shake', () => {
      console.log('Device shake!');
    });
  }

  componentWillUnmount() {
    RNShakeEvent.removeEventListener('shake');
  }
}
```

## API

### RNShakeEvent

#### addEventListener('shake', Function)

Start listening the shake event and handle a callback function.

#### removeEventListener('shake', Function)

Stop to listening the shake event, and is recommended to prevent memory leak.

## Issues

On *debug mode* this event also handle the **DevMenu**, but works fine on *production*.

## License

MIT
