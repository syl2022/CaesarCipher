# CaesarCipher

This project serves 2 endpoints:
* ``/api/cipher/encrypt``
* ``/api/cipher/decrypt``

Both the endpoints accepts the following json input-

```
{
"text": "Input text",
"shiftKey": 5
}
```

And returns back the following json:

```
{
"text": "Output encrypted text in case there is no exception",
"error": "Exception message in case of any exception"
}
```

The code is specifically handles all the printable ASCII characters leaving any other character as it is.
The encryption is via simple Caesar Cipher logic.

