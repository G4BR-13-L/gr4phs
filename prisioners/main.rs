use rand::Rng;

fn main() {
    let mut rng = rand::thread_rng();
    let mut boxes: [i16; 100] = [-1; 100];
    
    /*for n in 0..boxes.len(){
        let mut random = rng.gen_range(0, 100);
        for i in 0..n{
            if boxes[i] == random{
                random = rng.gen_range(0, 100);
            }
        }
        boxes[n] = random;
        print!("{}, ", boxes[n]);
    }
    
    for i in 0..boxes.len() {
        for j in 0..boxes.len(){
            if boxes[i] > boxes[j] {
                let aux = boxes[i];
                boxes[i] = boxes[j];
                boxes[j] = aux;
            }
        }
    }
    println!("\n");*/
    
    for n in 0..boxes.len() {
        boxes[n] = n as i16;
        print!("{}, ", boxes[n]);
    }
    let prisioners = boxes;

    for i in 0..boxes.len() {
        let j = rng.gen_range(0, 100);
        let _aux = boxes[j];
        boxes[j] = boxes[i];
        boxes[i] = boxes[j];
    }

    println!("\n");
    println!("\n");

    for n in 0..boxes.len() {
        print!("{}, ", boxes[n]);
    }

    for p in 0..prisioners.len() as usize{
        let mut next_box: usize = prisioners[p] as usize;
        let mut number_found = false;
        for i in 0..50 {
            if boxes[next_box] == prisioners[p]{
                println!("Prisioneiro: {} - SALVO - {} ITERAÇÕES", prisioners[p], i);
                number_found = true;
            }else{
                next_box = boxes[next_box] as usize;
            }
        }
        if number_found == false { 
            println!("Prisioneiro: {} - MORTOS", prisioners[p]);

        }
    }


}
