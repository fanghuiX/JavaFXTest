

function UndoBlock()
{
	
}

UndoBlock.prototype.addUndoAnimation = function(animationList)
{
	return false;
}

UndoBlock.prototype.undoInitialStep = function(world) 
{
	
}

////////////////////////////////////////////////////////////
// UndoMove
////////////////////////////////////////////////////////////

function UndoMove(id, fmX, fmy, tx, ty)
{
	this.objectID = id;
	this.fromX = fmX;
	this.fromY = fmy;
	this.toX = tx;
	this.toY = ty;
}


UndoMove.prototype = new UndoBlock();
UndoMove.prototype.constructor = UndoMove;

UndoMove.prototype.addUndoAnimation = function (animationList)
{
	var nextAnim = new SingleAnimation(this.objectID, this.fromX, this.fromY, this.toX, this.toY);
	animationList.push(nextAnim);
	return true;
}

////////////////////////////////////////////////////////////
// UndoCreate
////////////////////////////////////////////////////////////

function UndoCreate(id)
{
	this.objectID = id;
}

UndoCreate.prototype = new UndoBlock();
UndoCreate.prototype.constructor = UndoCreate;

	
UndoCreate.prototype.undoInitialStep = function(world)
{
			world.removeObject(this.objectID);
}

////////////////////////////////////////////////////////////
// UndoHighlight
////////////////////////////////////////////////////////////

function UndoHighlight(id, val)
{
	this.objectID = id;
	this.highlightValue = val;
}

UndoHighlight.prototype = new UndoBlock();
UndoHighlight.prototype.constructor = UndoHighlight;

UndoHighlight.prototype.undoInitialStep = function(world)
{
	world.setHighlight(this.objectID, this.highlightValue);
}


////////////////////////////////////////////////////////////
// UndoSetHeight
////////////////////////////////////////////////////////////

function UndoSetHeight(id, val)
{
	this.objectID = id;
	this.height = val;
}

UndoSetHeight.prototype = new UndoBlock();
UndoSetHeight.prototype.constructor = UndoSetHeight;

UndoSetHeight.prototype.undoInitialStep = function(world)
{
	world.setHeight(this.objectID, this.height);
}

////////////////////////////////////////////////////////////
// UndoSetWidth
////////////////////////////////////////////////////////////

function UndoSetWidth(id, val)
{
	this.objectID = id;
	this.width = val;
}

UndoSetWidth.prototype = new UndoBlock();
UndoSetWidth.prototype.constructor = UndoSetWidth;

UndoSetWidth.prototype.undoInitialStep = function(world)
{
	world.setWidth(this.objectID, this.width);
}


////////////////////////////////////////////////////////////
// UndoSetNumElements
////////////////////////////////////////////////////////////
function UndoSetNumElements(obj, newNumElems)
{
	this.objectID = obj.objectID;
	this.sizeBeforeChange = obj.getNumElements();
	this.sizeAfterChange = newNumElems;
	if (this.sizeBeforeChange > this.sizeAfterChange)
	{
		this.labels = new Array(this.sizeBeforeChange - this.sizeAfterChange);
		this.colors = new Array(this.sizeBeforeChange - this.sizeAfterChange);
		for (var i = 0; i < this.sizeBeforeChange - this.sizeAfterChange; i++)
		{
			this.labels[i] = obj.getText(i+this.sizeAfterChange);
			this.colors[i] = obj.getTextColor(i+this.sizeAfterChange);
		}
		
	}	
}

UndoSetNumElements.prototype = new UndoBlock();
UndoSetNumElements.prototype.constructor = UndoSetNumElements;


UndoSetNumElements.prototype.undoInitialStep = function(world)
{
	world.setNumElements(this.objectID, this.sizeBeforeChange);
	if (this.sizeBeforeChange > this.sizeAfterChange)
	{
		for (var i = 0; i < this.sizeBeforeChange - this.sizeAfterChange; i++)
		{
			world.setText(this.objectID, this.labels[i], i+this.sizeAfterChange);
			world.setTextColor(this.objectID, this.colors[i], i+this.sizeAfterChange);
		}
	}
}


////////////////////////////////////////////////////////////
// UndoSetAlpha
////////////////////////////////////////////////////////////

function UndoSetAlpha(id, alph)
{
	this.objectID = id;
	this.alphaVal = alph;
}

UndoSetAlpha.prototype = new UndoBlock();
UndoSetAlpha.prototype.constructor = UndoSetAlpha;

UndoSetAlpha.prototype.undoInitialStep = function(world) 
{
	world.setAlpha(this.objectID, this.alphaVal);
}

////////////////////////////////////////////////////////////
// UndoSetNull
////////////////////////////////////////////////////////////

function UndoSetNull(id, nv)
{
	this.objectID = id;
	this.nullVal = nv;
}

UndoSetNull.prototype = new UndoBlock();
UndoSetNull.prototype.constructor = UndoSetNull;

UndoSetNull.prototype.undoInitialStep = function(world) 
{
	world.setNull(this.objectID, this.nullVal);
}

////////////////////////////////////////////////////////////
// UndoSetForegroundColor
////////////////////////////////////////////////////////////

function UndoSetForegroundColor(id, color)
{
	this.objectID = id;
	this.color = color;
}

UndoSetForegroundColor.prototype = new UndoBlock();
UndoSetForegroundColor.prototype.constructor = UndoSetForegroundColor;

UndoSetForegroundColor.prototype.undoInitialStep =  function (world)
{
	world.setForegroundColor(this.objectID, this.color);
}

////////////////////////////////////////////////////////////
// UndoSetBackgroundColor
////////////////////////////////////////////////////////////

function UndoSetBackgroundColor(id, color)
{
	this.objectID = id;
	this.color = color;
}

UndoSetBackgroundColor.prototype = new UndoBlock();
UndoSetBackgroundColor.prototype.constructor = UndoSetBackgroundColor;

UndoSetBackgroundColor.prototype.undoInitialStep =  function (world)
{
	world.setBackgroundColor(this.objectID, this.color);
}



////////////////////////////////////////////////////////////
// UndoSetHighlightIndex
////////////////////////////////////////////////////////////

function UndoSetHighlightIndex(id, index)
{
	this.objectID = id;
	this.index = index;
}

UndoSetHighlightIndex.prototype = new UndoBlock();
UndoSetHighlightIndex.prototype.constructor = UndoSetHighlightIndex;

UndoSetHighlightIndex.prototype.undoInitialStep =  function (world)
{
	world.setHighlightIndex(this.objectID, this.index);
}



////////////////////////////////////////////////////////////
// UndoSetText
////////////////////////////////////////////////////////////



function UndoSetText(id, str, index)
{
	this.objectID = id;
	this.newText = str;
	this.labelIndex = index;
}

UndoSetText.prototype = new UndoBlock();
UndoSetText.prototype.constructor = UndoSetText;

UndoSetText.prototype.undoInitialStep = function(world)
{
	world.setText(this.objectID, this.newText, this.labelIndex);
}
////////////////////////////////////////////////////////////
// UndoSetTextColor
////////////////////////////////////////////////////////////



function UndoSetTextColor(id, color, index)
{
	this.objectID = id;
	this.color = color;
	this.index = index;
}

UndoSetTextColor.prototype = new UndoBlock();
UndoSetTextColor.prototype.constructor = UndoSetTextColor;

UndoSetTextColor.prototype.undoInitialStep = function(world)
{
	world.setTextColor(this.objectID, this.color, this.index);
}



////////////////////////////////////////////////////////////
// UndoHighlightEdge
////////////////////////////////////////////////////////////

function UndoHighlightEdge(from, to, val)
{
	this.fromID = from;
	this.toID = to;
	this.highlightValue = val;
}

UndoHighlightEdge.prototype = new UndoBlock();
UndoHighlightEdge.prototype.constructor = UndoHighlightEdge;

UndoHighlightEdge.prototype.undoInitialStep = function(world)
{
	world.setEdgeHighlight(this.fromID, this.toID, this.highlightValue);
}


////////////////////////////////////////////////////////////
// UndoSetEdgeColor
////////////////////////////////////////////////////////////

function UndoSetEdgeColor(from, to, oldColor)
{
	this.fromID = from;
	this.toID = to;
	this.color = oldColor;
}

UndoSetEdgeColor.prototype = new UndoBlock();
UndoSetEdgeColor.prototype.constructor = UndoSetEdgeColor;

UndoSetEdgeColor.prototype.undoInitialStep = function(world)
{
	world.setEdgeColor(this.fromID, this.toID, this.color);
}


////////////////////////////////////////////////////////////
// UndoSetEdgeAlpha
////////////////////////////////////////////////////////////

function UndoSetEdgeAlpha(from, to, oldAplha)
{
	this.fromID = from;
	this.toID = to;
	this.alpha  = oldAplha;
}

UndoSetEdgeAlpha.prototype = new UndoBlock();
UndoSetEdgeAlpha.prototype.constructor = UndoSetEdgeAlpha;

UndoSetEdgeAlpha.prototype.undoInitialStep = function(world)
{
	world.setEdgeAlpha(this.fromID, this.toID, this.alpha);
}

////////////////////////////////////////////////////////////
// UndoSetPosition
////////////////////////////////////////////////////////////

function UndoSetPosition(id, x, y)
{
	this.objectID = id;
	this.x = x; 
	this.y = y;
}

UndoSetPosition.prototype = new UndoBlock();
UndoSetPosition.prototype.constructor = UndoSetPosition;


UndoSetPosition.prototype.undoInitialStep = function(world)
{
	world.setNodePosition(this.objectID, this.x, this.y);
}


