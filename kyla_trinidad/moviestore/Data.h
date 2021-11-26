#pragma once
#ifndef _DATA_H_
#define _DATA_H_

#include <iostream>
#include <queue>
#include <stack>

using namespace std;

namespace ns
{
    class MovieStore
    {
    private:
        struct IDNode
        {
            int video_id;
            int customer_id;
        } * IDSystem;
        
        struct Videos
        {
            int id;              // movie id
            string title;        // movie title
            string genre;        // movie genre
            string production;   // production company
            int copies;          // number of copies
            string filename;     // movie image filename
            string available;    // Available | Unavailable
            Videos *next = NULL; // pointer to next node
        } * videos;

        queue<int> customer_id;         // list if auto generated customer id
        queue<string> customer_name;    // customer name
        queue<string> customer_address; // customer address

        stack<int> rent_video_id;    // id from Videos
        stack<int> rent_customer_id; // id from Customers

    public:
        MovieStore();
        ~MovieStore();
        int getInt(string msg);
        string getString(string msg);
        vector<string> explode(string str, string delim);
        bool addVideo();
        void readVideo(bool availability);
        void readVideos();
        bool addCustomer();
        void readCustomer();
        void readCustomers();
        void readCustomerRentals();
        bool addRent();
        bool removeRent();
        void loadData();
        void saveData();
    };
}

#endif