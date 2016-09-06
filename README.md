# DropDownWarning
Easy to implemente a drop down warning/ message

<img src="gif/bounce.gif" width="200">
<img src="gif/standart.gif" width="200">

# Installation

[Download the .aar file](https://github.com/Brudigem/DropDownWarning/raw/master/dropdownwarninglibrary-release.aar)

Go to *File* -> *New* -> *New Module* -> *Import .Jar/.AAR Package*

Add this to your dependecies
```
dependecies{
    complile project (":dropdownwarninglibrary-release")
}

```

# Code


First you need the top level Layout (most of the times it's a relative layout), you will need to give it an id in the XML.

```
RelativeLayout rootView = (RelativeLayout) findViewById(R.id.rootView);
```
Next you need to create a DropDownWarning.Builder

##Builder
```
DropDownWarning dropDownWarning = DropDownWarning.Builder(Context context, ViewGroup parent)

    .interpolatorIn(Interpolator interpolator) //Intepolator used for the "show" animation
    
    .interpolatorOut(Interpolator interpolator) //Interpolator used for the "hide" animation
    
    .animationLength(int length) //Lenght of the animation in ms
    
    .textHeight(int height) //Height of the text view
    
    .message(String message) //Message to display
    
    .foregroundColor(int color) //Color of the text in argb
    
    .backgroundColor(int color) //Color of the background in argb
    
    .build() //return DropDownWarning
```


To display the warning you need to call:
```
dropDownWarning.show()
```
and to hide it:
```
dropDownWarning.hide()
```

#License
```
MIT License

Copyright (c) 2016 Norbert Kozsir

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```


