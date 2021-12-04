#pragma once
#ifndef _DATA_H_
#define _DATA_H_

#include <iostream>
#include <string>
using namespace std;

namespace ns
{
	class MovieList
	{
	private:
		struct Node
		{
			std::string code;
			std::string title;
			std::string genre;
			int year;
			struct Node *next;
		};
		Node *head;

	public:
		MovieList();
		~MovieList();
		void insertMovie(std::string code, std::string title, std::string genre, int year);
		void rentMovie(std::string code);
		void returnMovie(std::string code, std::string title, std::string genre, int year);
		void showMovieDetails(std::string code);
		void printMovieList();
	};
}

#endif