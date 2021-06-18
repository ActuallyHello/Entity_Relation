class MATRIX_CREATOR {
    async takeMatrix(entities, relations) {
        //console.log(entities);
        //console.log(relations);
        let flag = false;
        let matr = [];
        let index_e;
        for (let i = 0; i < entities.length; i++) {
            let e = [];
            e[0] = entities[i].name_e;
            index_e = 1;
            for (let j = 0; j < entities.length; j++) {
                //console.log(e[0] + " " + entities[j].name_e);
                if (e[0] == entities[j].name_e) {
                    e[index_e] = 0;
                    index_e++;
                }
                else {
                    flag = false;
                    for (let k = 0; k < relations.length; k++) {
                        //console.log(e[0] + " " + entities[j].name_e + " e0 eJ");
                        //console.log(relations[k].e_left + " " + relations[k].e_right + " r_left r_right");
                        if (e[0] == relations[k].e_right && entities[j].name_e == relations[k].e_left ||
                            e[0] == relations[k].e_left && entities[j].name_e == relations[k].e_right) {
                            e[index_e] = 1;
                            index_e++;
                            flag = true;
                            break;
                        }
                    }
                    //if (flag) console.log("TYTYTYTY");
                    //console.log(e);
                    if (flag == false){
                        e[index_e] = 0;
                        index_e++;
                    }
                }
            }
            matr[i] = e;
        }
        console.log(typeof matr);
        return matr;
    }
}

module.exports = new MATRIX_CREATOR();