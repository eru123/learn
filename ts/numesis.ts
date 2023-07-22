class Numesis {
    
	public readonly c: {s:string,l:number,i:number,a: Array<string>};
    
    /**
     * @param {String} ch    A non-duplicate character set, that will be use in creating new number system
     */
	constructor(ch:string = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"){
		this.c = {
			s: ch,
			l: ch.length,
			i: ch.length - 1,
			a: ch.split("")
		}
	}
                        
    /**
     * Description. ep stands for Encoding Process, a recursive method that encodes the n variable to custom number system
     *
     * @param {number} n    The number that will be decoded
     * @param {string} c    The current string in the recursion
     *
     * @return {String} encoded string
     */   
	private ep(n:number, c = ""): string {
		n = Math.floor(n)
		const {l,i,a} = this.c
		if(n <= i) return a[n] + c;
		const m: number = n % l;
		c = m > 0 && m <= l ? a[m] + c : a[0] + c
		const d: number = Math.floor(n / l);
		return this.ep(d,c)
	}
                        
    /**
     * Description. e stands for Encode, a public method that encodes n paramenter to custom number system
     *
     * @param {number} n    The number that will be decoded
     *
     * @return {String} encoded string
     */  
	e(n:number): string {
		const str = String(n)
		if(str.includes(".")) {
			const st = str.split(".")
			return `${this.ep(Number(st[0]) || 0)}.${this.ep(Number(st[1]) || 0)}`
		}
		return this.ep(n)
	}
}

export default Numesis;