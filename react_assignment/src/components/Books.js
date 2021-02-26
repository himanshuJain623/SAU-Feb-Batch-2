import React, { useEffect, useState } from "react";
import data from "../utils/data.js";
import Card from "./Card";
import Search from "./Search.js";


function Books() {
  const [books, setBooks] = useState([]);
  const [searchItem,setSearchItem]=useState("");

  const getBooks = () => {
    setBooks(data);
  };
  const searchBooks=(value)=>{
    setSearchItem(value);
  };

  useEffect(() => {
    getBooks();
  },[]);
  
  return (
    <div>
      <Search searchBooks={searchBooks}/>
      <section className="books-container">
        {books.filter((book)=>{
            if(searchItem==="")
                return book;
            else if(book.name.toLowerCase().includes(searchItem.toLowerCase()))
                return book;
        }).map((book,index) => {
          return <Card key={book.id} book={book} />;
        })}
      </section>
    </div>
  );
}
export default Books;
