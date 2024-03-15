import React, { SetStateAction } from "react";
import { FilterByRating } from "./FilterByRating";
type Props = {
  searchTerm: string;
  setSearchTerm: Function;
};
export const SearchBar = ({ setSearchTerm, searchTerm }: Props) => {
  const handleOnChange = (event: {
    target: { value: SetStateAction<string> };
  }) => {
    setSearchTerm(event.target.value);
  };

  return (
    <div className="w-full flex">
      <input
        value={searchTerm}
        placeholder=" Search product or brand"
        className="border border-slate-600 mx-auto w-3/4 h-10 mt-5 shadow-md rounded-md"
        onChange={handleOnChange}
      ></input>
    </div>
  );
};
