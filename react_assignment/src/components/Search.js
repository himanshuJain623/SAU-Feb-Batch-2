import React from "react";

function Search(props) {
    
    const {searchBooks}=props;

  return (
        <div className="search-container">
            <input type="text" placeholder="Search books here.." onChange={(event)=>{
                searchBooks(event.target.value);
            }} />
        </div>
    );
}

export default Search;
