

function blockRect(r1,r2){
	//r1 -> bloqueado
	//r2 -> parede
	//armazenam a distância entre os retângulos
	let posicaoX = r1.centerX() - r2.centerX();
	let posicaoY = r1.centerY() - r2.centerY();
	//soma das metades
	let somaMetadeWidth = r1.halfWidth() + r2.halfWidth();
	let somaMetadeHeight = r1.halfHeight() + r2.halfHeight();
	
	if(Math.abs(posicaoX) < somaMetadeWidth && Math.abs(posicaoY) < somaMetadeHeight){
		
		let overlapX = somaMetadeWidth - Math.abs(posicaoX);
		let overlapY = somaMetadeHeight - Math.abs(posicaoY);
		
		if(overlapX >= overlapY){//colisão por cima ou por baixo
			if(posicaoY > 0){//por cima
				r1.posY += overlapY;
				r1.vida -= Math.floor(Math.random() * 20)+1;
				r2.vida -= Math.floor(Math.random() * 20)+1;
				
				

			} else {
				r1.posY -= overlapY;
				r1.vida -= Math.floor(Math.random() * 20)+1;
				r2.vida -= Math.floor(Math.random() * 20)+1;
		          
					
			}
		} else {//colisão pela esquerda ou direita
			if(posicaoX > 0){//colisão pela esquerda
				r1.posX += overlapX;
				
				r1.vida -= Math.floor(Math.random() * 20)+1;
				r2.vida -= Math.floor(Math.random() * 20)+1;
				
					
				} else {
					r1.posX -= overlapX;
					
					r1.vida -= Math.floor(Math.random() * 20)+1;
				    r2.vida -= Math.floor(Math.random() * 20)+1;
					
				
			}
		}
	}
}
function blockRectWalls(r1,r2){
	
	let posicaoX = r1.centerX() - r2.centerX();
	let posicaoY = r1.centerY() - r2.centerY();
	let somaMetadeWidth = r1.halfWidth() + r2.halfWidth();
	let somaMetadeHeight = r1.halfHeight() + r2.halfHeight();
	
	if(Math.abs(posicaoX) < somaMetadeWidth && Math.abs(posicaoY) < somaMetadeHeight){
		
		let overlapX = somaMetadeWidth - Math.abs(posicaoX);
		let overlapY = somaMetadeHeight - Math.abs(posicaoY);
		
		if(overlapX >= overlapY){
			if(posicaoY > 0){
				r1.posY += overlapY;

			} else {
				r1.posY -= overlapY;
		
			}
		} else {
			if(posicaoX > 0){
				r1.posX += overlapX;
				} else {
					r1.posX -= overlapX;
	
			}
		}
	}
}