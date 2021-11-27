#include <iostream>
#include "Data.h"
#include <queue>
#include <stack>
#include <time.h>
#include <limits>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <iomanip>
#include <cstdlib>

#define VIDEOS_FILE "VIDEO.txt"
#define CUSTOMERS_FILE "CUSTOMER.txt"
#define CUSTOMER_RENT_FILE "CUSTOMER-RENT.txt"
#define DATA_DELIMITER "|"
#define ID_FILE "ID.txt"

using namespace std;
using namespace ns;

// Constructor
MovieStore::MovieStore()
{
    videos = NULL;
    IDSystem = NULL; 
}

// Desctructor
MovieStore::~MovieStore()
{
    // delete linked list
    while (videos != NULL)
    {
        Videos *temp = videos;
        videos = videos->next;
        delete temp;
    }
}

// split string with delimiter for parsing text files
vector<string> MovieStore::explode(string s, string delim) {
    vector<string> result;
    size_t pos = 0;
    string token;
    while ((pos = s.find(delim)) != string::npos) {
        token = s.substr(0, pos);
        result.push_back(token);
        s.erase(0, pos + delim.length());
    }
    result.push_back(s);
    return result;
}

// Get an integer input with message and display error message when fails
int MovieStore::getInt(string msg)
{   
    int num;
    
    while (true) 
    {   
        cout << msg;
        if (cin.peek() == '\n') { 
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Invalid input. Please enter a valid integer." << endl;
        } else {
            cin >> num;
            if(cin.fail())
            {
                cin.clear();
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                cout << "Invalid input. Please enter a valid integer." << endl;
            } else {
                break;
            }
        }
    }

    cin.clear();
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    return num;   
}

// Get an integer input with message and display error message when fails
// returns default value if the input is empty
int MovieStore::getIntDefault(string msg, int def){
    int num;
	while(true){
        cout << msg << " (" << def << "): ";
        if (cin.peek() == '\n') { 
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            return def;
        } else {
            cin >> num;
            if (cin.fail()){
                cin.clear();
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                cout << "Invalid input. Please enter a valid integer." << endl;
            } else {
                break;
            }
        }
    }

    cin.clear();
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    return num;
}

// Get a string input with message and display error message when empty
string MovieStore::getString(string msg = "")
{   
    string input;
    cout << msg;
    getline(cin, input);
    while (input.empty())
    {
        cout << "Invalid input. Please enter a valid string." << endl;
        cout << msg;
        getline(cin, input);
    }
    return input;
}

// add a new video to the videos linked list
bool MovieStore::addVideo() 
{
    try {
        Videos *newVideo = new Videos();

        IDSystem->video_id++;
        newVideo->id = IDSystem->video_id;

        // get movie title
        newVideo->title = getString("Enter movie title: ");

        // get movie genre
        newVideo->genre = getString("Enter movie genre: ");

        // get movie production
        newVideo->production = getString("Enter movie production: ");

        // get movie copies
        newVideo->copies = getInt("Enter movie copies: ");

        // if copy is greater than 0 then video is availble
        if (newVideo->copies > 0)
        {
            newVideo->available = "Available";
        }
        else
        {
            newVideo->available = "Unavailable";
        }

        // get movie image filename
        newVideo->filename = getString("Enter movie image filename: ");
        ifstream file(newVideo->filename.c_str());
        if (!file)
        {
            cout << "File does not exist." << endl;
            cout << "Failed to add video" << endl;
            return false;
        }

        // add video to linked list
        if (videos == NULL)
        {
            videos = newVideo;
        }
        else
        {
            Videos *temp = videos;
            while (temp->next != NULL)
            {
                temp = temp->next;
            }
            temp->next = newVideo;
        }
        cout << "Video added successfully." << endl;
        return true;
    }
    catch (exception e)
    {   
        cout << "Failed to add video" << endl;
        return false;
    }
}

// display video information
void MovieStore::readVideo(bool availability){
    int id = getInt("Enter video id: ");
    try {
        Videos *temp = videos;
        while (temp != NULL)
        {
            if (temp->id == id)
            {   
                cout << "+----------------------+--------------------------------+" << endl;
                cout << "| " << setw(20) << "Video ID" << " | " << setw(30) << temp->id << " |" << endl; 
                cout << "+----------------------+--------------------------------+" << endl;
                cout << "| " << setw(20) << "Movie Title" << " | " << setw(30) << temp->title << " |" << endl; 
                cout << "+----------------------+--------------------------------+" << endl;
                cout << "| " << setw(20) << "Genre" << " | " << setw(30) << temp->genre << " |" << endl; 
                cout << "+----------------------+--------------------------------+" << endl;
                cout << "| " << setw(20) << "Production" << " | " << setw(30) << temp->production << " |" << endl; 
                cout << "+----------------------+--------------------------------+" << endl;
                cout << "| " << setw(20) << "Number of Copies" << " | " << setw(30) << temp->copies << " |" << endl; 
                if(availability) cout << "+----------------------+--------------------------------+" << endl;
                if(availability) cout << "| " << setw(20) << "Availability" << " | " << setw(30) << temp->available << " |" << endl; 
                cout << "+----------------------+--------------------------------+" << endl;
                string word = "\"" + temp->filename + "\"";
                // string word = "rundll32 \"%ProgramFiles%\\Windows Photo Viewer\\PhotoViewer.dll\", ImageView_Fullscreen " + temp->filename; // full screen
                if(!availability) system(word.c_str());
                return;
            }
            temp = temp->next;
        }
        cout << "Video not found." << endl;
    } catch (exception e)
    {
        cout << "Unable to read video." << endl;
    }
}

// display all videos in a table from the linked list
void MovieStore::readVideos()
{
    try {
        if (videos == NULL)
        {
            cout << "No videos to display." << endl;
            return;
        }
        else
        {   
            cout << "+----------------------+--------------------------------+----------------------+----------------------+" << endl;
            cout << "| " << setw(20) << "Video ID" << " | " << setw(30) << "Movie Title" << " | " << setw(20) << "Genre" << " | " << setw(20) << "Production" << " |"<< endl;
            cout << "+----------------------+--------------------------------+----------------------+----------------------+" << endl;
            Videos *temp = videos;
            while (temp != NULL)
            {
                cout << "| " << setw(20) << temp->id << " | " << setw(30) << temp->title << " | " << setw(20) << temp->genre << " | " << setw(20) << temp->production << " |" << endl;
                temp = temp->next;
            }
            cout << "+----------------------+--------------------------------+----------------------+----------------------+" << endl;
        }
    } catch (exception e)
    {
        cout << "Unable to display videos." << endl;
    }
}

// create a new customer
bool MovieStore::addCustomer(){
    try {
        IDSystem->customer_id++;
        int id = IDSystem->customer_id;

        string name = getString("Enter customer name: ");
        string address = getString("Enter customer address: ");

        customer_id.push(id);
        customer_name.push(name);
        customer_address.push(address);

        cout << "Customer added with an ID " << id << "\n" << endl;

        return true;
    }
    catch (exception e)
    {   
        cout << "Unable to add customer." << endl;
        return false;
    }
}

// read customer information
void MovieStore::readCustomer(){
    int id = getInt("Enter customer id: ");
    try {
        queue<int> temp_id = customer_id;
        queue<string> temp_name = customer_name;
        queue<string> temp_address = customer_address;
        while (!temp_id.empty())
        {
            if (temp_id.front() == id)
            {
                cout << "+----------------------+----------------------------------------------------+" << endl;
                cout << "| " << setw(20) << "Customer ID" << " | " << setw(50) << temp_id.front() << " |" << endl; 
                cout << "+----------------------+----------------------------------------------------+" << endl;
                cout << "| " << setw(20) << "Customer Name" << " | " << setw(50) << temp_name.front() << " |" << endl; 
                cout << "+----------------------+----------------------------------------------------+" << endl;
                cout << "| " << setw(20) << "Customer Address" << " | " << setw(50) << temp_address.front() << " |" << endl; 
                cout << "+----------------------+----------------------------------------------------+" << endl;
                return;
            }
            temp_id.pop();
            temp_name.pop();
            temp_address.pop();
        }
    } catch (exception e)
    {
        cout << "Unable to read customer." << endl;
    }
}

// rent a video
bool MovieStore::addRent(){
    try {
        queue<int> temp_id = customer_id;
        queue<string> temp_name = customer_name;
        queue<string> temp_address = customer_address;

        if(temp_id.empty()){
            cout << "No customers to rent a video." << endl;
            return false;
        }

        int t_customer_id = getIntDefault("Enter customer id", temp_id.front());
        bool found_customer = false;
        while (!temp_id.empty())
        {
            if (temp_id.front() == t_customer_id)
            {   
                found_customer = true;
                cout << "+----------------------+----------------------------------------------------+" << endl;
                cout << "| " << setw(20) << "Customer ID" << " | " << setw(50) << temp_id.front() << " |" << endl; 
                cout << "+----------------------+----------------------------------------------------+" << endl;
                cout << "| " << setw(20) << "Customer Name" << " | " << setw(50) << temp_name.front() << " |" << endl; 
                cout << "+----------------------+----------------------------------------------------+" << endl;
                cout << "| " << setw(20) << "Customer Address" << " | " << setw(50) << temp_address.front() << " |" << endl; 
                cout << "+----------------------+----------------------------------------------------+" << endl;
                break;
            }
            temp_id.pop();
            temp_name.pop();
            temp_address.pop();
        }
        if(!found_customer){
            cout << "Customer not found. Please try again later." << endl;
            return false;
        }
        

        while(true){
            int t_video_id = getInt("Enter video id: ");
            Videos *temp = videos;
            bool video_found = false;
            bool has_copy = false;
            while (temp != NULL)
            {
                if (temp->id == t_video_id)
                {   
                    video_found = true;
                    cout << "+-------------------------------------------------------+" << endl;
                    cout << "| " << setw(20) << "Video ID" << " | " << setw(30) << temp->id << " |" << endl; 
                    cout << "| " << setw(20) << "Movie Title" << " | " << setw(30) << temp->title << " |" << endl; 
                    cout << "| " << setw(20) << "Number of Copies" << " | " << setw(30) << temp->copies << " |" << endl; 
                    cout << "+-------------------------------------------------------+" << endl;
                    if( temp->copies > 0) {
                        temp->copies--;
                        temp->available = temp->copies > 0 ? "Available" : "Unavailable";
                        rent_customer_id.push(t_customer_id);
                        rent_video_id.push(t_video_id);
                        cout << "Video rented." << endl;
                    } else {
                        cout << "No copies available." << endl;
                    }
                    break;
                }
                temp = temp->next;
            }

            if(!video_found)
            {
                cout << "Video not found." << endl;
            }

            // ask if user wants to rent another video
            string answer = getString("Do you want to rent another video? (y/n): ");
            if (!(answer == "y" || answer == "Y"))
            {
                break;
            }
        }


        return true;
    } catch (exception e)
    {
        cout << "Unable to rent video." << endl;
        return false;
    }
}

// return a video
bool MovieStore::removeRent(){
    try {
        int id = getInt("Enter Customer ID: ");
        queue<int> temp_id = customer_id;
        queue<string> temp_name = customer_name;
        queue<string> temp_address = customer_address;

        bool found_customer = false;

        while (!temp_id.empty())
        {
            if (temp_id.front() == id)
            {   
                found_customer = true;
                cout << "+----------------------+----------------------------------------------------+" << endl;
                cout << "| " << setw(20) << "Customer ID" << " | " << setw(50) << temp_id.front() << " |" << endl; 
                cout << "+----------------------+----------------------------------------------------+" << endl;
                cout << "| " << setw(20) << "Customer Name" << " | " << setw(50) << temp_name.front() << " |" << endl; 
                cout << "+----------------------+----------------------------------------------------+" << endl;
                cout << "| " << setw(20) << "Customer Address" << " | " << setw(50) << temp_address.front() << " |" << endl; 
                cout << "+----------------------+----------------------------------------------------+" << endl;
                break;
            }
            temp_id.pop();
            temp_name.pop();
            temp_address.pop();
        }

        if (!found_customer)
        {
            cout << "Customer not found." << endl;
            return false;
        }

        cout << "Videos Rented..." << endl;
        stack<int> trc_id = rent_customer_id;
        stack<int> trv_id = rent_video_id;

        stack<int> * ntrc_id = new stack<int>;
        stack<int> * ntrv_id = new stack<int>;

        int video_return_counter = 0;

        while (!trc_id.empty())
        {   
            bool video_found = false;
            if (trc_id.top() == id)
            {
                cout << "Video ID: " << trv_id.top() << endl;;
                // search video in video list and increment copies
                Videos *temp = videos;
                while (temp != NULL)
                {
                    if (temp->id == trv_id.top())
                    {   
                        video_found = true;
                        video_return_counter++;
                        temp->copies++;
                        temp->available = temp->copies > 0 ? "Available" : "Unavailable";
                        break;
                    }
                    temp = temp->next;
                }
            }

            // add to new stack if video not found
            if (!video_found)
            {
                ntrc_id->push(trc_id.top());
                ntrv_id->push(trv_id.top());
            }
            
            trv_id.pop();
            trc_id.pop();
        }
        if(video_return_counter > 0) {
            rent_customer_id = *ntrc_id;
            rent_video_id = *ntrv_id;
            cout << "Rented Video(s) have been returned." << endl;
        } else {
            cout << "No videos rented." << endl;
        }
        
        return true;
    } catch (exception e){
        cout << "Unable to return video." << endl;
        return false;
    }
}

// read customer rent information
void MovieStore::readCustomerRentals(){
    try {
        int id = getInt("Enter customer id: ");

        // print customer data in a table
        queue<int> temp_id = customer_id;
        queue<string> temp_name = customer_name;
        queue<string> temp_address = customer_address;
        while (!temp_id.empty())
        {
            if (temp_id.front() == id)
            {
                cout << "+----------------------+----------------------------------------------------+" << endl;
                cout << "| " << setw(20) << "Customer ID" << " | " << setw(50) << temp_id.front() << " |" << endl; 
                cout << "+----------------------+----------------------------------------------------+" << endl;
                cout << "| " << setw(20) << "Customer Name" << " | " << setw(50) << temp_name.front() << " |" << endl; 
                cout << "+----------------------+----------------------------------------------------+" << endl;
                cout << "| " << setw(20) << "Customer Address" << " | " << setw(50) << temp_address.front() << " |" << endl; 
                cout << "+----------------------+----------------------------------------------------+" << endl;
                break;
            }
            temp_id.pop();
            temp_name.pop();
            temp_address.pop();
        }

        // print customer rent data in a table
        cout << "\nList of Videos Rented..." << endl;
        stack<int> trc_id = rent_customer_id;
        stack<int> trv_id = rent_video_id;

        cout << "+----------------------+--------------------------------+" << endl;
        cout << "| " << setw(20) << "Video ID" << " | " << setw(30) << "Movie Title" << " |" << endl; 
        cout << "+----------------------+--------------------------------+" << endl;
        while (!trc_id.empty())
        {    
            if (trc_id.top() == id)
            {
                Videos *temp = videos;
                while (temp != NULL)
                {   
                    if (temp->id == trv_id.top())
                    {
                        cout << "| " << setw(20) << temp->id << " | " << setw(30) << temp->title << " |" << endl;
                    }
                    temp = temp->next;
                }
            }
            trc_id.pop();
            trv_id.pop();
        }
        cout << "+----------------------+--------------------------------+" << endl;
    } catch (exception e){
        cout << "Unable to read customer rentals." << endl;
    }
}

// load data from files
void MovieStore::loadData(){
    // read ID file
    IDNode * newIDSystem = new IDNode();
    newIDSystem->customer_id = 0;
    newIDSystem->video_id = 0;
    ifstream idFile(ID_FILE);
    if (idFile.is_open())
    {
        string line;
        getline(idFile, line);
        // get string length
        if(line.length() > 0 && line.find(DATA_DELIMITER) != string::npos)
        {
            char lastChar = line[line.length() - 1];
            if(lastChar == '\n') line.erase(line.length() - 1);
            vector<string> data = explode(line, DATA_DELIMITER);
            stringstream ssa(data[0]);
            ssa >> newIDSystem->customer_id;
            stringstream ssb(data[1]);
            ssb >> newIDSystem->video_id;
        }

        idFile.close();
    }
    IDSystem = newIDSystem;

    // read videos file
    try {
        ifstream file(VIDEOS_FILE);
        if (file.is_open())
        {
            string line;
            while (getline(file, line))
            {
                vector<string> data = explode(line, DATA_DELIMITER);
                Videos *newVideo = new Videos();

                stringstream ss(data[0]);
                int id;
                ss >> id;
                newVideo->id = id;

                newVideo->title = data[1];
                newVideo->genre = data[2];
                newVideo->production = data[3];

                stringstream ss2(data[4]);
                int copies;
                ss2 >> copies;
                newVideo->copies = copies;

                newVideo->available = data[5];
                newVideo->filename = data[6];
                if (videos == NULL)
                {
                    videos = newVideo;
                }
                else
                {
                    Videos *temp = videos;
                    while (temp->next != NULL)
                    {
                        temp = temp->next;
                    }
                    temp->next = newVideo;
                }
            }
            file.close();
        }
    } catch (exception e)
    {
        cout << "Unable to load videos from file" << endl;
    }

    // load customers from file
    try {
        ifstream file(CUSTOMERS_FILE);
        if (file.is_open())
        {
            string line;
            while (getline(file, line))
            {
                vector<string> data = explode(line, DATA_DELIMITER);
                stringstream ss(data[0]);
                int id;
                ss >> id;
                
                customer_id.push(id);
                customer_name.push(data[1]);
                customer_address.push(data[2]);
            }
            file.close();
        }
    } catch (exception e)
    {
        cout << "Unable to load customers from file" << endl;
    }

    // load rented videos from file
    try {
        ifstream file(CUSTOMER_RENT_FILE);
        if (file.is_open())
        {
            string line;
            while (getline(file, line))
            {   
                vector<string> data = explode(line, DATA_DELIMITER);
                stringstream ss(data[0]);
                int tc_id;
                ss >> tc_id;
                rent_customer_id.push(tc_id);

                stringstream ss2(data[1]);
                int tv_id;
                ss2 >> tv_id;
                rent_video_id.push(tv_id);
            }
            
            file.close();
        }
    } catch (exception e)
    {
        cout << "Unable to load rented videos from file" << endl;
    }

}

// save data to files
void MovieStore::saveData(){
    // write ID file
    ofstream file(ID_FILE, ios::trunc | ios::out);
    if (file.is_open())
    {
        file << IDSystem->customer_id << DATA_DELIMITER << IDSystem->video_id << endl;
        file.close();
    }

    // write videos file
    try {
        ofstream file(VIDEOS_FILE, ios::trunc | ios::out);
        if (file.is_open())
        {
            Videos *temp = videos;
            while (temp != NULL)
            {
                file << temp->id << DATA_DELIMITER << temp->title << DATA_DELIMITER << temp->genre << DATA_DELIMITER << temp->production << DATA_DELIMITER << temp->copies << DATA_DELIMITER << temp->available << DATA_DELIMITER << temp->filename << endl;
                temp = temp->next;
            }
            file.close();
        } 
        else
        {
            cout << "Unable to open " << VIDEOS_FILE << ". Failed so save videos" << endl;
        }
    } catch (exception e)
    {
        cout << "Unable to save videos." << endl;
    }

    // write customers file
    try {
        ofstream file(CUSTOMERS_FILE, ios::trunc | ios::out);
        if (file.is_open())
        {
            queue<int> temp_id = customer_id;
            queue<string> temp_name = customer_name;
            queue<string> temp_address = customer_address;
            while (!temp_id.empty())
            {
                file << temp_id.front() << DATA_DELIMITER << temp_name.front() << DATA_DELIMITER << temp_address.front() << endl;
                temp_id.pop();
                temp_name.pop();
                temp_address.pop();
            }

            file.close();
        }
    } catch (exception e)
    {
        cout << "Unable to save customer." << endl;
    }
    
    // save rented videos
    try {
        ofstream file(CUSTOMER_RENT_FILE, ios::trunc | ios::out);
        if(file.is_open())
        {
            stack<int> temp_customer_id = rent_customer_id;
            stack<int> temp_video_id = rent_video_id;

            while(!temp_customer_id.empty())
            {
                file << temp_customer_id.top() << DATA_DELIMITER << temp_video_id.top() << endl;
                temp_customer_id.pop();
                temp_video_id.pop();
            }

            file.close();
        }
    } catch (exception e)
    {
        cout << "Unable to save customer rented videos." << endl;
    }
}