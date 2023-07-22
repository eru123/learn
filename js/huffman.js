class PriorityQueue {
    constructor() {
        this.items = [];
    }

    enqueue(item, priority) {
        let contain = false;
        for (let i = 0; i < this.items.length; i++) {
            if (this.items[i].priority > priority) {
                this.items.splice(i, 0, { item, priority });
                contain = true;
                break;
            }
        }
        if (!contain) {
            this.items.push({ item, priority });
        }
    }

    dequeue() {
        return this.items.shift().item;
    }

    size() {
        return this.items.length;
    }
}

var huffmanTree = null;

function huffmanEncode(input) {
    // Create a frequency table
    const freq = {};
    for (const char of input) {
        freq[char] = (freq[char] || 0) + 1;
    }

    // Build the Huffman tree
    const priorityQueue = new PriorityQueue();
    for (const char in freq) {
        priorityQueue.enqueue(char, freq[char]);
    }
    while (priorityQueue.size() > 1) {
        const left = priorityQueue.dequeue();
        const right = priorityQueue.dequeue();
        priorityQueue.enqueue({ left, right }, left.freq + right.freq);
    }
    huffmanTree = priorityQueue.dequeue();

    // Create codes for each character
    const codes = {};
    const createCodes = (node, path) => {
        if (typeof node === 'string') {
            codes[node] = path;
            return;
        }
        createCodes(node.left, path + '0');
        createCodes(node.right, path + '1');
    };
    createCodes(huffmanTree, '');

    // Encode the input string
    let encoded = '';
    for (const char of input) {
        encoded += codes[char];
    }

    return encoded;
}

// decode the encoded string
function huffmanDecode(encoded, huffmanTree) {
    let decoded = '';
    let current = huffmanTree;
    for (const bit of encoded) {
        if (bit === '0') {
            current = current.left;
        } else {
            current = current.right;
        }
        if (typeof current === 'string') {
            decoded += current;
            current = huffmanTree;
        }
    }
    return decoded;
}

const plain = 'The quick brown fox jumps over the lazy dog';
const encoded = huffmanEncode(plain);
const decoded = huffmanDecode(encoded, huffmanTree);

console.log('Text:', plain);
console.log('Encoded:', encoded);
console.log('Decoded:', decoded);