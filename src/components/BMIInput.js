import React from "react"

function BMIInput({ myInput, value, onChange}) {
    return(
        <>
            <div id="age">
                <h5>{myInput}</h5>
                <input 
                    placeholder={`Enter your ${myInput}`}
                    value={value}
                    onChange={onChange}
                    required
                ></input>
            </div>
        </>
    )
}

export default BMIInput