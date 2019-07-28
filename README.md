# document-recognition-sample
this project use ZXing camera library.

A sample ZXing application is available in [Releases](https://github.com/journeyapps/zxing-android-embedded/releases).

## <a name="how_to_add_documentrecognition_library_to_your_project"></a> How to add DocumentRecognition library to your project

Download the aar file from our website ..., import aar file to folder `src\main\libs`. To install them, simply add the following lines to your project `build.gradle`.

```gradle
allprojects {
    repositories {
        flatDir{
            dirs 'src/main/libs'
        }
    }
}
```

and add implementation to your app `build.gradle`.

```gradle
implementation(name:'documentrecognition', ext: 'aar')
```


### Installing

```java
DocumentRecognition document = new DocumentRecognition(context, YOUR_LICENSE_KEY);
document.initiateScan();
```

### Get Result while scanning

```java
@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
     DocumentResults results = DocumentRecognition.parseActivityResult(requestCode,resultCode,data);
     Toast.makeText(this, results.getLines(), Toast.LENGTH_LONG).show();
     super.onActivityResult(requestCode, resultCode, data);
}
```    


## License

Licensed under the [Apache License 2.0][7]

	Copyright (C) 2012-2018 ZXing authors, Journey Mobile

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	    http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
