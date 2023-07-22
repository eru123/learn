// Huffman coding, Encoding and Decoding, File compression and decompression.
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <queue>
#include <map>
#include <algorithm>
#include <iterator>

using namespace std;

// Node class for Huffman tree
class Node {
public:
    char ch;
    int freq;
    Node *left, *right;
    Node(char ch, int freq, Node *left = NULL, Node *right = NULL) {
        this->ch = ch;
        this->freq = freq;
        this->left = left;
        this->right = right;
    }
};

// Compare two nodes
struct compare {
    bool operator()(Node *l, Node *r) {
        return (l->freq > r->freq);
    }
};

// Traverse the Huffman Tree and store Huffman Codes in a map.
void preencode(Node *root, string str, map<char, string> &huffmanCode) {
    if (root == NULL)
        return;
    if (!root->left && !root->right)
        huffmanCode[root->ch] = str;
    preencode(root->left, str + "0", huffmanCode);
    preencode(root->right, str + "1", huffmanCode);
}

// Traverse the Huffman Tree and decode the encoded string
void predecode(Node *root, int &index, string str) {
    if (root == NULL)
        return;
    if (!root->left && !root->right) {
        // cout << root->ch;
        return;
    }
    index++;
    if (str[index] == '0')
        predecode(root->left, index, str);
    else
        predecode(root->right, index, str);
}

string encode(string text) {
    // count frequency of appearance of each character
    // and store it in a map
    map<char, int> freq;
    for (char ch : text)
        freq[ch]++;

    // Create a priority queue to store live nodes of Huffman tree
    priority_queue<Node *, vector<Node *>, compare> pq;

    // Create a leaf node for each character and add it
    // to the priority queue.
    for (auto pair : freq)
        pq.push(new Node(pair.first, pair.second));

    // do till there is more than one node in the queue
    while (pq.size() != 1) {
        // Remove the two nodes of highest priority
        // (lowest frequency) from the queue
        Node *left = pq.top();
        pq.pop();
        Node *right = pq.top();
        pq.pop();

        // Create a new internal node with these two nodes as children and
        // with frequency equal to the sum of the two nodes' frequencies.
        // Add the new node to the priority queue.
        int sum = left->freq + right->freq;
        pq.push(new Node('\0', sum, left, right));
    }

    // root stores pointer to root of Huffman Tree
    Node *root = pq.top();

    // Traverse the Huffman Tree and store Huffman Codes
    // in a map. Also, print them
    map<char, string> huffmanCode;
    preencode(root, "", huffmanCode);
    // cout << "Huffman Codes are: " << endl;
    // cout << "------------------" << endl;
    // for (auto pair : huffmanCode)
    //     cout << pair.first << " " << pair.second << endl;

    // cout << "------------------" << endl;

    // Print encoded string
    string encoded = "";
    for (char ch : text)
        encoded += huffmanCode[ch];
    // cout << "Encoded string is: " << str << endl;
    // return str;

    // include tree in encoded string for decoding
    // string tree = "";
    // for (auto pair : huffmanCode) {
    //     tree += pair.first;
    //     tree += pair.second;
    // }

    // // separate tree from encoded string by using a special character
    // encoded += "$";
    // encoded += tree;

    return encoded;

    // Traverse the Huffman Tree again and this time,
    // decode the encoded string
    // int index = -1;
    // cout << "Decoded string is: ";
    // while (index < (int)str.size() - 2)
    //     decode(root, index, str);
}

// string decode(string text) {
//     // separate tree from encoded string by using a special character
//     int pos = text.find("$");

//     // split into two parts
//     // tree$encoded
//     string encoded = text.substr(0, pos);
//     string tree = text.substr(pos + 1);

//     // build tree from tree string
//     map<char, string> huffmanCode;
//     for (int i = 0; i < (int)tree.size(); i += 2) {
//         char ch = tree[i];
//         string code = tree.substr(i + 1, 1);
//         huffmanCode[ch] = code;
//     }

//     // traverse the tree and decode the encoded string
//     // string decoded = "";
//     // string code = "";
//     // for (char ch : encoded) {
//     //     code += ch;
//     //     for (auto pair : huffmanCode) {
//     //         if (pair.second == code) {
//     //             decoded += pair.first;
//     //             code = "";
//     //             break;
//     //         }
//     //     }
//     // }

//     // return decoded;
// }

string decode(string encoded) {
    // build tree from tree string
    map<char, string> huffmanCode;
    for (int i = 0; i < (int)encoded.size(); i += 2) {
        char ch = encoded[i];
        string code = encoded.substr(i + 1, 1);
        huffmanCode[ch] = code;
    }

    // traverse the tree and decode the encoded string
    string decoded = "";
    string code = "";
    for (char ch : encoded) {
        code += ch;
        for (auto pair : huffmanCode) {
            if (pair.second == code) {
                decoded += pair.first;
                code = "";
                break;
            }
        }
    }

    return decoded;
}

// Driver program to test above functions
int main() {
    string text = "Huffman coding is a data compression algorithm.";
    // buildHuffmanTree(text);
    string encoded = encode(text);
    string decoded = decode(encoded);
    cout << "Original string: " << text << endl;
    cout << "Encoded string: " << encoded << endl;
    cout << "Decoded string: " << decoded << endl;
    return 0;
}