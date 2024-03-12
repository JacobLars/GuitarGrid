import React, { SetStateAction } from "react";
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
    <div>
      <input
        value={searchTerm}
        placeholder="Search"
        className="border border-slate-900"
        onChange={handleOnChange}
      ></input>
    </div>
  );
};
