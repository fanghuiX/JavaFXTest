


Function.prototype.bind = function() {
	var _function = this;
	
	var args = Array.prototype.slice.call(arguments);
	var scope = args.shift()
	return function() {
		for (var i = 0; i < arguments.length; i++)
		{
			args.push(arguments[i]);
		}
		return _function.apply(scope, args);
	}
}

function EventListener()
{
	this.events = [];
}


EventListener.prototype.removeListener = function(kind, scope, func)
{
	if (this.events[kind] == undefined)
	{
		return;
	}
	var scopeFunctions = null;
	var i;
	for (i = 0; i < this.events[kind].length; i++)
	{
		if (this.events[kind][i].scope == scope)
		{
			scopeFunctions = this.events[kind][i];
			break;
		}	
	}
	if (scopeFunctions == null)
	{
		return;
	}
	for (i = 0; i < scopeFunctions.functions.length; i++)
	{
		if (scopeFunctions.functions[i] == func)
		{
			scopeFunctions.functions.splice(i,1);
			return;
		}
	}
}


EventListener.prototype.addListener = function(kind, scope, func)
{
	if (this.events[kind] === undefined)
	{
		this.events[kind] = [];
	}
	var i;
	var scopeFunctions = null;
	for (i = 0; i < this.events[kind].length; i++)
	{
		if (this.events[kind][i].scope == scope)
		{
			scopeFunctions = this.events[kind][i];
			break;
		}
	}
	if (scopeFunctions === null)
	{
		this.events[kind].push({scope:scope, functions:[] });
		scopeFunctions = this.events[kind][this.events[kind].length - 1];
	}
	for (i = 0; i < scopeFunctions.functions.length; i++)
	{
		if (scopeFunctions.functions[i] == func)
		{
			return;
		}
	}
	scopeFunctions.functions.push(func);
}

EventListener.prototype.fireEvent = function(kind, event)
{
	// TODO:  Should add a deep clone here ...
	if (this.events[kind] !== undefined)
	{
		for (var i = 0; i < this.events[kind].length; i++)
		{
			var objects = this.events[kind][i];
			var functs = objects.functions;
			var scope = objects.scope
			for (var j = 0; j <functs.length; j++)
			{
				var func = functs[j];
				func.call(scope,event);
			}
		}
	}

}


/*
function Source()
{
	
}

Source.prototype = new EventListener();
Source.prototype.constructor = Source;
Source.prototype.testFire = function()
{
	this.fireEvent("test","testcontents");
	this.fireEvent("test2","test2contents");
}



function Client(eventSource)
{
		
	this.first = function(blah)
	{
		alert("first:" + blah);
	}
	
	this.second = function(blah)
	{
		alert("second:" + blah);
	}
	eventSource.addListener("test", this, this.first);
	eventSource.addListener("test", this, this.first);
	eventSource.addListener("test", this, this.second);
	eventSource.removeListener("test", this, this.first);
	
							
}
							
							
function init()
{
	var src = new Source;
	var c = new Client(src);
	src.testFire();
}
							
*/

