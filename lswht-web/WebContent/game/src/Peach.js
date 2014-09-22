
(function(){

var Peach = game.Peach = function(props)
{
	props = props || {};
	this.type = props.type;
	Peach.superClass.constructor.call(this, this.type);
	this.id = props.id || Q.UIDUtil.createUID("Peach");
	
	this.reset(this.type);
};
Q.inherit(Peach, Q.MovieClip);

Peach.prototype.init = function()
{
	
};

Peach.prototype.update = function(timeInfo)
{
	this.rotation += 0.5;
};

Peach.prototype.reset = function(type)
{
	this.setType(type);
	this.currentScore = this.type.score;
	this.alpha = 1;
	this.fading = false;
	//this.bouncing = false;
	this.currentSpeedY = this.speedY;
	this.currentSpeedX = 0;
	this.delay = Math.floor(Math.random()*50);
	
	this.setRandomPosition();
}

Peach.prototype.setRandomPosition = function()
{
	var minX = 100, maxX = game.width-100, minY = -100, maxY = 0;
	this.x = Math.floor(Math.random()*(maxX-minX)+minX);
	this.y = Math.floor(Math.random()*(maxY-minY)+minY) - 50;
	//this.y = -50;
}

Peach.prototype.setType = function(type)
{
	this.type = type;
	this._frames.length = 0;
	this.addFrame(type.frames);
	this.currentFrame = 0;
}

Peach.getRandomType = function(time)
{
	
	var list = this.TypeList;
    var tmp = Math.floor(time/20);
	//var r = Math.floor(Math.random()*list.length);
    //var r = Math.floor(Math.random()*9) > tmp+2 ? 0 : 1;
	var r = Math.floor(Math.random()*100)%list.length;
	
	return list[r];
};

Peach.prototype.getCollide = function()
{
	//this.currentScore += this.type.scoreStep;
	//if(this.currentScore > this.type.maxScore) this.currentScore = this.type.maxScore;
	//this.y += 200;
   // this.x = -500;
	//this.bouncing = true;
}

Peach.prototype.stopBounce = function()
{
	//this.currentSpeedY = this.speedY;
	//this.bouncing = false;
}

Peach.init = function(height)
{
	this.Type = {};
	this.Type.bigPack1 =
	{
		image:game.getImage("peach"),
		regX: 94,
		regY: 92,
		width: 188,
		height: 184,
		score: 5,
		scoreStep: 0,
		maxScore: 3,
		speedY: height/80,
		frames:[
            {rect:[0,0,95,96]}
			]
	};
	
	this.Type.bigPack2 =
	{
		image:game.getImage("peach"),
		regX: 94,
		regY: 92,
		width: 188,
		height: 184,
		score: 5,
		scoreStep: 0,
		maxScore: 3,
		speedY: height/80,
		frames:[
            {rect:[95*1,0,95,96]}
			]
	};
	
	this.Type.bigPack3 =
	{
		image:game.getImage("peach"),
		regX: 94,
		regY: 92,
		width: 188,
		height: 184,
		score: 5,
		scoreStep: 0,
		maxScore: 3,
		speedY: height/80,
		frames:[
            {rect:[95*2,0,95,96]}
			]
	};
	
	this.Type.bigPack4 =
	{
		image:game.getImage("peach"),
		regX: 94,
		regY: 92,
		width: 188,
		height: 184,
		score: 5,
		scoreStep: 0,
		maxScore: 3,
		speedY: height/80,
		frames:[
            {rect:[95*3,0,95,96]}
			]
	};
	
	this.Type.smallPack1 =
	{
		image:game.getImage("peach"),
		regX: 94,
		regY: 92,
		width: 188,
		height: 184,
		score: 1,
		scoreStep: 0,
		maxScore: 3,
		speedY: height/80,
		frames:[
            {rect:[95*4,0,95,96]}
			]
	};
	
	this.Type.smallPack2 =
	{
		image:game.getImage("peach"),
		regX: 94,
		regY: 92,
		width: 188,
		height: 184,
		score: 1,
		scoreStep: 0,
		maxScore: 3,
		speedY: height/80,
		frames:[
            {rect:[95*5,0,95,96]}
			]
	};
	
	this.Type.smallPack3 =
	{
		image:game.getImage("peach"),
		regX: 94,
		regY: 92,
		width: 188,
		height: 184,
		score: 1,
		scoreStep: 0,
		maxScore: 3,
		speedY: height/80,
		frames:[
            {rect:[95*6,0,95,96]}
			]
	};
	
	this.Type.smallPack4 =
	{
		image:game.getImage("peach"),
		regX: 94,
		regY: 92,
		width: 188,
		height: 184,
		score: 1,
		scoreStep: 0,
		maxScore: 3,
		speedY: height/80,
		frames:[
            {rect:[95*7,0,95,96]}
			]
	};
	
	this.Type.smallPack5 =
	{
		image:game.getImage("peach"),
		regX: 94,
		regY: 92,
		width: 188,
		height: 184,
		score: 1,
		scoreStep: 0,
		maxScore: 3,
		speedY: height/80,
		frames:[
            {rect:[95*8,0,95,96]}
			]
	};
	
	this.Type.smallPack6 =
	{
		image:game.getImage("peach"),
		regX: 94,
		regY: 92,
		width: 188,
		height: 184,
		score: 1,
		scoreStep: 0,
		maxScore: 3,
		speedY: height/80,
		frames:[
            {rect:[95*9,0,95,96]}
			]
	};
	
	this.Type.smallPack7 =
	{
		image:game.getImage("peach"),
		regX: 94,
		regY: 92,
		width: 188,
		height: 184,
		score: 1,
		scoreStep: 0,
		maxScore: 3,
		speedY: height/80,
		frames:[
            {rect:[95*10,0,95,96]}
			]
	};
	
	this.Type.smallPack8 =
	{
		image:game.getImage("peach"),
		regX: 94,
		regY: 92,
		width: 188,
		height: 184,
		score: 1,
		scoreStep: 0,
		maxScore: 3,
		speedY: height/80,
		frames:[
            {rect:[95*11,0,95,96]}
			]
	};
	
	this.Type.smallPack9 =
	{
		image:game.getImage("peach"),
		regX: 94,
		regY: 92,
		width: 188,
		height: 184,
		score: 1,
		scoreStep: 0,
		maxScore: 3,
		speedY: height/80,
		frames:[
            {rect:[95*12,0,95,96]}
			]
	};
	
	this.Type.smallPack10 =
	{
		image:game.getImage("peach"),
		regX: 94,
		regY: 92,
		width: 188,
		height: 184,
		score: 1,
		scoreStep: 0,
		maxScore: 3,
		speedY: height/80,
		frames:[
            {rect:[95*13,0,95,96]}
			]
	};
	
	this.Type.smallPack11 =
	{
		image:game.getImage("peach"),
		regX: 94,
		regY: 92,
		width: 188,
		height: 184,
		score: 1,
		scoreStep: 0,
		maxScore: 3,
		speedY: height/80,
		frames:[
            {rect:[95*14,0,95,96]}
			]
	};
	
	this.Type.smallPack12 =
	{
		image:game.getImage("peach"),
		regX: 94,
		regY: 92,
		width: 188,
		height: 184,
		score: 1,
		scoreStep: 0,
		maxScore: 3,
		speedY: height/80,
		frames:[
            {rect:[95*15,0,95,96]}
			]
	};
	
	this.Type.bomb =
	{
		image:game.getImage("peach"),
		regX: 94,
		regY: 92,
		width: 188,
		height: 184,
		score: -2,
		scoreStep: 0,
		maxScore: 5,
		speedY:  height/60,
		frames:[
            {rect:[95*16,0,95,96]}
			]
	};


	this.TypeList = [ 
		this.Type.smallPack1,
		this.Type.smallPack2,
		this.Type.smallPack3,
		this.Type.smallPack4,
		this.Type.smallPack5,
		this.Type.smallPack6,
		this.Type.smallPack7,
		this.Type.smallPack8,
		this.Type.smallPack9,
		this.Type.smallPack10,
		this.Type.smallPack11,
		this.Type.smallPack12,
		this.Type.bigPack1,
		this.Type.bigPack2,
		this.Type.bigPack3,
		this.Type.bigPack4, 
		this.Type.bomb];
};

})();