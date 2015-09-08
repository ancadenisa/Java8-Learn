print('Hello World - invoked by Java from Javascript');

//The following javascript functions will later be called from the java side
var fun1 = function(name) {
    print('Hi there from Javascript, ' + name + ' - invoked by Java from Javascript');
    return "greetings from javascript - invoked by Java from Javascript";
};

var fun2 = function (object) {
    print("JS Class Definition: " + Object.prototype.toString.call(object) + "- invoked by Java from Javascript");
};

var BasicUsageClass = Java.type('Nashorn.BasicUsage');
var result = BasicUsageClass.javaFun1("Anca");
print(result);

/*----------------------------------------Invoking Java Methods from Javascript--------------------------------------*/
BasicUsageClass.fun2(123);
// class java.lang.Integer

BasicUsageClass.fun2(49.99);
// class java.lang.Double

BasicUsageClass.fun2(true);
// class java.lang.Boolean

BasicUsageClass.fun2("hi there")
// class java.lang.String

BasicUsageClass.fun2(new Number(23));
// class jdk.nashorn.internal.objects.NativeNumber

BasicUsageClass.fun2(new Date());
// class jdk.nashorn.internal.objects.NativeDate

BasicUsageClass.fun2(new RegExp());
// class jdk.nashorn.internal.objects.NativeRegExp

BasicUsageClass.fun2({foo: 'bar'});
// class jdk.nashorn.internal.scripts.JO4
//! does NOT work...throws ClassCastException
//BasicUsageClass.fun3({
//    foo: 'bar',
//    bar: 'foo'
//});
// Object: [foo, bar]

