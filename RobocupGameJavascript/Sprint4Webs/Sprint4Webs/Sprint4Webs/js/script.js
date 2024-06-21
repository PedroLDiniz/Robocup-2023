(function(){
	//variáveis
	let cnv = document.querySelector("#meuCanvas");
	let ctx = cnv.getContext("2d");
	let VidaPlayer1 = document.getElementById('PlayerVida1');
	let VidaPlayer2 = document.getElementById('PlayerVida2');
	let Ganhador = document.getElementById('Ganhador');
	
	let EndGame = true;
	//Movimentos
	let mvLeft = mvUp = mvRight = mvDown = false;
	
	let plLeft = plUp = plRight = plDown = false;
	//Arrays
	let sprites = [];
	let blocks = [];
	
	
	//Objetos instanciados com os seguintes parâmetros: posX, posY, Largura, Altura e cor
	let player1 = new Sprite(50, 700, 50, 50, "#aaaaaa","img/robozozin.png",100);
	sprites.push(player1);
	
	
	let player2 = new Sprite(1350, 200, 50, 50, "#aaaaaa","img/png-clipart-robot-robot.png",100);
	sprites.push(player2);
	
	
	let block1 = new Sprite(90, 70, 200, 150 , "grey","",0);
	sprites.push(block1);
	blocks.push(block1);

	let block2 = new Sprite(700, 90, 100, 300, "#grey","",0);
	sprites.push(block2);
	blocks.push(block2);

	let block3 = new Sprite(550, 600, 500, 100, "#grey","",0);
	sprites.push(block3);
	blocks.push(block3);

	let block4 = new Sprite(250, 300, 200, 120, "#grey","",0);
	sprites.push(block4);
	blocks.push(block4);

	let block5 = new Sprite(1200, 200, 150, 120, "grey","",0);
	sprites.push(block5);
	blocks.push(block5);
	
	window.addEventListener('keydown', function (e) {
		const nomeKey = e.key;
		switch (nomeKey) {
		  case 'ArrowLeft':
			mvLeft = true;
			break;
		  case 'ArrowUp':
			mvUp = true;
			break;
		  case 'ArrowRight':
			mvRight = true;
			break;
		  case 'ArrowDown':
			mvDown = true;
			break;
		  case 'a':
			plLeft = true;
			break;
		  case 'w':
			plUp = true;
			break;
		  case 'd':
			plRight = true;
			break;
		  case 's':
			plDown = true;
			break;
		}
	  });
	
	  // Soltar as teclas
	  window.addEventListener('keyup', function (e) {
		const nomeKey = e.key;
		switch (nomeKey) {
		  case 'ArrowLeft':
			mvLeft = false;
			break;
		  case 'ArrowUp':
			mvUp = false;
			break;
		  case 'ArrowRight':
			mvRight = false;
			break;
		  case 'ArrowDown':
			mvDown = false;
			break;
		  case 'a':
			plLeft = false;
			break;
		  case 'w':
			plUp = false;
			break;
		  case 'd':
			plRight = false;
			break;
		  case 's':
			plDown = false;
			break;
		}
	  });


	//funções
	function loop(){
 if(EndGame === true){
		window.requestAnimationFrame(loop,cnv);
		update();
		update2();
		render();
 }
	}
	player1.velocidade = 6;

	//Atualizações
	function update(){
		if(mvLeft && !mvRight){
			player1.posX -=player1.velocidade;
		}
		if(mvRight && !mvLeft){
			player1.posX +=player1.velocidade;
		}
		if(mvUp && !mvDown){
			player1.posY -=player1.velocidade;
		}
		if(mvDown && !mvUp){
			player1.posY +=player1.velocidade;
		}
		//Limites da tela
		player1.posX = Math.max(0, Math.min(cnv.width - player1.width, player1.posX));
		player1.posY = Math.max(0, Math.min(cnv.height - player1.height, player1.posY));
		
		//Colisões
		for(let i in blocks){
			let blk = blocks[i];
			if(blk.visible){
				blockRectWalls(player1,blk);
				
			}
			if(blk.visible){
				blockRect(player2,player1);
				
			}
			if(player2.vida <= 0 && player1.vida > 0){
				player2.width = 0;
				player2.height = 0;
				player2.vida = 0;
				player2.visible = false;
				EndGame = false;
				Ganhador.innerHTML = `<h1>Robo 1 Ganhou!</h1>`;
			}
			if(player2.vida < 0 && player1.vida < 0){
				Ganhador.innerHTML = `<h1>Empate dos Robos !</h1>`;
				player1.vida = 0;
				player2.vida = 0;
				player1.visible = false;
				player2.visible = false;
				EndGame = false;
			}
			VidaPlayer2.innerHTML = `<h1>Robo 2 </h1><h1>Vida:${player2.vida}</h1>`;
			VidaPlayer1.innerHTML = `<h1>Robo 1  </h1><h1>Vida:${player1.vida}</h1>`;	
		}
	}
	player2.velocidade = 6;
	//Player 2 
	function update2(){
		if(plLeft && !plRight){
			player2.posX -=player2.velocidade = 6;
		}
		if(plRight && !plLeft){
			player2.posX +=player2.velocidade = 6;
		}
		if(plUp && !plDown){
			player2.posY -=player2.velocidade = 6;
		}
		if(plDown && !plUp){
			player2.posY +=player2.velocidade = 6;
		}
		//Limites da tela
		player2.posX = Math.max(0, Math.min(cnv.width - player2.width, player2.posX));
		player2.posY = Math.max(0, Math.min(cnv.height - player2.height, player2.posY));
		
		//Colisões
		for(let i in blocks){
			var blk = blocks[i];
			if(blk.visible){
		
				blockRectWalls(player2,blk);
	
				}								
			}
			if(blk.visible){

				blockRect(player1,player2);				
		}			
		if(player1.vida <= 0 && player2.vida > 0){
			player1.width = 0;
			player1.height = 0;
			player1.vida = 0;
            player1.visible = false;
			EndGame = false;
			Ganhador.innerHTML = `<h1>Robo 2 Ganhou!</h1>`;	
		}
		if(player2.vida < 0 && player1.vida < 0){
			Ganhador.innerHTML = `<h1>Empate dos Robos!</h1>`;
			player1.vida = 0;
			player2.vida = 0;
			player1.visible = false;
			player2.visible = false;
			EndGame = false;
		}
		VidaPlayer1.innerHTML = `<h1>Robo 1 </h1><h1>Vida:${player1.vida}</h1>`;
		VidaPlayer2.innerHTML = `<h1>Robo 2 </h1><h1>Vida:${player2.vida}</h1>`;		
	}

	//Renderização ou desenho na tela
	function render(){
		ctx.clearRect(0,0,cnv.width,cnv.height);
		for(let i in sprites){
			let spr = sprites[i];
			if(spr.visible){
				const img = new Image();
				ctx.fillStyle = spr.color;
				img.src = spr.Imagem;
				ctx.fillRect(spr.posX, spr.posY, spr.width, spr.height);
				ctx.drawImage(img,spr.posX, spr.posY, spr.width, spr.height);
			}
		}		
	}
		loop();
	
}());
